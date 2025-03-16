package com.example.a2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {
    ImageView ivProfilePicture;
    Button btnProfilePic,btnPersonalDetails,btnSummary,btnEducation,btnExperience,btnCertifications,btnReferences,btnPreview;
    String name,email,phoneNo,summary,education,experience,cert,ref;
    Uri image;
    ActivityResultLauncher<Intent> getImageLauncher;
    ActivityResultLauncher<Intent> getPersonalDetailsLauncher;
    ActivityResultLauncher<Intent> getSummaryLauncher;
    ActivityResultLauncher<Intent> getEducationLauncher;
    ActivityResultLauncher<Intent> getExperienceLauncher;
    ActivityResultLauncher<Intent> getCertLauncher;
    ActivityResultLauncher<Intent> getRefLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        btnProfilePic.setOnClickListener((v)->{
            Intent i=new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            getImageLauncher.launch(i);
        });
        btnPersonalDetails.setOnClickListener((v)->{
            Intent i=new Intent(this, PersonalDetails.class);
            i.putExtra("name",name);
            i.putExtra("email",email);
            i.putExtra("phoneNo",phoneNo);
            getPersonalDetailsLauncher.launch(i);
        });

        btnSummary.setOnClickListener((v)->{
            Intent i=new Intent(this, Summary.class);
            i.putExtra("summary",summary);
            getSummaryLauncher.launch(i);
        });

        btnEducation.setOnClickListener((v)->{
            Intent i=new Intent(this, Education.class);
            i.putExtra("education",education);
            getEducationLauncher.launch(i);
        });

        btnExperience.setOnClickListener((v)->{
            Intent i=new Intent(this, Experience.class);
            i.putExtra("experience",experience);
            getExperienceLauncher.launch(i);
        });

        btnCertifications.setOnClickListener((v)->{
            Intent i=new Intent(this, Cert.class);
            i.putExtra("cert",cert);
            getCertLauncher.launch(i);
        });

        btnReferences.setOnClickListener((v)->{
            Intent i=new Intent(this, Ref.class);
            i.putExtra("ref",ref);
            getRefLauncher.launch(i);
        });

        btnPreview.setOnClickListener((v)->{
            Intent i=new Intent(this, PreviewCV.class);
            if (image != null) {
                i.putExtra("image",image.toString());
            }
            i.putExtra("name",name);
            i.putExtra("email",email);
            i.putExtra("phoneNo",phoneNo);
            i.putExtra("summary",summary);
            i.putExtra("education",education);
            i.putExtra("experience",experience);
            i.putExtra("cert",cert);
            i.putExtra("ref",ref);
            startActivity(i);
        });
    }
    private void init(){
        ivProfilePicture=findViewById(R.id.ivProfilePicture);
        btnProfilePic = findViewById(R.id.btnProfilePic);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnSummary = findViewById(R.id.btnSummary);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnCertifications = findViewById(R.id.btnCertifications);
        btnReferences = findViewById(R.id.btnReferences);
        btnPreview = findViewById(R.id.btnPreview);

        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        image = result.getData().getData();
                        ivProfilePicture.setImageURI(image);
                    }
                    else
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
        getPersonalDetailsLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if (result.getResultCode()==RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getResultCode()==RESULT_OK && result.getData()!=null)
                    {
                        Intent dataIntent=result.getData();
                        name=dataIntent.getStringExtra("name");
                        email=dataIntent.getStringExtra("email");
                        phoneNo=dataIntent.getStringExtra("phoneNo");
                    }
                });

        getSummaryLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if (result.getResultCode()==RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getResultCode()==RESULT_OK && result.getData()!=null)
                    {
                        Intent dataIntent=result.getData();
                        summary=dataIntent.getStringExtra("summary");
                    }
                });
        getEducationLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if (result.getResultCode()==RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getResultCode()==RESULT_OK && result.getData()!=null)
                    {
                        Intent dataIntent=result.getData();
                        education=dataIntent.getStringExtra("education");
                    }
                });
        getExperienceLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if (result.getResultCode()==RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getResultCode()==RESULT_OK && result.getData()!=null)
                    {
                        Intent dataIntent=result.getData();
                        experience=dataIntent.getStringExtra("experience");
                    }
                });
        getCertLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if (result.getResultCode()==RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getResultCode()==RESULT_OK && result.getData()!=null)
                    {
                        Intent dataIntent=result.getData();
                        cert=dataIntent.getStringExtra("cert");
                    }
                });
        getRefLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if (result.getResultCode()==RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                    else if (result.getResultCode()==RESULT_OK && result.getData()!=null)
                    {
                        Intent dataIntent=result.getData();
                        ref=dataIntent.getStringExtra("ref");
                    }
                });
    }
}