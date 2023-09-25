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
    private Button btnAnnuler;
    private EditText editName;
    private EditText editSurname;
    private HomeActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.activity = this;
        this.openpopup = (Button) findViewById(R.id.btnValider);
        this.editName = (EditText) findViewById(R.id.Ed1);
        this.editSurname = (EditText) findViewById(R.id.Ed2);
        this.btnAnnuler = (Button) findViewById(R.id.btnAnnuler);

        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
                editSurname.setText("");
            }
        });

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
                    monpopup.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
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