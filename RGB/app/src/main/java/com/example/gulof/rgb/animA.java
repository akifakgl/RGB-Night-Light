package com.example.gulof.rgb;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;

public class animA extends AppCompatActivity {
    private TextView tv;
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        tv = findViewById(R.id.txt);
        im = findViewById(R.id.green);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanim);
        tv.startAnimation(myanim);
        im.startAnimation(myanim);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent intent= new Intent(animA.this,MainActivity.class);
                startActivity(intent);
            }
        }, 2500);



/*
        //SONRADAN EKLEDİĞİM KISIM REKLAMI ÖNECEDEN YÜKLEYEBİLMEK İÇİN...
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
*/



    }


}
