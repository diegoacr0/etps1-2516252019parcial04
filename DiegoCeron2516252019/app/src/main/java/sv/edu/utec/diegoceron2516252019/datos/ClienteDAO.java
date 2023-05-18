package sv.edu.utec.diegoceron2516252019.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class ClienteDAO extends BaseHelper{
    Context contex;
    public ClienteDAO(@Nullable Context context) {
        super(context);
    }

    public long insertCliente(String sNombreCliente,String sApellidosCliente, String sDireccionCliente, String sCiudadCliente){

        long codigo=0;
        try {

            BaseHelper baseHelp = new BaseHelper(contex);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresClient = new ContentValues();
            valoresClient.put("sNombreCliente", sNombreCliente);
            valoresClient.put("sApellidosCliente", sApellidosCliente);
            valoresClient.put("sDireccionCliente", sDireccionCliente);
            valoresClient.put("sCiudadCliente", sCiudadCliente);

            codigo= bd.insert(NOMBRE_TABLAMC, null, valoresClient);
            return codigo;
        }
        catch (Exception ex){
            ex.toString();
            return codigo=1;
        }

    }
}
