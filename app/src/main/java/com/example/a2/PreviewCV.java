package com.example.a2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
        if(name!=null && !name.isEmpty())
        {
            tvName.setText(name);
        }
        if(email!=null && !email.isEmpty())
        {
            tvEmail.setText(email);
        }
        if(phoneNo!=null && !phoneNo.isEmpty())
        {
            tvPhoneNo.setText(phoneNo);
        }
        if(summary!=null && !summary.isEmpty())
        {
            tvSummary.setText(summary);
        }
        if(education!=null && !education.isEmpty())
        {
            tvEducation.setText(education);
        }
        if(experience!=null && !experience.isEmpty())
        {
            tvExperience.setText(experience);
        }
        if(cert!=null && !cert.isEmpty())
        {
            tvCert.setText(cert);
        }
        if(ref!=null && !ref.isEmpty())
        {
            tvRef.setText(ref);
        }
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
    }
}