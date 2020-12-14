package isi.com.mohamedyoussfi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonOk;
    private EditText editTextNumber;
    private TextView textViewIndicateur;
    private ProgressBar progressBarTentatives;
    private TextView textViewTentatives;
    private ListView listViewHistorique;
    private TextView textViewScore;
    private int counter;
    private int score;
    private int secret;
    private int maxTentatives = 10;
    private List<String> listHistorique = new ArrayList<>();
    private ArrayAdapter<String> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOk = findViewById(R.id.buttonOk);
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewIndicateur = findViewById(R.id.textViewIndication);
        textViewTentatives = findViewById(R.id.textViewTentatives);
        progressBarTentatives = findViewById(R.id.progressBarTentatives);
        listViewHistorique = findViewById(R.id.listViewHistorique);
        textViewScore = findViewById(R.id.textViewScore);
        model = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listHistorique);
        listViewHistorique.setAdapter(model);
        initialisation();
        buttonOk.setOnClickListener((evt)-> {
            int number = Integer.parseInt(editTextNumber.getText().toString());
            if(number>secret){
                textViewIndicateur.setText(R.string.valeur_sup);
            }
            else if(number<secret){
                textViewIndicateur.setText(R.string.valeur_inf);

            }else{
                textViewIndicateur.setText(R.string.bravo);
                score+=5;
                textViewScore.setText(String.valueOf(score));
                rejouer();
            }
            listHistorique.add(counter+"=>"+number);
            model.notifyDataSetChanged();
            ++counter;
            textViewTentatives.setText(String.valueOf(counter));
            progressBarTentatives.setProgress(counter);
            if(counter>maxTentatives){
                rejouer();
            }
        });
    }

    private void rejouer() {
        Log.i("myLog","Secret"+secret);
        System.out.println(secret);
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.rejouer));
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.oui), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                initialisation();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.quitter), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.show();
    }

    private void initialisation() {
        secret = 1+(int)(Math.random()*100);
        counter=1;
        listHistorique.clear();model.notifyDataSetChanged();
        textViewTentatives.setText(String.valueOf(counter));
        progressBarTentatives.setProgress(counter);
        progressBarTentatives.setMax(maxTentatives);
        textViewScore.setText(String.valueOf(score));
    }
}