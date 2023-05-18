package sv.edu.utec.diegoceron2516252019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sv.edu.utec.diegoceron2516252019.datos.BaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseHelper basehelper = new BaseHelper(MainActivity.this);
        SQLiteDatabase db =basehelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Error en crear la Base de datos", Toast.LENGTH_LONG).show();
        }

    }

    public void FrmVehiculo(View v){
        Intent i = new Intent(MainActivity.this,Vehiculos.class);
        startActivity(i);
    }
    public void FrmCliente(View v){
        Intent i2 = new Intent(MainActivity.this,Clientes.class);
        startActivity(i2);
    }
}