package com.example.user.lab7;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout1 ;
    LinearLayout layout2 ;
    int n;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (LinearLayout)findViewById(R.id.audio1);
        layout2 = (LinearLayout)findViewById(R.id.audio2);

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    n=1;
                    playAudio(n);
                    layout1.setBackgroundColor(getResources().getColor(R.color.Gray));
                    layout2.setBackgroundColor(getResources().getColor(R.color.White));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    n=2;
                    playAudio(n);
                    layout2.setBackgroundColor(getResources().getColor(R.color.Gray));
                    layout1.setBackgroundColor(getResources().getColor(R.color.White));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void finish(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer=null;
        }
        super.finish();
    }

    private void playAudio(int number) throws Exception{
        killMediaPlayer();

        switch (number){
            case 1:
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.music1);
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.music2);
                mediaPlayer.start();
                break;
        }
    }

    private void killMediaPlayer(){
        if(mediaPlayer!=null){
            try{
                mediaPlayer.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
