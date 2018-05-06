package com.jkl.te4;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


    public class MainActivity extends AppCompatActivity {

        private int largo = 40;
        private int cont = 0;
        private TextView[] txtnum;
        private int [] array = new int[largo];
        private Handler handler = new Handler();
        int loop =0,n;
        private int compare=0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


            txtnum = new TextView[largo];
            txtnum[0] = (TextView)findViewById(R.id.txtnum1);
            txtnum[1] = (TextView)findViewById(R.id.txtnum2);
            txtnum[2] = (TextView)findViewById(R.id.txtnum3);
            txtnum[3] = (TextView)findViewById(R.id.txtnum4);
            txtnum[4] = (TextView)findViewById(R.id.txtnum5);
            txtnum[5] = (TextView)findViewById(R.id.txtnum6);
            txtnum[6] = (TextView)findViewById(R.id.txtnum7);
            txtnum[7] = (TextView)findViewById(R.id.txtnum8);
            txtnum[8] = (TextView)findViewById(R.id.txtnum9);
            txtnum[9] = (TextView)findViewById(R.id.txtnum10);
            txtnum[10] = (TextView)findViewById(R.id.txtnum11);
            txtnum[11] = (TextView)findViewById(R.id.txtnum12);
            txtnum[12] = (TextView)findViewById(R.id.txtnum13);
            txtnum[13] = (TextView)findViewById(R.id.txtnum14);
            txtnum[14] = (TextView)findViewById(R.id.txtnum15);
            txtnum[15] = (TextView)findViewById(R.id.txtnum16);
            txtnum[16] = (TextView)findViewById(R.id.txtnum17);
            txtnum[17] = (TextView)findViewById(R.id.txtnum18);
            txtnum[18] = (TextView)findViewById(R.id.txtnum19);
            txtnum[19] = (TextView)findViewById(R.id.txtnum20);
            txtnum[20] = (TextView)findViewById(R.id.txtnum21);
            txtnum[21] = (TextView)findViewById(R.id.txtnum22);
            txtnum[22] = (TextView)findViewById(R.id.txtnum23);
            txtnum[23] = (TextView)findViewById(R.id.txtnum24);
            txtnum[24] = (TextView)findViewById(R.id.txtnum25);
            txtnum[25] = (TextView)findViewById(R.id.txtnum26);
            txtnum[26] = (TextView)findViewById(R.id.txtnum27);
            txtnum[27] = (TextView)findViewById(R.id.txtnum28);
            txtnum[28] = (TextView)findViewById(R.id.txtnum29);
            txtnum[29] = (TextView)findViewById(R.id.txtnum30);
            txtnum[30] = (TextView)findViewById(R.id.txtnum31);
            txtnum[31] = (TextView)findViewById(R.id.txtnum32);
            txtnum[32] = (TextView)findViewById(R.id.txtnum33);
            txtnum[33] = (TextView)findViewById(R.id.txtnum34);
            txtnum[34] = (TextView)findViewById(R.id.txtnum35);
            txtnum[35] = (TextView)findViewById(R.id.txtnum36);
            txtnum[36] = (TextView)findViewById(R.id.txtnum37);
            txtnum[37] = (TextView)findViewById(R.id.txtnum38);
            txtnum[38] = (TextView)findViewById(R.id.txtnum39);
            txtnum[39] = (TextView)findViewById(R.id.txtnum40);


            for(int i = 0; i < largo; i++) {
                array[i] = (int)(Math.floor(Math.random()*101));
            }

            for(int i = 0; i < array.length; i++){
                txtnum[i].setText(String.valueOf(array[i]));
            }

            ((TextView)findViewById(R.id.bsort)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cont == 0) {
                        bubblesort();
                    }else{
                        alerta();
                    }
                }
            });

            ((TextView)findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.this.finish();
                }
            });
        }

        public void alerta(){
            cont++;
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Material_Dialog_Alert);
            builder.setTitle("Alerta")
                    .setMessage("Do you wanna kill the current sorting process and initialize a new one?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            cont = 0;
                            intent0();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            cont++;
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }

        public void intent0(){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("key", 1);
            intent.putExtras(bundle);
            MainActivity.this.finish();
            startActivity(intent);
        }

        public void bubblesort(){
            animationBBS(0,1);
            cont++;
        }

        public void animationBBS(final int a, final int b){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(Integer.valueOf(txtnum[a].getText().toString())>Integer.valueOf(txtnum[b].getText().toString())){
                        String temp = txtnum[a].getText().toString();
                        txtnum[a].setText(txtnum[b].getText().toString());
                        txtnum[b].setText(temp);
                    }
                    txtnum[a].setBackgroundResource(R.drawable.circle_blue);
                    txtnum[b].setBackgroundResource(R.drawable.circle_blue);
                    int j = b + 1;
                    int i = a + 1;
                    if(j == array.length-loop){
                        i = 0;
                        j = i + 1;
                        loop++;
                    }
                    if(loop < array.length-1){

                        animationBBS(i,j);
                    }
                }
            },700);
            txtnum[a].setBackgroundResource(R.drawable.circle_orange);
            txtnum[b].setBackgroundResource(R.drawable.circle_orange);
            compare++;
        }
    }
