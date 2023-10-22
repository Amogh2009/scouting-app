package com.example.scoutingapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView num_of_cubes_auton, num_of_cones_auton, num_of_cubes_teliop, num_of_cones_teliop;
    TextView num_of_links_auton, num_of_links_teliop;
    MaterialButton first_pickup_auton, second_pickup_auton, ground_pickup_auton, first_pickup_teliop, second_pickup_teliop, ground_pickup_teliop;
    MaterialButton cone_auton, cube_auton, highgoal_auton, middlegoal_auton, lowgoal_auton, cone_teliop, cube_teliop, highgoal_teliop, middlegoal_teliop, lowgoal_teliop;
    MaterialButton fail_auton, score_auton, undo_auton, fail_teliop, score_teliop, undo_teliop;
    MaterialButton add_link_auton, minus_link_auton, add_link_teliop, minus_link_teliop;
    int numofconesauton = 1;
    int numofcubessauton = 1;
    int numofconesteliop = 1;
    int numofcubesstelop = 1;


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
    }

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        num_of_links_auton.setText("1");
    }
}