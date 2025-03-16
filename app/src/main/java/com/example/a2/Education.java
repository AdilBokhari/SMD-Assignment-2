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

public class Education extends AppCompatActivity {

    EditText etEducation;
    Button btnSubmitEducation,btnCancelEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        Intent intent=getIntent();
        String e=intent.getStringExtra("education");
        if (e!=null)
        {
            etEducation.setText(e);
        }
        btnSubmitEducation.setOnClickListener((v)->{
            String education =etEducation.getText().toString();
            Intent i = new Intent();
            i.putExtra("education", education);
            setResult(RESULT_OK,i);
            finish();
        });

        btnCancelEducation.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init()
    {
        etEducation=findViewById(R.id.etEducation);
        btnSubmitEducation=findViewById(R.id.btnSubmitEducation);
        btnCancelEducation=findViewById(R.id.btnCancelEducation);
    }
}