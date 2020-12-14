package isi.com.exo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView txtPrenom,txtsexe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txtPrenom = findViewById(R.id.textPrenom);
        txtsexe = findViewById(R.id.textSexe);

        Intent intent = getIntent();
        String prenom = intent.getStringExtra("prenom");
        String sexe = intent.getStringExtra("sexe");

        txtPrenom.setText(prenom);
        txtsexe.setText(sexe);

    }
}