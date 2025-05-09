package com.baofu.okdownloaderdemo.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.arthenica.ffmpegkit.FFmpegKit;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.arthenica.ffmpegkit.FFmpegSessionCompleteCallback;
import com.arthenica.ffmpegkit.ReturnCode;
import com.arthenica.ffmpegkit.SessionState;
import com.baofu.okdownloaderdemo.R;
import com.baofu.okdownloaderdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m3u8FilePath="";
                String outputPath="";

                String command = "-i '"+m3u8FilePath+ "' -c copy '" +outputPath+"'";
                FFmpegKit.executeAsync(command, new FFmpegSessionCompleteCallback() {

                    @Override
                    public void apply(FFmpegSession session) {
                        SessionState state = session.getState();
                        ReturnCode returnCode = session.getReturnCode();
//                    Log.e("asdf", String.format("============FFmpeg process exited with state %s and rc %s.%s", state, returnCode, session.getFailStackTrace()));

                        if (returnCode.isValueSuccess()) {
                            // 命令执行成功
                            Log.e("tag","suc");
                        } else {
                            Log.e("tag","fail");

                        }

                    }
                });
            }
        });
    }



}