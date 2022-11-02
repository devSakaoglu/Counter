package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyCounter counter=new MyCounter();
    public Button button;
    public Button inputButton;
    public  EditText timeInput;
    public  TextView textView2;
    public long customTimerValue=0;
    public static final String TAG= MainActivity.class.getSimpleName().toString();


    public void PressButton(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(counter.timerFinised){
            }
                startStop(customTimerValue);
            }
        });

    }
    public void inputButtonOnClick(){
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    customTimerValue= Long.parseLong( timeInput.getText().toString());
                }catch (Exception e){
                    Log.d(TAG, e.getMessage().toString());
                    customTimerValue=15000;
                }

                textView2.setText(timeInput.getText().toString());
                button.setText("Start");
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter.counterText =(TextView) findViewById(R.id.counter);
        button=(Button) findViewById(R.id.button);
        button.setText("Start");
        counter.timerFinised=false;
        timeInput = (EditText)findViewById(R.id.editTextNumber);
        inputButton=(Button) findViewById(R.id.button2);
        textView2=(TextView) findViewById(R.id.textView2);




    }
public  void startStop(long customTimerValue){
    if (counter.mTimerRunning && !counter.timerFinised){
        stopTimer();
    }else
    {
        if(customTimerValue!=0){
            startTimer(customTimerValue);
        }else {
            startTimer(5000);
        }

    }

}
public  void  startTimer(long customTimerValue){
long CustomTimerValue=customTimerValue;
        if(counter.timeLeftMiliSeconds >0 ){
            CustomTimerValue=counter.timeLeftMiliSeconds;
        }


    counter.CDownTimer = new CountDownTimer(CustomTimerValue,1000) {
        @Override
        public void onTick(long l) {
            counter.timeLeftMiliSeconds=l;
            counter.counterText.setText(""+l/1000);
            updateTime(l);
        }

        @Override
        public void onFinish() {
            counter.counterText.setText("Finished");
            button.setText("Restart");
            counter.timerFinised=true;
            counter.mTimerRunning=false;
            counter.timeLeftMiliSeconds=0;
        }
    }.start();
    counter.mTimerRunning=true;
    button.setText("Stop");

    }

public void  stopTimer(){
    counter.CDownTimer.cancel();
    counter.mTimerRunning=false;
        button.setText("Resume");

}
public void  updateTime(long l){
    counter.timeLeftMiliSeconds=l;
    Log.i(TAG, "updateTime: ");

}
    @Override
    protected  void  onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
        PressButton();
        inputButtonOnClick();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");

    }
}
