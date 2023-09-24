package com.example.sigl2management;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button openpopup;
    private EditText editName;
    private EditText editSurname;
    private HomeActivity activity;

    public void afficherBoiteDeDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Titre de la boîte de dialogue");
        builder.setMessage("Message de la boîte de dialogue");

        // Bouton positif (bouton OK)
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Code à exécuter lorsque l'utilisateur clique sur le bouton OK
                dialog.dismiss(); // Fermer la boîte de dialogue
            }
        });

        // Bouton négatif (bouton Annuler)
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Code à exécuter lorsque l'utilisateur clique sur le bouton Annuler
                dialog.dismiss(); // Fermer la boîte de dialogue
            }
        });

        // Créez et affichez la boîte de dialogue
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.activity = this;
        this.openpopup = (Button) findViewById(R.id.btnValider);
        this.editName = (EditText) findViewById(R.id.Ed1);
        this.editSurname = (EditText) findViewById(R.id.Ed2);


        openpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editName.getText() != null && editSurname.getText() != null){
                    AlertDialog.Builder monpopup = new AlertDialog.Builder(activity);
                    monpopup.setTitle("Qui suis je ?");
                    monpopup.setMessage("Je m'appelle " + editName.getText().toString() + " " + editSurname.getText().toString() + ".");
                    monpopup.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Succès !", Toast.LENGTH_SHORT).show();
                        }
                    });
                    monpopup.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Echec !", Toast.LENGTH_SHORT).show();
                        }
                    });
                    monpopup.show();
                }
            }
        });
    }


}