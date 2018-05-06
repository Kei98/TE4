package com.jkl.te4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
            });
    }

}