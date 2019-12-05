package app.android.frisco.petsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.android.frisco.petsapp.R;

public class RegistroActivity extends AppCompatActivity {
    private EditText fullname,email,password;
    private Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        fullname=findViewById(R.id.txt_fullname);
        email=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        btn_registrar=findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=fullname.getText().toString();
                String ema=email.getText().toString();
                String pass=password.getText().toString();
                Enviar(name,ema,pass);
            }
        });
    }
    public void Enviar(String fullname, String email, String password){

    }
}
