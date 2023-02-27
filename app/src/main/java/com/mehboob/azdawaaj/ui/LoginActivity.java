package com.mehboob.azdawaaj.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;

import com.mehboob.azdawaaj.MainActivity;
import com.mehboob.azdawaaj.R;
import com.mehboob.azdawaaj.databinding.ActivityLoginBinding;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegister.setOnClickListener(v -> {
    startActivity(new Intent(LoginActivity.this,CreateAccountActivity.class));
        });
        binding.btnLogin.setOnClickListener(v -> {
            confirmInput();
        });
    }

    public void confirmInput() {
        if (!validateEmail() | !validatePassword()) {
            return;
        } else {

            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }


    }

    private boolean validateEmail() {

        // Extract input from EditText
        String emailInput = binding.etEmailLayout.getEditText().getText().toString().trim();

        // if the email input field is empty
        if (emailInput.isEmpty()) {
            binding.etEmailLayout.setError("Field can not be empty");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            binding.etEmailLayout.setError("Please enter a valid email address");
            return false;
        } else {
            binding.etEmailLayout.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = binding.etPasswordLayout.getEditText().getText().toString().trim();
        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.isEmpty()) {
            binding.etPasswordLayout.setError("Field can not be empty");
            return false;
        }

        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            binding.etPasswordLayout.setError("Password is too weak");
            return false;
        } else {
            binding.etPasswordLayout.setError(null);
            return true;
        }
    }
}