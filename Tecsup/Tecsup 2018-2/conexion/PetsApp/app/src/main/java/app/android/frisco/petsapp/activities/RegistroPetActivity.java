package app.android.frisco.petsapp.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import app.android.frisco.petsapp.R;

public class RegistroPetActivity extends AppCompatActivity {
    private EditText name_pet, raza_pet, edad_pet;
    private Button registrar_pet;
    private ImageView img;
    private FloatingActionButton clic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pet);

        name_pet=findViewById(R.id.txt_pet_name);
        raza_pet=findViewById(R.id.txt_pet_raza);
        edad_pet=findViewById(R.id.txt_pet_edad);
        registrar_pet=findViewById(R.id.btn_registrar_pet);
        img=findViewById(R.id.img_pet);
        clic=findViewById(R.id.btn_float);

        registrar_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarPet();
            }
        });
    }

    public void AgregarPet(){

    }
}
