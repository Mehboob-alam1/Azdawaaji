package com.mehboob.azdawaaj.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


import com.mehboob.azdawaaj.R;
import com.mehboob.azdawaaj.databinding.ActivityCreateAccountBinding;


import java.util.ArrayList;

public class CreateAccountActivity extends AppCompatActivity {
    private ActivityCreateAccountBinding binding;
    private ArrayList<TextView> textViewsCreatedBY = new ArrayList<>();
    private ArrayList<TextView> textViewGender = new ArrayList<>();
    private TextView txtSelf, txtParent, txtSibling, txtRelative, txtFriend;
    private TextView txtMale, txtFemale;
    private TextView selectedCreatedBy;
    private TextView selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setCreatedByView();
        setGender();

        binding.checkBtn.setOnClickListener(v -> {
            if (selectedCreatedBy == null) {
                Toast.makeText(this, "Select for who ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "" + selectedCreatedBy.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            if (selectedGender==null){
                Toast.makeText(this, "Select Gender ", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, ""+selectedGender.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setGender() {
        txtMale = findViewById(R.id.txtMale);
        txtFemale = findViewById(R.id.txtFemale);
        textViewGender.add(txtMale);
        textViewGender.add(txtFemale);

for (TextView textView :textViewGender){
    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (TextView textView:textViewGender){
                if (textView == v) {
                    textView.setBackgroundResource(R.drawable.back_gree);
                    selectedGender = textView;
                    textView.setTextColor(ContextCompat.getColor(CreateAccountActivity.this, R.color.white));
                } else {
                    textView.setBackgroundResource(R.drawable.back_grey);
                    textView.setTextColor(ContextCompat.getColor(CreateAccountActivity.this, R.color.grey));

                }
            }
        }
    });
}
    }

    private void setCreatedByView() {

        txtSelf = findViewById(R.id.txtSelf);
        txtParent = findViewById(R.id.txtParent);
        txtSibling = findViewById(R.id.txtSibling);
        txtRelative = findViewById(R.id.txtRelative);
        txtFriend = findViewById(R.id.txtFriend);
        textViewsCreatedBY.add(txtSelf);
        textViewsCreatedBY.add(txtParent);
        textViewsCreatedBY.add(txtSibling);
        textViewsCreatedBY.add(txtRelative);
        textViewsCreatedBY.add(txtFriend);

        for (TextView textView : textViewsCreatedBY) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (TextView textView : textViewsCreatedBY) {
                        if (textView == view) {
                            textView.setBackgroundResource(R.drawable.back_gree);
                            selectedCreatedBy = textView;
                            textView.setTextColor(ContextCompat.getColor(CreateAccountActivity.this, R.color.white));
                        } else {
                            textView.setBackgroundResource(R.drawable.back_grey);
                            textView.setTextColor(ContextCompat.getColor(CreateAccountActivity.this, R.color.grey));

                        }
                    }
                }
            });
        }

    }


}