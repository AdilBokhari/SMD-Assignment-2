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
    String name,email,phoneNo,summary;
    Uri image;
    ActivityResultLauncher<Intent> getImageLauncher;
    ActivityResultLauncher<Intent> getPersonalDetailsLauncher;
    ActivityResultLauncher<Intent> getSummaryLauncher;
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


        btnPreview.setOnClickListener((v)->{
            Intent i=new Intent(this, PreviewCV.class);
            if (image != null) {
                i.putExtra("image",image.toString());
            }
            i.putExtra("name",name);
            i.putExtra("email",email);
            i.putExtra("phoneNo",phoneNo);
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
    }
}