package com.example.lettinggo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LetGoActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setAnimation();
        setContentView(R.layout.activity_let_go2);

    }


    //When let Go button is pressed
    public void letGo(View view) {
        EditText inputText = (EditText) findViewById(R.id.input_text);
        EditText whyText = (EditText) findViewById(R.id.why_text);
        Button letGoButton = (Button) findViewById(R.id.let_go_button);
        Button exitButton = (Button) findViewById(R.id.exit_button);


        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(3000);
        fadeOut.setFillAfter(true);
        AlphaAnimation fadeIn = new AlphaAnimation(0.5f, 1.0f);
        fadeIn.setDuration(3000);
        fadeIn.setFillAfter(true);

        exitButton.startAnimation(fadeIn);
        inputText.startAnimation(fadeOut);
        whyText.startAnimation(fadeOut);
        letGoButton.startAnimation(fadeOut);
        //inputText.setVisibility(View.GONE);
        //whyText.setVisibility(View.GONE);
    }


    //When exit button is pressed
    public void exitClick(View v) {
        finish();
        System.exit(0);
    }

    //Incoming transition

    public void setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.LEFT);
            slide.setDuration(400);
            slide.setInterpolator(new AccelerateDecelerateInterpolator());
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }
    }

}