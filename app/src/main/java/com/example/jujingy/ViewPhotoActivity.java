package com.example.jujingy;


import static com.example.jujingy.PhotoData.getPhotoById;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewPhotoActivity extends AppCompatActivity {
    TextView txt;
    private long photoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

        txt = findViewById(R.id.txtDes);
        Intent intent = getIntent();
        if (intent != null) {
            photoId = intent.getLongExtra("id", 0);

            Photo photo= getPhotoById((int) photoId );

            txt.setText(photo.getDescription_photo());


        }
    }
}