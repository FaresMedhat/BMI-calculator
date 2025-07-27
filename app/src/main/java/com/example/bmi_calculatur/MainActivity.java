package com.example.bmi_calculatur;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {
    TextView txt_Hight;
    TextView txtWight ;
    TextView txtAge ;
    TextView male_icon,female_icon;

    Button DC_Age, DC_Weight , IN_Age , IN_Weight ,btn_result;
    ImageView maleIcon,famleIcon;
    LinearLayout ly_female,ly_male;
    TextView txt_seekBar;
    SeekBar seekBar_Hight;
    private int Value = 0 ;

    private int hight = 150 ;
    int weight = 60;
    int age  = 10;
    String Gender ;
    double result = 0.0;
    String hightSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ly_male=findViewById(R.id.ly_male);
        ly_female=findViewById(R.id.ly_female);
        female_icon=findViewById(R.id.female_icon);
        male_icon = findViewById(R.id.male_icon);

        txt_Hight=findViewById(R.id.txt_Hight);
        txt_seekBar= findViewById(R.id.txt_seekBar);
        seekBar_Hight = findViewById(R.id.seekBar_Hight);
        txtAge=findViewById(R.id.txt_Age);
        seekBar_Hight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                hight=progress;
                txt_seekBar.setText(hight+"/"+"cm");

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        btn_result=findViewById(R.id.btn_result);
        hightSeekBar = txt_seekBar.getText().toString();
        Value = Integer.parseInt(hightSeekBar);

        txtWight = findViewById(R.id.value_Of_Weight);

        txtAge = findViewById(R.id.value_Of_Age);

        DC_Age=findViewById(R.id.decrementAge);

        IN_Age=findViewById(R.id.increasmentAge);

        DC_Weight=findViewById(R.id.decrementWeight);

        IN_Weight=findViewById(R.id.increasmentWeight);

        DC_Weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight--;
                txtWight.setText(String.valueOf(weight));
            }
        });

        IN_Weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight++;
                txtWight.setText(String.valueOf(weight));
            }
        });

        DC_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age--;
                txtAge.setText(String.valueOf(age));
            }
        });

        IN_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age++;
                txtAge.setText(String.valueOf(age));

            }
        });
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = calBMI(hight,weight);
                Intent intent = new Intent(MainActivity.this,resultOf_BMI.class);
                intent.putExtra("Result",result);
                intent.putExtra("Gender",Gender);
                intent.putExtra("Age",age);
                startActivity(intent);
                finish();

        }
        });
        ly_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gender=male_icon.getText().toString();
            }
        });
        ly_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Gender=female_icon.getText().toString();
            }
        });



        }
    public  double calBMI (int hight, int weight) {
        if (Value > 0) {
            result = weight / (Math.pow((hight / 100.0), 2));

        }else {
            Toast.makeText(MainActivity.this,"The hight can not be 0",Toast.LENGTH_SHORT).show();
        }
        return result;
    }



    }

