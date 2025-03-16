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

public class Ref extends AppCompatActivity {
    EditText etRef;
    Button btnSubmitRef,btnCancelRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ref);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent intent=getIntent();
        String r=intent.getStringExtra("ref");
        if (r!=null)
        {
            etRef.setText(r);
        }
        btnSubmitRef.setOnClickListener((v)->{
            String ref=etRef.getText().toString();
            Intent i = new Intent();
            i.putExtra("ref",ref);
            setResult(RESULT_OK,i);
            finish();
        });

        btnCancelRef.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init()
    {
        etRef=findViewById(R.id.etRef);
        btnSubmitRef=findViewById(R.id.btnSubmitRef);
        btnCancelRef=findViewById(R.id.btnCancelRef);
    }
}