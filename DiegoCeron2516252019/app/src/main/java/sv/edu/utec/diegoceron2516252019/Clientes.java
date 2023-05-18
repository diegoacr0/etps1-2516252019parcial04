package sv.edu.utec.diegoceron2516252019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.diegoceron2516252019.datos.ClienteDAO;
import sv.edu.utec.diegoceron2516252019.datos.VehiculoDAO;

public class Clientes extends AppCompatActivity {
    Button btnAddClientes;
    EditText txtNombres,txtApellidos,txtDireccion,txtCiudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        btnAddClientes = findViewById(R.id.btnAddClientes);
        txtNombres = findViewById(R.id.edtNombres);
        txtApellidos = findViewById(R.id.edtApellidos);
        txtDireccion = findViewById(R.id.edtDireccion);
        txtCiudad = findViewById(R.id.edtCiudad);

        btnAddClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClienteDAO dao= new ClienteDAO(Clientes.this);
                long codiSave=dao.insertCliente(txtNombres.getText().toString(),txtApellidos.getText().toString(),txtDireccion.getText().toString(),txtCiudad.getText().toString());
                if(codiSave>0){
                    Toast.makeText(Clientes.this, "Registro Insertado", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Clientes.this, "Error al insertar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}