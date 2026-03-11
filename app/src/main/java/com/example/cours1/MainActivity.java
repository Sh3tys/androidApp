package com.example.cours1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Recup la page activity_main
        Button monBouton = findViewById(R.id.buttonSignup); // cherche un button a l'id = buttonSignup

        //Le listener pour ecouter si le bouton est cliqué
        monBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * envoie le message Hello dans le terminal
             * quand btn cliquer
             */
            public void onClick(View v) {
                monBouton.setBackgroundColor(Color.BLUE);
                Log.d("TEST","Hello");// envoie message log
                System.out.println("Hell nah bro");// envoie message console
            }
        });
    }
}