package isi.com.exo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private  Button btnQuitter,btnSave;
    private EditText txtPrenom,txtNom,txtAdresse,txtFiliere,txtClasse;
    private  Spinner spinnerSexe;

    String prenom,nom,adresse,filiere,classe,sexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnQuitter = findViewById(R.id.btnAnnule);
        btnSave = findViewById(R.id.btnSave);
        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtPrenom = findViewById(R.id.txtPrenom);
        txtNom = findViewById(R.id.txtNom);
        txtAdresse = findViewById(R.id.txtAdresse);
        txtFiliere = findViewById(R.id.txtAdresse);
        txtClasse = findViewById(R.id.txtClasse);
        spinnerSexe = findViewById(R.id.spinnerSexe);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prenom = txtPrenom.getText().toString();
                nom = txtNom.getText().toString();
                adresse = txtAdresse.getText().toString();
                filiere = txtFiliere.getText().toString();
                classe = txtClasse.getText().toString();
                sexe = spinnerSexe.toString();
                Intent intent = new Intent(HomeActivity.this,DetailsActivity.class);
                intent.putExtra("prenom",prenom);
                intent.putExtra("sexe",sexe);
                startActivity(intent);
                finish();
            }
        });

        Spinner spinner = findViewById(R.id.spinnerSexe);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sexe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}