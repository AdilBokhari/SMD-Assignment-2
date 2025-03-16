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

public class Cert extends AppCompatActivity {

    EditText etCert;
    Button btnSubmitCert,btnCancelCert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cert);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        Intent intent=getIntent();
        String c=intent.getStringExtra("cert");
        if (c!=null)
        {
            etCert.setText(c);
        }
        btnSubmitCert.setOnClickListener((v)->{
            String cert=etCert.getText().toString();
            Intent i = new Intent();
            i.putExtra("cert",cert);
            setResult(RESULT_OK,i);
            finish();
        });

        btnCancelCert.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init()
    {
        etCert=findViewById(R.id.etCert);
        btnSubmitCert=findViewById(R.id.btnSubmitCert);
        btnCancelCert=findViewById(R.id.btnCancelCert);
    }
}