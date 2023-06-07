package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class UnderWeight extends AppCompatActivity {
    private ValueAnimator animator;
    TextView underWeight;
    LottieAnimationView animationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_weight);
        underWeight = findViewById(R.id.underWeight);
        animationView = findViewById(R.id.checkingU);



        // Create a ValueAnimator
        animator = ValueAnimator.ofFloat(0f, 10f);
        animator.setDuration(3000); // Set the animation duration (in milliseconds)
        animator.addUpdateListener(animation -> {
            // Get the current progress of the animation
            float progress = (float) animation.getAnimatedValue();

            // Update the text based on the animation progress or any other condition
            if (progress >= 3.0f) {
                underWeight.setText("You are under Weighted");
            } else {
                underWeight.setText("Calculating");
            }
        });

        // Start the animation
        animator.start();
    }
}