package sv.edu.utec.diegoceron2516252019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.diegoceron2516252019.datos.VehiculoDAO;

public class Vehiculos extends AppCompatActivity {
Button btnAdvehiculo;
EditText txtMarca,txtModelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculos);

        btnAdvehiculo=findViewById(R.id.btnAgV);
        txtMarca=findViewById(R.id.edtMarca);
        txtModelo=findViewById(R.id.edtModelo);

        btnAdvehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VehiculoDAO dao= new VehiculoDAO(Vehiculos.this);
                long codiSave=dao.insertVehiculo(txtMarca.getText().toString(),txtModelo.getText().toString());
                if(codiSave>0){
                    Toast.makeText(Vehiculos.this, "Registro Insertado", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Vehiculos.this, "Error al insertar", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}