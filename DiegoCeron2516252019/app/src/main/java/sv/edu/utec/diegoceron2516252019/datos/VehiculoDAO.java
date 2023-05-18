package sv.edu.utec.diegoceron2516252019.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class VehiculoDAO extends BaseHelper{
    Context context;
    public VehiculoDAO(@Nullable Context context) {
        super(context);
    }
    public long insertVehiculo(String sMarca,String sModelo){

        long codigo=0;
        try {

            BaseHelper baseHelp = new BaseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresVehi = new ContentValues();
            valoresVehi.put("sMarca", sMarca);
            valoresVehi.put("sModelo", sModelo);

            codigo= bd.insert("MD_Vehiculos", null, valoresVehi);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }

    }
}
