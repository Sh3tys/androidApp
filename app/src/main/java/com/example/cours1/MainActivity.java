package com.example.cours1;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils; // Utilitaire pratique pour vérifier les chaînes
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText inputName, inputEmail, inputPassword, inputConfirmPassword;
    private MaterialButton buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison des vues
        inputName = findViewById(R.id.editTextText);
        inputEmail = findViewById(R.id.editTextTextEmailAddress);
        inputPassword = findViewById(R.id.editTextTextPassword);
        inputConfirmPassword = findViewById(R.id.editTextTextPassword2);
        buttonSignup = findViewById(R.id.buttonSignup);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // On appelle notre fonction de validation
                if (formulaireEstValide()) {
                    // Si valide, on change la couleur et on traite les données
                    buttonSignup.setBackgroundColor(Color.BLUE);
                    Toast.makeText(MainActivity.this, "Succès !", Toast.LENGTH_SHORT).show();
                    Log.d("FORM", "Données prêtes à être envoyées");
                }
            }
        });
    }

    /**
     * Fonction personnalisée pour valider les champs
     * @return true si tous les champs sont remplis et corrects
     */
    private boolean formulaireEstValide() {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String pwd = inputPassword.getText().toString();
        String confirmPwd = inputConfirmPassword.getText().toString();

        // 1. Vérification si un champ est vide
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches() ||
                TextUtils.isEmpty(pwd) || TextUtils.isEmpty(confirmPwd)) {

            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 2. Vérification de la correspondance des mots de passe
        if (!pwd.equals(confirmPwd)) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
            return false;
        }

        // 3. (Optionnel) Vérification de la longueur du mot de passe
        if (pwd.length() < 8) {
            inputPassword.setError("Minimum 8 caractères"); // Affiche une petite erreur sur le champ
            return false;
        }

        return true; // Si on arrive ici, tout est bon !
    }
}