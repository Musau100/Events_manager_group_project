package com.ryle_tech.materialdesign.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.ryle_tech.materialdesign.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
//    private String pathToFileOrUrl= "rtmp://204.107.26.252:8086/live/796.high.stream";
    private String pathToFileOrUrl= "http://192.168.56.1/material/fifa.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        VideoView mVideoView = (VideoView) findViewById(R.id.videoView);

        if (pathToFileOrUrl == "") {
            Toast.makeText(this, "Please set the video path for your media file", Toast.LENGTH_LONG).show();
        } else {

            /*
             * Alternatively,for streaming media you can use
             * mVideoView.setVideoURI(Uri.parse(URLstring));
             */
            assert mVideoView != null;
            mVideoView.setVideoPath(pathToFileOrUrl);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.requestFocus();

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
//                     optional need Vitamio 4.0
                    mediaPlayer.setPlaybackSpeed(1.0f);
                }
            });


//            start playing
            if (!TextUtils.isEmpty(pathToFileOrUrl)) {
                mVideoView.setVideoPath(pathToFileOrUrl);
            }
        }

    }
}

