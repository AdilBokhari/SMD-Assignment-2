package com.example.a2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PreviewCV extends AppCompatActivity {

    ImageView ivProfilePic;
    TextView tvName,tvEmail,tvPhoneNo,tvSummary,tvEducation,tvExperience,tvCert,tvRef;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preview_cv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        Intent i = getIntent();
        String name=i.getStringExtra("name");
        String email=i.getStringExtra("email");
        String phoneNo=i.getStringExtra("phoneNo");
        String summary=i.getStringExtra("summary");
        String education=i.getStringExtra("education");
        String experience=i.getStringExtra("experience");
        String cert=i.getStringExtra("cert");
        String ref=i.getStringExtra("ref");
        if (i.hasExtra("image"))
        {
            String img=i.getStringExtra("image");
            Uri image= Uri.parse(img);
            ivProfilePic.setImageURI(image);
        }
        else
        {
            ivProfilePic.setImageResource(R.drawable.def);
        }

        StringBuilder CV=new StringBuilder();

        if(name!=null && !name.isEmpty())
        {
            tvName.setText(name);
            CV.append("Name: ");
            CV.append(name);
            CV.append("\n");
        }
        if(email!=null && !email.isEmpty())
        {
            tvEmail.setText(email);
            CV.append("\nEmail: ");
            CV.append(email);
            CV.append("\n");
        }
        if(phoneNo!=null && !phoneNo.isEmpty())
        {
            tvPhoneNo.setText(phoneNo);
            CV.append("\nPhone: ");
            CV.append(phoneNo);
            CV.append("\n");
        }
        if(summary!=null && !summary.isEmpty())
        {
            tvSummary.setText(summary);
            CV.append("\nSummary:\n");
            CV.append(summary);
            CV.append("\n");
        }
        if(education!=null && !education.isEmpty())
        {
            tvEducation.setText(education);
            CV.append("\nEducation:\n");
            CV.append(education);
            CV.append("\n");
        }
        if(experience!=null && !experience.isEmpty())
        {
            tvExperience.setText(experience);
            CV.append("\nExperience:\n");
            CV.append(experience);
            CV.append("\n");
        }
        if(cert!=null && !cert.isEmpty())
        {
            tvCert.setText(cert);
            CV.append("\nCertifications:\n");
            CV.append(cert);
            CV.append("\n");
        }
        if(ref!=null && !ref.isEmpty())
        {
            tvRef.setText(ref);
            CV.append("\nReferences:\n");
            CV.append(ref);
            CV.append("\n");
        }
        btnShare.setOnClickListener((v)->{
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,CV.toString());
            intent.setType("text/*");
            startActivity(intent);
        });
    }
    private void init()
    {
        ivProfilePic=findViewById(R.id.ivProfilePic);
        tvName=findViewById(R.id.tvName);
        tvEmail=findViewById(R.id.tvEmail);
        tvPhoneNo=findViewById(R.id.tvPhoneNo);
        tvSummary=findViewById(R.id.tvSummary);
        tvEducation=findViewById(R.id.tvEducation);
        tvExperience=findViewById(R.id.tvExperience);
        tvCert=findViewById(R.id.tvCert);
        tvRef=findViewById(R.id.tvRef);
        btnShare=findViewById(R.id.btnShare);
    }
}