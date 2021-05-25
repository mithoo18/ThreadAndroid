package com.example.threadandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private TextView tvKQ;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void startProgress(View view) {
        bar.setProgress(0);
        new Thread(new Task()).start();
    }
    class Task implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                final int value = i;
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                bar.setProgress(value);
            }
        }
    }

}