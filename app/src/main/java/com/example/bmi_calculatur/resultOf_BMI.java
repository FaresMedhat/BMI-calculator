package com.example.bmi_calculatur;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resultOf_BMI extends AppCompatActivity {
    TextView BMI , Gender , Age , Note;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result_of_bmi);
        back = findViewById(R.id.btn_back);
        BMI = findViewById(R.id.txtBMI);
        Gender = findViewById(R.id.txtGender);
        Age = findViewById(R.id.txtAge);
        Note = findViewById(R.id.Note_txt);
        Intent intent = getIntent();
        double Result = intent.getDoubleExtra("Result", 0.0);
        int Age1 = intent.getIntExtra("Age", 0);
        String Gender1 = intent.getStringExtra("Gender");
        BMI.setText(String.format("BMI :%.2f", Result));
        Gender.setText(Gender1);
        Age.setText( Age1 +" years");
        if (Result < 18.5) {
            Note.setText("Underweight");
        } else if (Result >= 18.5 & Result <= 24.9) {
            Note.setText("Normal Weight");
        } else if (Result >= 25.0 & Result <= 29.9) {
            Note.setText("Overweight");
        }
        else if (Result >= 30.0 & Result <= 34.9) {
            Note.setText("Obesity (Class 1)");
        }
        else if (Result >= 35.0 & Result <= 39.9) {
            Note.setText("Obesity (Class 2)");
        }
        else if (Result >= 40.0) {
            Note.setText("Severer Obesity (Class 3)");
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(resultOf_BMI.this,MainActivity.class);
                startActivity(intent1);
            }
        });

        }


    }