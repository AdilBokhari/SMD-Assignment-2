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

public class PersonalDetails extends AppCompatActivity {
    EditText etName,etEmail,etPhoneNo;
    Button btnSubmit,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        Intent intent=getIntent();
        String n=intent.getStringExtra("name");
        String e=intent.getStringExtra("email");
        String p=intent.getStringExtra("phoneNo");
        if (n!=null)
        {
            etName.setText(n);
        }
        if (e!=null)
        {
            etEmail.setText(e);
        }
        if (p!=null)
        {
            etPhoneNo.setText(p);
        }
        btnSubmit.setOnClickListener((v)->{
            String name=etName.getText().toString();
            String email=etEmail.getText().toString();
            String phoneNo=etPhoneNo.getText().toString();
            Intent i = new Intent();
            i.putExtra("name",name);
            i.putExtra("email",email);
            i.putExtra("phoneNo",phoneNo);
            setResult(RESULT_OK,i);
            finish();
        });
        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init(){
        etName=findViewById(R.id.etName);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnCancel=findViewById(R.id.btnCancel);
        etEmail=findViewById(R.id.etEmail);
        etPhoneNo=findViewById(R.id.etPhoneNo);
    }
}