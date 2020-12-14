package isi.com.exo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnConnect;
    private EditText txtLogin, txtPassword;
    private String login,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConnect = findViewById(R.id.btnSave);
        txtLogin = findViewById(R.id.txtLogin);
        txtPassword = findViewById(R.id.txtPassword);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = txtLogin.getText().toString().trim();
                password = txtPassword.getText().toString();
                if(!login.isEmpty() && !password.isEmpty()){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    String message = "Champs requis";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT);
                }
            }
        });
    }
}