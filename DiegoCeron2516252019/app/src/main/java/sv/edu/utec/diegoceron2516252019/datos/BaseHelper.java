package sv.edu.utec.diegoceron2516252019.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASE="BDPARCIAL04.db";
    public static final String NOMBRE_TABLAMC="MD_Clientes";
    public static final String NOMBRE_TABLAMCV="MD_CLienteVehiculo";
    public static final String NOMBRE_TABLAMV="MD_Vehiculos";
    /*
        public BaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
        }

    */
    public BaseHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NOMBRE_TABLAMC+" ("+
                "ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sNombreCliente TEXT NOT NULL ,"+
                "sApellidosCliente TEXT NOT NULL ,"+
                "sDireccionCliente TEXT NOT NULL," +
                "sCiudadCliente TEXT NOT NULL"
                +")");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLAMV+" ("+
                "ID_Vehiculo INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sMarca TEXT NOT NULL ,"+
                "sModelo TEXT NOT NULL "+
                ")");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLAMCV+" ("+
                "ID_Cliente INTEGER,"+
                "ID_Vehiculo INTEGER,"+
                "sMatricula TEXT NOT NULL ,"+
                "Kilometros TEXT NOT NULL,"+
                "FOREIGN KEY (ID_Cliente) REFERENCES MD_Clientes(ID_Cliente),"+
                "FOREIGN KEY (ID_Vehiculo) REFERENCES MD_Vehiculos(ID_Vehiculo)"
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+NOMBRE_TABLAMC);
        db.execSQL("DROP TABLE "+NOMBRE_TABLAMV);
        db.execSQL("DROP TABLE "+NOMBRE_TABLAMCV);
        /*adicion de creacion base de datos 03052023*/
        onCreate(db);
        /*adicion de creacion base de datos 03052023*/
    }
}