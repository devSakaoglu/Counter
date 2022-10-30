package com.example.counter;

import android.os.CountDownTimer;
import android.widget.TextView;

public class MyCounter {
    public long countTime=5000;
    public   long timeLeftMiliSeconds=0;
    public boolean timerFinised;
    public boolean mTimerRunning=false;
    public TextView counterText ;
    public CountDownTimer CDownTimer;

}
