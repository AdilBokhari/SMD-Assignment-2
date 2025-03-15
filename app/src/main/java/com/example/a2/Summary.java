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

public class Summary extends AppCompatActivity {

    EditText etSummary;
    Button btnSubmitSummary,btnCancelSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        Intent intent=getIntent();
        String s=intent.getStringExtra("summary");
        if (s!=null)
        {
            etSummary.setText(s);
        }
        btnSubmitSummary.setOnClickListener((v)->{
            String summary=etSummary.getText().toString();
            Intent i = new Intent();
            i.putExtra("summary",summary);
            setResult(RESULT_OK,i);
            finish();
        });

        btnCancelSummary.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init()
    {
        etSummary=findViewById(R.id.etSummary);
        btnSubmitSummary=findViewById(R.id.btnSubmitSummary);
        btnCancelSummary=findViewById(R.id.btnCancelSummary);
    }
}