package com.example.zegarszachowy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    private Gracz gracz1;
    private Gracz gracz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        gracz1 = new Gracz(true, button1);
        gracz1.liczCzas();
        gracz2 = new Gracz(false, button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gracz1.czyAktywny) {
                    gracz2.liczCzas();
                    gracz1.stopCzas();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gracz2.czyAktywny) {
                    gracz1.liczCzas();
                    gracz2.stopCzas();
                }
            }
        });
    }
}