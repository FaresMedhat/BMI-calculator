package com.example.bmi_calculatur;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash_Screen extends AppCompatActivity {
    TextView txt_address;
    ImageView img_Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        txt_address=findViewById(R.id.txt_title);
        img_Logo = findViewById(R.id.img_Logo);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);

    }
}