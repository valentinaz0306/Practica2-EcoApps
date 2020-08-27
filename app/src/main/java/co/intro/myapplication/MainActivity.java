package co.intro.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView operacion;
    private TextView puntaje;
    private EditText respuesta;
    private Button responder;
    private TextView time;
    private ArrayList<Pregunta> listaPreguntas;
    private int indice;
    private int contador=0;
    private int tiempo=0;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 15 preguntas
        listaPreguntas= new ArrayList<Pregunta>();
        listaPreguntas.add(new Pregunta("5X4","20"));
        listaPreguntas.add(new Pregunta("2+5","7"));
        listaPreguntas.add(new Pregunta("20/4","5"));
        listaPreguntas.add(new Pregunta("20+35","55"));
        listaPreguntas.add(new Pregunta("10-7","3"));
        listaPreguntas.add(new Pregunta("100+2000","2100"));
        listaPreguntas.add(new Pregunta("11X11","121"));
        listaPreguntas.add(new Pregunta("12X12","144"));
        listaPreguntas.add(new Pregunta("6X6","36"));
        listaPreguntas.add(new Pregunta("200X60","12000"));
        listaPreguntas.add(new Pregunta("145+525","670"));
        listaPreguntas.add(new Pregunta("1400-300","1100"));
        listaPreguntas.add(new Pregunta("50/10","5"));
        listaPreguntas.add(new Pregunta("600X10","6000"));
        listaPreguntas.add(new Pregunta("30/10","3"));
        indice=(int) (Math.random() * 14) + 0;

        //referenciar
        operacion=findViewById(R.id.operacion);
        puntaje=findViewById(R.id.puntaje);
        respuesta=findViewById(R.id.respuesta);
        responder=findViewById(R.id.responder);
        time=findViewById(R.id.time);
        timer();
        operacion.setText(listaPreguntas.get(indice).getPregunta());
        //Toast.makeText(this,listaPreguntas.get(indice).getPregunta(),Toast.LENGTH_LONG).show();
        //Log.e("holaaa",listaPreguntas.get(indice).getPregunta()+ indice);



   responder.setOnClickListener(
            (v)->{
               // Toast.makeText(this,respuesta.getText()+ " "+ listaPreguntas.get(indice).getRespuesta(),Toast.LENGTH_LONG).show();
                if(String.valueOf(respuesta.getText()).equals(listaPreguntas.get(indice).getRespuesta())){
                contador++;
                puntaje.setText("puntaje: "+contador);
               //Toast.makeText(this,"HOLA",Toast.LENGTH_LONG).show();
                }
                respuesta.setText("");
                int temp=indice;
                while (temp==indice){
                    indice=(int) (Math.random() * 14) + 0;
                }
                operacion.setText(listaPreguntas.get(indice).getPregunta());

            }//cierra


    );



        }

        public void timer(){

            new Thread(

                ()->{
                    tiempo=30;
                    while (tiempo>=0){
                        runOnUiThread(
                                ()->{
                                    time.setText(tiempo+" ");
                                }
                        );
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        tiempo--;
                    }

                }

            ).start();




        }

    }

