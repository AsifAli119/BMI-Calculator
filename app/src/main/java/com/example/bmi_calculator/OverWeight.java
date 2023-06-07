package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class OverWeight extends AppCompatActivity {
    TextView textView;
    private ValueAnimator animator;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_weight);
        textView = findViewById(R.id.overWeihgt);
        animationView = findViewById(R.id.checkingO);


        // Create a ValueAnimator
        animator = ValueAnimator.ofFloat(0f, 10f);
        animator.setDuration(3000); // Set the animation duration (in milliseconds)
        animator.addUpdateListener(animation -> {
            // Get the current progress of the animation
            float progress = (float) animation.getAnimatedValue();

            // Update the text based on the animation progress or any other condition
            if (progress >= 3.0f) {
                textView.setText("You are OverWeighted");
            } else {
                textView.setText("Calculating");
            }
        });

        // Start the animation
        animator.start();
    }
}