package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Healthy extends AppCompatActivity {
    TextView healthy;
    private ValueAnimator animator;
    LottieAnimationView checking;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy);
        healthy = findViewById(R.id.healthy);


        // Create a ValueAnimator
        animator = ValueAnimator.ofFloat(0f, 10f);
        animator.setDuration(3000); // Set the animation duration (in milliseconds)
        animator.addUpdateListener(animation -> {
            // Get the current progress of the animation
            float progress = (float) animation.getAnimatedValue();

            // Update the text based on the animation progress or any other condition
            if (progress >= 3.0f) {
                healthy.setText("You are healthy");
            } else {
                healthy.setText("Calculating");
            }
        });

        // Start the animation
        animator.start();

    }
}