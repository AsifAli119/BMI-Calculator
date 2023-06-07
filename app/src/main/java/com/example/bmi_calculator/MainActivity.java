package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight, heightFt,heightIn;
        LottieAnimationView checkResult ;
        weight = findViewById(R.id.weightKg);
        heightFt = findViewById(R.id.heightFt);
        heightIn = findViewById(R.id.heightInch);
        checkResult = findViewById(R.id.btnCheck);
        checkResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(weight.getText().toString());
                int ft = Integer.parseInt(heightFt.getText().toString());
                int inc = Integer.parseInt(heightIn.getText().toString());
                int totalin = ft * 12 + inc;
                double totalCm = totalin * 2.53;
                double totalM = totalCm / 100;
                double BMI = wt / (totalM * totalM);
                if (BMI > 25) {
                    startActivity(new Intent(MainActivity.this, OverWeight.class));
                    finish();
                } else if (BMI < 18) {
                    startActivity(new Intent(MainActivity.this, UnderWeight.class));
                    finish();

                } else {
                    startActivity(new Intent(MainActivity.this, Healthy.class));
                    finish();
                }
            }
        });
    }
}