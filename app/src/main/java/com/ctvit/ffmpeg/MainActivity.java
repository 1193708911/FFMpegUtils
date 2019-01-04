package com.ctvit.ffmpeg;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avformat-57");
        System.loadLibrary("swscale-4");
        System.loadLibrary("postproc-54");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avdevice-57");
        System.loadLibrary("ffmpeg");
    }

    private Button mPlay;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          filePath=Environment.getExternalStorageDirectory() + File.separator + "gcdr.mp4";
        initView();
        if(new File(filePath).exists()){
            Toast.makeText(MainActivity.this,"文件存在",Toast.LENGTH_SHORT).show();
        }

    }

    private void initView() {
        mPlay = findViewById(R.id.play);
        mPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                playMyMedia(filePath, "rtmp://192.168.6.175/live/test");
                break;
        }
    }

    public native void playMyMedia(String inUrl, String outUrl);
}
