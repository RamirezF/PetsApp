package app.android.frisco.petsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.android.frisco.petsapp.R;
import app.android.frisco.petsapp.activities.RegistroActivity;
import app.android.frisco.petsapp.clases.User;
import app.android.frisco.petsapp.interfaces.ApiService;
import app.android.frisco.petsapp.services.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText clave;
    private Button btn_ingresar;
    private Button btn_registrar;
    private String correo;
    private static final String TAG = "FRISCO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.txt_usuario);
        clave=findViewById(R.id.txt_clave);
        btn_ingresar=findViewById(R.id.btn_ingresar);
        btn_registrar=findViewById(R.id.btn_registro);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validar();
            }
        });
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ir_registro();
            }
        });


    }

    public void Validar(){
        correo=email.getText().toString();
        ApiService service=ApiServiceGenerator.createService(ApiService.class);
        service.getUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<User> user = response.body();
                        for (int i=0; i<user.size();i++){
                            Log.e(TAG, "Nombre: " + user.get(i).getNombre());
                            Cargar();
                        }

                    } else {
                        throw new Exception(ApiServiceGenerator.parseError(response).getMessage());
                    }
                }catch (Throwable t){
                    Log.e(TAG, "onThrowable: " + t.getMessage(), t);
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    private void Cargar() {
        Intent intent=new Intent(this,WelcomeActivity.class);
        startActivity(intent);
    }

    public void Ir_registro(){
        Intent intent=new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}