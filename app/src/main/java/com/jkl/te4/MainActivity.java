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

        public int largo = (int) (Math.random() * 20 + 20);
        private int cont = 0;
        private TextView[] txtnum;
        private int [] array = new int[largo];
        private Handler handler = new Handler();
        int loop =0,n;
        private int compare=0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            int x = 0;
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);




            txtnum = new TextView[41];
            txtnum[x] = (TextView)findViewById(R.id.txtnum1);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum2);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum3);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum4);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum5);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum6);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum7);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum8);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum9);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum10);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum11);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum12);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum13);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum14);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum15);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum16);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum17);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum18);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum19);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum20);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum21);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum22);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum23);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum24);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum25);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum26);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum27);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum28);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum29);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum30);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum31);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum32);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum33);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum34);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum35);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum36);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum37);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum38);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum39);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum40);
            txtnum[++x] = (TextView)findViewById(R.id.txtnum41);


            for(int i = 0; i < largo; i++) {
                array[i] = (int)(Math.floor(Math.random()*101));
            }

            for(int i = 0; i < largo; i++){
                txtnum[i].setText(String.valueOf(array[i]));
            }

            for(int i = largo; i < 40; i++) {
                if (txtnum[i].getText().equals("u")) {
                    txtnum[i].setBackgroundResource(R.drawable.circle_white);
                }
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
            builder.setTitle("Warning")
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
            txtnum[a].setBackgroundResource(R.drawable.circle_brown);
            txtnum[b].setBackgroundResource(R.drawable.circle_brown);
            compare++;
            txtnum[40].setText("Comparison amount:"+ compare);
        }
    }
