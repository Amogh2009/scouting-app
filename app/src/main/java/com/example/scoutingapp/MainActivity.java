package com.example.scoutingapp;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.button.MaterialButton;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText inputTextName;
    EditText inputTextColor;
    EditText inputTextMatch;
    EditText inputTextTeam;
    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    //variables for shaurya below
    String scout_name= "";
    String alliance_color = "";
    int match_number;
    int team_number;
    //variables for shaurya above

    int ground_pickup_autonv;
    int first_pickup_autonv;
    int second_pickup_autonv;
    int ground_pickup_teliopv;
    int first_pickup_teliopv;
    int second_pickup_teliopv;
    boolean cube_autonv;
    boolean cube_teliopv;
    boolean cone_autonv;
    boolean cone_teliopv;
    int high_cone_autonv;
    int middle_cone_autonv;
    int low_cone_autonv;
    int high_cone_teliopv;
    int middle_cone_teliopv;
    int low_cone_teliopv;
    int high_cube_autonv;
    int middle_cube_autonv;
    int low_cube_autonv;
    int high_cube_teliopv;
    int middle_cube_teliopv;
    int low_cube_teliopv;
    int fail_autonv;
    int score_autonv;
    int undo_autonv;
    int fail_teliopv;
    int score_teliopv;
    int undo_teliopv;
    int num_of_links_autonv;
    int num_of_links_teliopv;

    String balance;

    int robot_speedv;
    int robot_strengthv;
    int robot_maneuvarablev;

/*
    String titles = "name, match# team#, red/blue";
    String auton_pickup = "#ground pickup(auton), #1st pickup(auton),#2nd pickup(auton)";
    String auton_coneplacement = "cones scored in high(auton), cones scored in middle(auton), cones scored in low(auton)";
    String auton_cubeplacement = "cubes scored in high(auton), cubes scored in middle(auton), cubes scored in low(auton)";
    String auton_fails = "cone fails(auton), cube fails(auton)";
    String teliop_pickup = "#ground pickup(auton), #1st pickup(auton),#2nd pickup(auton)";
    String teliop_coneplacement = "cones scored in high(auton), cones scored in middle(auton), cones scored in low(auton)";
    String teliop_cubeplacement = "cubes scored in high(auton), cubes scored in middle(auton), cubes scored in low(auton)";
    String teliop_fails = "cone fails(teliop), cube fails(teliop)";
    String quantitative = auton_pickup + auton_coneplacement + auton_cubeplacement + teliop_pickup + teliop_coneplacement + teliop_cubeplacement + auton_fails + teliop_fails;
    String observational = "Time taken to balance, successful balance, strength, speed, maneuvering";
    String data_sent_to_sheet = titles + quantitative + observational;

 */
    TextView num_of_cubes_auton, num_of_cones_auton, num_of_cubes_teliop, num_of_cones_teliop;
    TextView num_of_links_auton, num_of_links_teliop;
    ToggleButton first_pickup_auton, second_pickup_auton, ground_pickup_auton, first_pickup_teliop, second_pickup_teliop, ground_pickup_teliop;
    ToggleButton cone_auton, cube_auton, highgoal_auton, middlegoal_auton, lowgoal_auton, cone_teliop, cube_teliop, highgoal_teliop, middlegoal_teliop, lowgoal_teliop;
    MaterialButton fail_auton, score_auton, undo_auton, fail_teliop, score_teliop, undo_teliop;
    MaterialButton add_link_auton, minus_link_auton, add_link_teliop, minus_link_teliop;

    MaterialButton succesful_balance, unsuccesful_balance;

    MaterialButton strength_1, strength_2, strength_3, strength_4, strength_5;
    MaterialButton speed_1, speed_2, speed_3, speed_4, speed_5;
    MaterialButton maneuvering_1, maneuvering_2, maneuvering_3, maneuvering_4, maneuvering_5;
    MaterialButton submit;
    MaterialButton mButtonStartPause, mButtonReset;
    /*
    int numofconesauton = 1;
    int numofcubessauton = 1;
    int numofconesteliop = 1;
    int numofcubesstelop = 1;
    */


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        inputTextName=(EditText) findViewById(R.id.inputTextName);
        inputTextColor=(EditText) findViewById(R.id.inputTextColor);
        inputTextMatch=(EditText) findViewById(R.id.inputTextMatch);
        inputTextTeam=(EditText) findViewById(R.id.inputTextTeam);

        num_of_links_auton = findViewById(R.id.num_of_links_auton);
        num_of_links_teliop = findViewById(R.id.num_of_links_teliop);
        num_of_cubes_auton = findViewById(R.id.num_of_cubes_auton);
        num_of_cones_auton = findViewById(R.id.num_of_cones_auton);
        num_of_cubes_teliop = findViewById(R.id.num_of_cubes_teliop);
        num_of_cones_teliop = findViewById(R.id.num_of_cones_teliop);

        first_pickup_auton = (ToggleButton) findViewById(R.id.first_pickup_auton);
        second_pickup_auton = (ToggleButton) findViewById(R.id.second_pickup_auton);
        ground_pickup_auton = (ToggleButton) findViewById(R.id.ground_pickup_auton);
        first_pickup_teliop = (ToggleButton) findViewById(R.id.first_pickup_teliop);
        second_pickup_teliop = (ToggleButton) findViewById(R.id.second_pickup_teliop);
        ground_pickup_teliop = (ToggleButton) findViewById(R.id.ground_pickup_teliop);
        cone_auton = (ToggleButton) findViewById(R.id.cone_auton);
        cube_auton = (ToggleButton) findViewById(R.id.cube_auton);
        highgoal_auton = (ToggleButton) findViewById(R.id.highgoal_auton);
        middlegoal_auton = (ToggleButton) findViewById(R.id.middlegoal_auton);
        lowgoal_auton = (ToggleButton) findViewById(R.id.lowgoal_auton);
        cone_teliop = (ToggleButton) findViewById(R.id.cone_teliop);
        cube_teliop = (ToggleButton) findViewById(R.id.cube_teliop);
        highgoal_teliop = (ToggleButton) findViewById(R.id.highgoal_teliop);
        middlegoal_teliop = (ToggleButton) findViewById(R.id.middlegoal_teliop);
        lowgoal_teliop = (ToggleButton) findViewById(R.id.lowgoal_teliop);

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

        assignId(succesful_balance, R.id.succesful_balance);
        assignId(unsuccesful_balance, R.id.unsuccesful_balance);
        assignId(strength_1, R.id.strength_1);
        assignId(strength_2, R.id.strength_2);
        assignId(strength_3, R.id.strength_3);
        assignId(strength_4, R.id.strength_4);
        assignId(strength_5, R.id.strength_5);
        assignId(speed_1, R.id.speed_1);
        assignId(speed_2, R.id.speed_2);
        assignId(speed_3, R.id.speed_3);
        assignId(speed_4, R.id.speed_4);
        assignId(speed_5, R.id.speed_5);
        assignId(maneuvering_1, R.id.maneuvering_1);
        assignId(maneuvering_2, R.id.maneuvering_2);
        assignId(maneuvering_3, R.id.maneuvering_3);
        assignId(maneuvering_4, R.id.maneuvering_4);
        assignId(maneuvering_5, R.id.maneuvering_5);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        assignId(mButtonStartPause, R.id.button_start_pause);
        assignId(mButtonReset, R.id.button_reset);
        // code below for submitting data to google sheet
        assignId(submit, R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "amogh";
                int matchnumber = 76;
                int teamnumber = 7390;

                saveData(name, matchnumber, teamnumber);
            }
        });


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();
    }
    private void saveData(String name, int matchnumber, int teamnumber) {
        String url = "https://script.google.com/macros/s/AKfycbzwr9CcQPnwj84vYsYY63ilWmazQ4v6qWwSJHU5ssWqZf6X89Su1C1wB-2hn3dUTKg/exec";
        url = url+"action=create&name="+name+"&matchnumber="+matchnumber+"&teamnumber="+teamnumber;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
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

    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        //pickup location
        /* switch (view.getId()){
            case 1000022: //ground pickup auton
        ground_pickup_autonv++;
        break;
        case 1000006: //1st pickup auton
        first_pickup_autonv++;
        break;
        case 1000017: //2nd pickup auton
        second_pickup_autonv++;
        break;
        case 1000024: //ground pickup teliop
        ground_pickup_teliopv++;
        break;
        case 1000036: //1st pickup teliop
        first_pickup_teliopv++;
        break;
        case 1000005: //2nd pickup teliop
        second_pickup_teliopv++;
        break;
    }
            //cone or cube
        switch (view.getId()){
            case 1000032: //cube_auton
                cube_autonv = true;
                break;
            case 1000008: //cone_auton
                cube_autonv = false;
                break;
            case 1000034: //cube_teliop
                cube_teliopv = true;
                break;
            case 1000000: //cone_,teliop
                cube_teliopv = false;
                break;

        }
        //cone/cube placement location
        switch (view.getId()){

            case 1000013: //high auton
                if(!cube_autonv)high_cone_autonv++;
                else if(cube_autonv)high_cube_autonv++;
                break;
            case 1000019: //middle auton
                if(!cube_autonv)middle_cone_autonv++;
                else if(cube_autonv)middle_cube_autonv++;
                break;
            case 1000035: //low auton
                if(!cube_autonv)low_cone_autonv++;
                else if(cube_autonv)low_cube_autonv++;
                break;
            case 1000032: //high teliop
                if(!cube_teliopv)high_cone_teliopv++;
                else if(cube_teliopv)high_cube_teliopv++;
                break;
            case 1000007: //middle teliop
                if(!cube_teliopv)middle_cone_teliopv++;
                else if(cube_teliopv)middle_cube_teliopv++;
                break;
            case 1000004: //low teliop
                if(!cube_autonv)low_cone_teliopv++;
                else if(cube_autonv)low_cube_teliopv++;
                break;
        }
    */
        //score, fail, undo
        switch (view.getId()){
            case 1000026: /*fail auton*/
                first_pickup_auton.setChecked(false);
                second_pickup_auton.setChecked(false);
                ground_pickup_auton.setChecked(false);
                cone_auton.setChecked(false);
                cube_auton.setChecked(false);
                highgoal_auton.setChecked(false);
                middlegoal_auton.setChecked(false);
                lowgoal_auton.setChecked(false);
                fail_autonv++;
                break;
            case 1000020: /*score auton*/
                if(first_pickup_auton.isChecked())first_pickup_autonv++;
                if(second_pickup_auton.isChecked())second_pickup_autonv++;
                if(ground_pickup_auton.isChecked())ground_pickup_autonv++;
                if(cone_auton.isChecked())cone_autonv = true;
                if(cube_auton.isChecked())cube_autonv = true;
                if(highgoal_auton.isChecked()){
                    if(!cube_autonv)high_cone_autonv++;
                    else if(cube_autonv)high_cube_autonv++;
                }
                if(middlegoal_auton.isChecked()){
                    if(!cube_autonv)middle_cone_autonv++;
                    else if(cube_autonv)middle_cube_autonv++;
                }
                if(lowgoal_auton.isChecked()) {
                    if(!cube_autonv)low_cone_autonv++;
                    else if(cube_autonv)low_cube_autonv++;
                }
                break;
            case 1000029: /*undo auton*/
                first_pickup_auton.setChecked(false);
                second_pickup_auton.setChecked(false);
                ground_pickup_auton.setChecked(false);
                cone_auton.setChecked(false);
                cube_auton.setChecked(false);
                highgoal_auton.setChecked(false);
                middlegoal_auton.setChecked(false);
                lowgoal_auton.setChecked(false);
                break;
            case 1000038: /*fail teliop*/
                first_pickup_teliop.setChecked(false);
                second_pickup_teliop.setChecked(false);
                ground_pickup_teliop.setChecked(false);
                cone_teliop.setChecked(false);
                cube_teliop.setChecked(false);
                highgoal_teliop.setChecked(false);
                middlegoal_teliop.setChecked(false);
                lowgoal_teliop.setChecked(false);
                fail_teliopv++;
                break;
            case 1000011: /*score teliop*/
                if(first_pickup_teliop.isChecked())first_pickup_teliopv++;
                if(second_pickup_teliop.isChecked())second_pickup_teliopv++;
                if(ground_pickup_teliop.isChecked())ground_pickup_teliopv++;
                if(cone_teliop.isChecked())cone_teliopv = true;
                if(cube_teliop.isChecked())cube_teliopv = true;
                if(highgoal_teliop.isChecked()){
                    if(!cube_autonv)high_cone_teliopv++;
                    else if(cube_autonv)high_cube_teliopv++;
                }
                if(middlegoal_teliop.isChecked()){
                    if(!cube_autonv)middle_cone_teliopv++;
                    else if(cube_autonv)middle_cube_teliopv++;
                }
                if(lowgoal_teliop.isChecked()) {
                    if(!cube_autonv)low_cone_teliopv++;
                    else if(cube_autonv)low_cube_teliopv++;
                }
                break;
            case 1000015: /*undo teliop*/
                first_pickup_teliop.setChecked(false);
                second_pickup_teliop.setChecked(false);
                ground_pickup_teliop.setChecked(false);
                cone_teliop.setChecked(false);
                cube_teliop.setChecked(false);
                highgoal_teliop.setChecked(false);
                middlegoal_teliop.setChecked(false);
                lowgoal_teliop.setChecked(false);
                break;
        }
        //successful or unsuccessful balance
        switch (view.getId()){
            case 1000039:
                balance = "yes";
                break;
            case 1000030:
                balance = "no";
                break;
        }
        //robot strength
        switch (view.getId()){
            case 1000001:
                robot_strengthv=1;
            break;
            case 1000008:
                robot_strengthv=2;
            break;
            case 1000009:
                robot_strengthv=3;
                break;
            case 1000004:
                robot_strengthv=4;
                break;
            case 1000005:
                robot_strengthv=5;
                break;
        }
        //robot speed
        switch (view.getId()){
            case 1000055:
                robot_speedv=1;
                break;
            case 1000052:
                robot_speedv=2;
                break;
            case 1000053:
                robot_speedv=3;
                break;
            case 1000059:
                robot_speedv=4;
                break;
            case 1000061:
                robot_speedv=5;
                break;
        }
        //robot maneuverability
        switch (view.getId()){
            case 1000011:
                robot_maneuvarablev=1;
                break;
            case 1000015:
                robot_maneuvarablev=2;
                break;
            case 1000016:
                robot_maneuvarablev=3;
                break;
            case 1000013:
                robot_maneuvarablev=4;
                break;
            case 1000014:
                robot_maneuvarablev=5;
                break;
        }
    }
}
