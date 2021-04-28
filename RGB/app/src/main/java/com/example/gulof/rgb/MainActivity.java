package com.example.gulof.rgb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    MediaPlayer song1;
    int tiklanma=0,sayi=0,ac1=0,ac2=0,ac3=0,ac4=0,reklam=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
*/



        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//ekranın açık kalamsı için

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        ConstraintLayout constraintLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable=(AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        song1= MediaPlayer.create(MainActivity.this,R.raw.after);
        ImageView  imageplan1=findViewById(R.id.coffee);
        ImageView  imageplan2=findViewById(R.id.rainbow);
        ImageView  imageplan3=findViewById(R.id.relaxing);
        ImageView  imageplan4=findViewById(R.id.london);
        ImageView  imageplan5=findViewById(R.id.pie);
        ImageView  imageplan6=findViewById(R.id.darkmagic);
        ImageView  imageplan7=findViewById(R.id.miami);
        ImageView  imageplan8=findViewById(R.id.green);
        ImageView  imageplan9=findViewById(R.id.red);
        final ImageView  ses=findViewById(R.id.ses);


        song1.start();
        song1.setLooping(true);

        imageplan2.setImageResource(R.drawable.kilit);
        imageplan3.setImageResource(R.drawable.kilit);
        imageplan6.setImageResource(R.drawable.kilit);
        imageplan9.setImageResource(R.drawable.kilit);


        imageplan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                if(reklam==1||reklam==3||reklam==5||reklam==7||reklam==9){
                    showIntAdd();
                }
                reklam++;

            }
        });




        imageplan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ac1==0){
                    sayi=2;
                    showIntAdd();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,rainbowA.class);
                    startActivity(intent);
                }


            }
        });

        imageplan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ac2==0){
                    sayi=3;
                    showIntAdd();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,relaxingA.class);
                    startActivity(intent);
                }

            }
        });
        imageplan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,londonA.class);
                startActivity(intent);
                if(reklam==1||reklam==3||reklam==5||reklam==7||reklam==9){
                    showIntAdd();
                }
                reklam++;

            }
        });
        imageplan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,pieA.class);
                startActivity(intent);
                if(reklam==1||reklam==3||reklam==5||reklam==7||reklam==9){
                    showIntAdd();
                }
                reklam++;

            }
        });

        imageplan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ac3==0){
                    sayi=6;
                    showIntAdd();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,darkA.class);
                    startActivity(intent);
                }

            }
        });


        imageplan7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,miamiA.class);
                startActivity(intent);
                if(reklam==1||reklam==3||reklam==5||reklam==7||reklam==9){
                    showIntAdd();
                }
                reklam++;


            }
        });

        imageplan8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,greenA.class);
                startActivity(intent);
                if(reklam==1||reklam==3||reklam==5||reklam==7||reklam==9){
                    showIntAdd();
                }
                reklam++;
            }
        });

        imageplan9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ac4==0){
                    sayi=9;
                    showIntAdd();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,redA.class);
                    startActivity(intent);
                }
            }
        });

        ses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tiklanma==0){
                    song1.pause();
                    tiklanma++;
                    ses.setImageResource(R.drawable.sesoff);
                }
                else{
                    song1.start();
                    tiklanma=0;
                    ses.setImageResource(R.drawable.ses);
                }
            }
        });

        // Creating and load a  new InterstitialAd .
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();


    }


    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.ad_id_interstitial));
        interstitialAd.setAdListener(new AdListener() {


            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                ImageView  imageplan2=findViewById(R.id.rainbow);
                ImageView  imageplan3=findViewById(R.id.relaxing);
                ImageView  imageplan6=findViewById(R.id.darkmagic);
                ImageView  imageplan9=findViewById(R.id.red);
                if(sayi==2){
                    imageplan2.setImageResource(R.drawable.rainbow);
                    ac1=1;
                }
                else if(sayi==3){
                    imageplan3.setImageResource(R.drawable.relaxing);
                    ac2=1;
                }
                else if(sayi==6){
                    imageplan6.setImageResource(R.drawable.darkmagic);
                    ac3=1;
                }
                else{
                    imageplan9.setImageResource(R.drawable.red);
                    ac4=1;
                }
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    private void showIntAdd() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "please wait 3 seconds or check the internet!!!", Toast.LENGTH_SHORT).show();
            goToNextLevel();
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.

        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }



    //aktivite bitince çalışır!!!
   /* protected void onPause() {
        super.onPause();
        if (song1 != null) {
            song1.pause();
            if (isFinishing()) {
                song1.stop();
                song1.release();
            }
        }
    }*/


}
