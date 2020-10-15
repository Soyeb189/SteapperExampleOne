package com.bankasia.steapperexampleone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.anton46.stepsview.StepsView;
import com.bankasia.steapperexampleone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //ActivityMainBinding binding;

    String[] descriptionData = {"Basic\nInfo","Customer\nPhoto","Bio-Metric\nEnrollment","Related\nDocument","Address\nInfo","Emergency\nContact","Review"};
    int currentState = 0;
    StepsView spb;

    Button firstP,secondP,thirdP,firstN,secondN,thirdN;
    LinearLayout first,second,third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        setContentView(R.layout.activity_main);

        spb = findViewById(R.id.spb);
        firstP = findViewById(R.id.firstPrevious);
        secondP = findViewById(R.id.secondPrevious);
        thirdP = findViewById(R.id.thirdPrevious);
        firstN = findViewById(R.id.firstNext);
        secondN = findViewById(R.id.secondNext);
        thirdN = findViewById(R.id.thirdNext);

        first = findViewById(R.id.firstLyt);
        second = findViewById(R.id.secondtLyt);
        third = findViewById(R.id.thirdLyt);

        spb.setLabels(descriptionData)
                .setBarColorIndicator(Color.GRAY)
                .setProgressColorIndicator(Color.RED)
                .setLabelColorIndicator(Color.BLACK)
                .setCompletedPosition(0)
                .drawView();

        spb.setCompletedPosition(currentState);

        firstN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState = 1;
                spb.setCompletedPosition(currentState).drawView();
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                third.setVisibility(View.GONE);
            }
        });

        secondN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState = 2;
                spb.setCompletedPosition(currentState).drawView();
                first.setVisibility(View.GONE);
                second.setVisibility(View.GONE);
                third.setVisibility(View.VISIBLE);
            }
        });

        thirdP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState = 1;
                spb.setCompletedPosition(currentState).drawView();
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                third.setVisibility(View.GONE);
            }
        });

        secondP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentState = 0;
                spb.setCompletedPosition(currentState).drawView();
                first.setVisibility(View.VISIBLE);
                second.setVisibility(View.GONE);
                third.setVisibility(View.GONE);
            }
        });
    }
}