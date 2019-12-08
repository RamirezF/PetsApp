package app.android.frisco.petsapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.android.frisco.petsapp.R;
import app.android.frisco.petsapp.clases.User;
import app.android.frisco.petsapp.services.ApiService;
import app.android.frisco.petsapp.services.ApiError;
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
    private String password;
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
        password=clave.getText().toString();
        ApiService service = ApiServiceGenerator.createService(ApiService.class);

        Call<User> call = service.login(correo, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) { // code 200
                    User usuario = response.body();
                    Log.d(TAG, "usuario" + usuario);

                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    sp.edit()
                            .putString("correo", usuario.getCorreo())
                            .putBoolean("islogged", true)
                            .commit();

                    // Go Main Activity
                    startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                    finish();

                    Toast.makeText(MainActivity.this, "Bienvenido " + usuario.getNombre(), Toast.LENGTH_LONG).show();

                }else{
                    ApiError error = ApiServiceGenerator.parseError(response);
                    Toast.makeText(MainActivity.this, "onError:" + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure: " + t.toString(), Toast.LENGTH_LONG).show();
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