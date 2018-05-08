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
        /**
         * Variables de la clase que serán utilizadas en la misma
         *
         * largo: tamaño variable que tendrán los array que se utilizarán.
         * cont: contador de pulsaciones del usuario sobre el ¨botón¨ BubbleSort.
         * txtnum: Array que almacenará los valores númericos a los que se le aplicara el ordenamiento.
         * array: Array en el cual se guardarán los números que se crearán de forma aleatoria para luego
         * ser traspasados al Array txtnum.
         * handler: controlador que se encargará de la ejecución del proceso de ordenamiento.
         * compare: variable que contará el número de comparaciones que ha realizado el método de
         * ordenamiento en su objetivo de ordenar los datos.
         */

        public int largo = (int) (Math.random() * 20 + 20);
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


            /**
             * Se asigna el espacio gráfico donde se "guardarán" los datos
             */
            txtnum = new TextView[41];
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
            txtnum[40] = (TextView)findViewById(R.id.txtnum41);

            /**
             * Ciclo que se encarga de asignar un valor numérico de entre 0 y 100 de forma aleatoria a
             * cada posición del array que tiene un tamaño variable y que depende de la constante largo
             * que también se crea de forma aleatoria en un rango entre 20 y 40.
             */
            for(int i = 0; i < largo; i++) {
                array[i] = (int)(Math.floor(Math.random()*101));
            }

            /**
             * Ciclo que se encarga de asignar los valores numéricos que se encuentran en ¨array¨ a otro
             * otro array llamado ¨txtnum¨ que mediante un ID se encarga de mostrarlos en pantalla.
             */
            for(int i = 0; i < largo; i++){
                txtnum[i].setText(String.valueOf(array[i]));
            }

            /**
             * Ciclo que se encarga de quitar los espacios sobrantes
             */
            for(int i = largo; i < 40; i++) {
                if (txtnum[i].getText().equals("u")) {
                    txtnum[i].setBackgroundResource(R.drawable.circle_white);
                }
            }


            /**
             * Método que se encarga de asignar una función al ¨botón¨ de BubbleSort que se encuentra
             * en pantalla, donde dependiendo la cantidad  de veces (1) llama al método de ordemaniento
             * (2) muestra una alerta al usuario para que especifíque que desea hacer.
             */
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


            /**
             * Método que se encarga de asigar una función al ¨botón¨ de Close que se encuentra en
             * pantalla, donde al ser pulsado por el usuario cerrará la aplicación.
             */
            ((TextView)findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.this.finish();
                }
            });
        }

        /**
         * Método que genera el cuadro de alerta
         */

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

        /**
         * Método que reinicia los valores y la interfaz
         */
        public void intent0(){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("key", 1);
            intent.putExtras(bundle);
            MainActivity.this.finish();
            startActivity(intent);
        }


        /**
         * Método que se encarga de llamar al método animado del ordenamiento BubbleSort.
         */
        public void bubblesort(){
            animationBBS(0,1);
            cont++;
        }

        /**
         * Método que se encarga de las animaciones que el usuario verá en pantalla al realizarse el
         * ordenamiento.
         * @param a
         * @param b
         */
        public void animationBBS(final int a, final int b){
            handler.postDelayed(new Runnable() {

                /**
                 * Método que se encarga de realizar las comparaciones de los valores que se encuentran
                 * en el array ¨txtnum¨ para realizar un cambio o mo de posiciones de los valores según
                 * sea el valor en la posición ¨a¨ mayor, menor o  igual al valor de la posición ¨b¨.
                 * Además cambia el color de fondo de los dos elementos que se encuentran en comparación
                 * para que el usuario pueda observar los valores que está comparando la aplicación.
                 */
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
