package com.example.scoutingapp;

import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import java.util.Locale;
import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    int highgoalcubesauton;
    int highgoalconesteliop;
    int middlehgoalcubesauton;
    int middlegoalconesteliop;
    int lowgoalcubesauton;
    int lowgoalconesteliop;
    String titles = "name, match# team#, red/blue";
    String auton_pickup = "#ground pickup(auton), #1st pickup(auton),#2nd pickup(auton)";
    String auton_coneplacement = "cones scored in high(auton), cones scored in middle(auton), cones scored in low(auton)";
    String auton_cubeplacement = "cubes scored in high(auton), cubes scored in middle(auton), cubes scored in low(auton)";
    String auton_fails = "cone fails(auton), cube fails(auton)";
    String teliop_pickup = "#ground pickup(auton), #1st pickup(auton),#2nd pickup(auton)";
    String teliop_coneplacement = "cones scored in high(auton), cones scored in middle(auton), cones scored in low(auton)";
    String teliop_cubeplacement = "cubes scored in high(auton), cubes scored in middle(auton), cubes scored in low(auton)";
    String teliop_fails = "cone fails(teliop), cube fails(teliop)";
    String quantitative = auton_pickup + auton_coneplacement+auton_cubeplacement+teliop_pickup+teliop_coneplacement+teliop_cubeplacement+auton_fails+teliop_fails;

    String observational = "Time taken to balance, successful balance, strength, speed, maneuvering";
        String data_sent_to_sheet = titles + quantitative + observational;

    TextView num_of_cubes_auton, num_of_cones_auton, num_of_cubes_teliop, num_of_cones_teliop;
    TextView num_of_links_auton, num_of_links_teliop;
    MaterialButton first_pickup_auton, second_pickup_auton, ground_pickup_auton, first_pickup_teliop, second_pickup_teliop, ground_pickup_teliop;
    MaterialButton cone_auton, cube_auton, highgoal_auton, middlegoal_auton, lowgoal_auton, cone_teliop, cube_teliop, highgoal_teliop, middlegoal_teliop, lowgoal_teliop;
    MaterialButton fail_auton, score_auton, undo_auton, fail_teliop, score_teliop, undo_teliop;
    MaterialButton add_link_auton, minus_link_auton, add_link_teliop, minus_link_teliop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num_of_links_auton = findViewById(R.id.num_of_links_auton);
        num_of_links_teliop = findViewById(R.id.num_of_links_teliop);
        num_of_cubes_auton = findViewById(R.id.num_of_cubes_auton);
        num_of_cones_auton = findViewById(R.id.num_of_cones_auton);
        num_of_cubes_teliop = findViewById(R.id.num_of_cubes_teliop);
        num_of_cones_teliop = findViewById(R.id.num_of_cones_teliop);
        assignId(first_pickup_auton, R.id.first_pickup_auton);
        assignId(second_pickup_auton, R.id.second_pickup_auton);
        assignId(ground_pickup_auton, R.id.ground_pickup_auton);
        assignId(first_pickup_teliop, R.id.first_pickup_teliop);
        assignId(second_pickup_teliop, R.id.second_pickup_teliop);
        assignId(ground_pickup_teliop, R.id.ground_pickup_teliop);
        assignId(cone_auton, R.id.cone_auton);
        assignId(cube_auton, R.id.cube_auton);
        assignId(highgoal_auton, R.id.highgoal_auton);
        assignId(middlegoal_auton, R.id.middlegoal_auton);
        assignId(lowgoal_auton, R.id.lowgoal_auton);
        assignId(cone_teliop, R.id.cone_teliop);
        assignId(cube_teliop, R.id.cube_teliop);
        assignId(highgoal_teliop, R.id.highgoal_teliop);
        assignId(middlegoal_teliop, R.id.middlegoal_teliop);
        assignId(lowgoal_teliop, R.id.lowgoal_teliop);
        assignId(fail_auton, R.id.fail_auton);
        assignId(score_auton, R.id.score_auton);
        assignId(undo_auton, R.id.undo_auton);
        assignId(fail_teliop, R.id.fail_teliop);
        assignId(score_teliop, R.id.score_teliop);
        assignId(undo_teliop, R.id.undo_teliop);
        assignId(add_link_auton, R.id.add_link_auton);
        assignId(minus_link_auton, R.id.minus_link_auton);
        assignId(add_link_teliop, R.id.add_link_teliop);
        assignId(minus_link_teliop, R.id.minus_link_teliop);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

}

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
}
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        //pickup location
        switch (view.getId()){
            case 1: /*ground pickup auton*/

                break;
            case 2: /*1st pickup auton*/

                break;
            case 3: /*2nd pickup auton*/

                break;
            case 4: /*ground pickup teliop*/

                break;
            case 5: /*1st pickup teliop*/

                break;
            case 6: /*2nd pickup teliop*/

                break;
        }
        //cone placement location
        switch (view.getId()){
            case 1: /*high cone auton*/

                break;
            case 2: /*middle cone auton*/

                break;
            case 3: /*low cone auton*/

                break;
            case 4: /*high cone teliop*/

                break;
            case 5: /*middle cone teliop*/

                break;
            case 6: /*low cone teliop*/

                break;
        }
        //cube placement location
        switch (view.getId()){
            case 1: /*high cube auton*/

                break;
            case 2: /*middle cube auton*/

                break;
            case 3: /*low cube auton*/

                break;
            case 4: /*high cube teliop*/

                break;
            case 5: /*middle cube teliop*/

                break;
            case 6: /*low cube teliop*/

                break;
        }
        //score, fail, undo
        switch (view.getId()){
            case 1: /*fail auton*/

                break;
            case 2: /*score auton*/

                break;
            case 3: /*undo auton*/

                break;
            case 4: /*fail teliop*/

                break;
            case 5: /*score teliop*/

                break;
            case 6: /*undo teliop*/

                break;
        }
        num_of_links_auton.setText("1");
    }
}