package com.example.cours1;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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

        initViews();

        buttonSignup.setOnClickListener(v -> {
            if (isFormValid()) {
                performSignup();
            }
        });
    }

    private void initViews() {
        inputName = findViewById(R.id.editTextText);
        inputEmail = findViewById(R.id.editTextTextEmailAddress);
        inputPassword = findViewById(R.id.editTextTextPassword);
        inputConfirmPassword = findViewById(R.id.editTextTextPassword2);
        buttonSignup = findViewById(R.id.buttonSignup);
    }

    private boolean isFormValid() {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String pwd = inputPassword.getText().toString();
        String confirmPwd = inputConfirmPassword.getText().toString();

        // On vérifie chaque condition une par une pour un feedback précis
        if (name.isEmpty()) {
            showError(inputName, "Le nom est requis");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError(inputEmail, "Email invalide");
            return false;
        }

        if (pwd.length() < 8) {
            showError(inputPassword, "Minimum 8 caractères requis");
            return false;
        }

        if (!pwd.equals(confirmPwd)) {
            showError(inputConfirmPassword, "Les mots de passe ne correspondent pas");
            return false;
        }

        return true;
    }

    /**
     * Centralise l'affichage des erreurs sur les champs
     */
    private void showError(EditText field, String message) {
        field.setError(message);
        field.requestFocus(); // Remet le curseur sur le champ en erreur
    }

    private void performSignup() {
        buttonSignup.setBackgroundColor(Color.BLUE);
        Toast.makeText(this, "Inscription réussie !", Toast.LENGTH_SHORT).show();
        Log.d("AUTH", "Tentative d'inscription pour : " + inputEmail.getText());
    }
}