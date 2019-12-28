package com.example.mathquiz;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int first;
    int second;
    int answer;
    int correctP;
    TextView a1;
    TextView a2;
    TextView a3;
    TextView a4;
    TextView co;
    TextView time;
    TextView question;
    int total;
    int right;
    int count = 0;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1 = (TextView)findViewById(R.id.a1);
        a2 = (TextView)findViewById(R.id.a2);
        a3 = (TextView)findViewById(R.id.a3);
        a4 = (TextView)findViewById(R.id.a4);
        question = (TextView)findViewById(R.id.q);
        a1.setClickable(false);
        a2.setClickable(false);
        a3.setClickable(false);
        a4.setClickable(false);
    }

    public void begin(View view){
        if (!(timer ==null)){
            timer.cancel();
        }
        newQ();
        count = 0;
        total = 0;
        right = 0;
        time = (TextView)findViewById(R.id.time);
        co = (TextView)findViewById(R.id.correct);
        a1.setClickable(true);
        a2.setClickable(true);
        a3.setClickable(true);
        a4.setClickable(true);
        co.setText("0 / 0");
        timer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                count = count + 1;
                time.setText(Integer.toString(10 - count));
            }

            @Override
            public void onFinish() {
                count = 0;
                total = total + 1;
                co.setText(right + " / " + total);
                timer.start();
            }
        }.start();

    }
    public void click(View view){
        TextView one = (TextView) view;
        String now = view.getTag().toString();
        switch (now){
            case "a1":
                if (correctP == 1){
                    right = right +1;
                }
                break;
            case "a2":
                if (correctP == 2){
                    right = right +1;
                }
                break;
            case "a3":
                if (correctP == 3) {
                    right = right + 1;
                }
                break;
            default:
                if (correctP == 4){
                    right = right +1;
                }
        }
        count = 0;
        total = total + 1;
        co.setText(right + " / " + total);
        newQ();
        timer.cancel();
        timer.start();
    }
    private int produceRandom(){
        return (int)(Math.random() * 200);
    }
    private void newQ(){
        first = (int)(Math.random() * 100);
        second = (int)(Math.random() * 100);
        answer = first + second;

        question.setText(first + " + " +second + " = ");
        correctP = (int) (Math.random() * 4 )+1;
        a1.setText(Integer.toString(produceRandom()));
        a2.setText(Integer.toString(produceRandom()));
        a3.setText(Integer.toString(produceRandom()));
        a4.setText(Integer.toString(produceRandom()));
        switch (correctP){
            case 1:
                a1.setText(Integer.toString(answer));
                break;
            case 2:
                a2.setText(Integer.toString(answer));
                break;
            case 3:
                a3.setText(Integer.toString(answer));
                break;
            default:
                a4.setText(Integer.toString(answer));
                break;
        }
    }
}
