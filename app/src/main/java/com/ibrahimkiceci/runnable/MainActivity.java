package com.ibrahimkiceci.runnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Runnable runnable; // Bir islemi bir cok kez yapmayi saglayan (belirtilen periyotta) bir arayuz
    Handler handler; // Runnable'i ele aldigimiz bir arayuz runnable ile calismayi saglayan arayuz
    int number;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        number = 0;
        button1 =findViewById(R.id.button1);



    }

    public void start(View view){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                // Burada yazdigin hersey benim belirttigim periyot icerisinde olacaktir.

                textView.setText("Time: " + number);
                number++;
                textView.setText("Time: " + number);
                handler.postDelayed(runnable, 1000 ); // handler kullanilarak runnable baslatilir.



            }
        };

        handler.post(runnable);
        button1.setEnabled(false);




    }

    public void stop(View view){

        button1.setEnabled(true);

        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Time: " + number);




    }


}