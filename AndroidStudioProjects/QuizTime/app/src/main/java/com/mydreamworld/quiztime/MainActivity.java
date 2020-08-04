package com.mydreamworld.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startbutton, button0,button1,button2,button3,playagain;
    TextView sum_textview,resultTextview,pointsTextView,timertextview;
    RelativeLayout gameRelativeLayout;
    public  int counter=30;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationOfcorrectanser;
    int score=0,numberOfQuestions=0;

    public void playagain(View view){
        score=0;
        numberOfQuestions=0;
        timertextview.setText("30s");
        pointsTextView.setText("0/0");
        resultTextview.setText("");
        playagain.setVisibility(View.INVISIBLE);
        generateQuestions();

        new CountDownTimer(30000,10000){
            @Override
            public void onTick(long millisUntilFinished) {
                timertextview.setText(millisUntilFinished/1000+"s");
            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                timertextview.setText("0s");
                resultTextview.setText("Your Socre"+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();
    }
    public void generateQuestions(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);

        sum_textview.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationOfcorrectanser=rand.nextInt(4);
        answers.clear();
        int incorrectanswer;

        for(int i=0;i<4;i++){
            if(i==locationOfcorrectanser){
                answers.add(a+b);
            }else {
                incorrectanswer=rand.nextInt(41);
                while(incorrectanswer==a+b){
                    incorrectanswer=rand.nextInt(41);
                }
                answers.add(incorrectanswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void start(View view){
        startbutton.setVisibility(View.INVISIBLE);
        gameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);
        playagain(findViewById(R.id.playAgain));
    }

    public void chooseanswer(View view){
    if(view.getTag().toString().equals(Integer.toString(locationOfcorrectanser))){
        score++;
        resultTextview.setText("Correct!");
    }
    else{
        resultTextview.setText("Wrong");
    }
    numberOfQuestions++;
    pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
    generateQuestions();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbutton=(Button) findViewById(R.id.go);
        sum_textview=(TextView) findViewById(R.id.sum);
        resultTextview=(TextView) findViewById(R.id.correct);
        pointsTextView=(TextView) findViewById(R.id.point);
        timertextview=(TextView) findViewById(R.id.timertextview);
         button0=(Button) findViewById(R.id.choose1);
         button1=(Button) findViewById(R.id.choose2);
         button2=(Button) findViewById(R.id.choose3);
         button3=(Button) findViewById(R.id.choose4);
         playagain=(Button) findViewById(R.id.playAgain);
         gameRelativeLayout=(RelativeLayout) findViewById(R.id.gamerelativeLayout);

    }

}
