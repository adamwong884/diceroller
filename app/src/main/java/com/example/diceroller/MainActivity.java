package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final Random RANDOM = new Random();
    private ImageView imageViewDice1, imageViewDice2;
    private TextView textView2, textView1, textView4;
    private Button roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDice1 = (ImageView) findViewById(R.id.image_view_dice1);
        imageViewDice2 = (ImageView) findViewById(R.id.image_view_dice2);
        roll = findViewById(R.id.roll);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView4);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = randomValue();
                int value2 = randomValue();
                int sumDice = (value1 + value2);

                int res1 = getResources().getIdentifier("dice"+ value1, "drawable", "com.example.diceroller");
                int res2 = getResources().getIdentifier("dice"+ value2, "drawable", "com.example.diceroller");

                imageViewDice1.setImageResource(res1);
                imageViewDice2.setImageResource(res2);

                textView1.setText(""+value2);
                textView2.setText(""+value1);

                textView4.setText(""+sumDice);




                Log.d(TAG, "onCreate: " + sumDice);
            }
        });
    }

    public static int randomValue(){
        return RANDOM.nextInt(6)+1;
    }

}


