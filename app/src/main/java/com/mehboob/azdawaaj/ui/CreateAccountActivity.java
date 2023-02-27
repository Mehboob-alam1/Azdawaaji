package com.mehboob.azdawaaj.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mehboob.azdawaaj.R;
import com.mehboob.azdawaaj.databinding.ActivityCreateAccountBinding;
import com.mehboob.azdawaaj.ui.adapters.GridAdapter;

public class CreateAccountActivity extends AppCompatActivity {
    private ActivityCreateAccountBinding binding;
    private String[] items= {"Self","Parent","Sibling","Relative","Friend"};
    private GridAdapter gridAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        gridAdapter = new GridAdapter(this,items);

        binding.gridProfile.setAdapter(gridAdapter);

        binding.gridProfile.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, ""+items[position].toString(), Toast.LENGTH_SHORT).show();
        });


    }
}