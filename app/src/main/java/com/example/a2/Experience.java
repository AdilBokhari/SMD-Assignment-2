package com.example.a2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Experience extends AppCompatActivity {

    EditText etExperience;
    Button btnSubmitExperience,btnCancelExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_experience);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        Intent intent=getIntent();
        String e=intent.getStringExtra("experience");
        if (e!=null)
        {
            etExperience.setText(e);
        }
        btnSubmitExperience.setOnClickListener((v)->{
            String experience =etExperience.getText().toString();
            Intent i = new Intent();
            i.putExtra("experience", experience);
            setResult(RESULT_OK,i);
            finish();
        });

        btnCancelExperience.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });

    }
    private void init()
    {
        etExperience=findViewById(R.id.etExperience);
        btnSubmitExperience=findViewById(R.id.btnSubmitExperience);
        btnCancelExperience=findViewById(R.id.btnCancelExperience);
    }
}