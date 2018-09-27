package com.example.mickymouse.videoplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.MediaController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mp3;
    AudioManager Audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView IV=(VideoView)findViewById(R.id.videoView);
        IV.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.movite);
        MediaController VI= new MediaController(this);
        VI.setAnchorView(IV);
        IV.setMediaController(VI);
        mp3 = MediaPlayer.create(this, R.raw.movite);

        Audio=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int Mavolume= Audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int CurVolume=Audio.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar VolumeCtrl= (SeekBar)findViewById(R.id.seekBar);
        VolumeCtrl.setMax(Mavolume);
        VolumeCtrl.setProgress(CurVolume);
        VolumeCtrl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){

                Log.i("Seek Value", Integer.toString(progress));
                Audio.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }


        });

        IV.start();





    }
}
