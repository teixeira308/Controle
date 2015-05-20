package texas.controle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "Controle";
    private static int VERSAO = 1;
    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE categoria (_id INTEGER PRIMARY KEY," +
                " descricao TEXT);");
        db.execSQL("CREATE TABLE gasto (_id INTEGER PRIMARY KEY," +
                " _idcategoria INTEGER, data DATE, valor DOUBLE," +
                "  local TEXT," +
                " FOREIGN KEY(_idcategoria) REFERENCES categoria(_id));");
    }
            @Override
            public void onUpgrade(SQLiteDatabase db,
                                  int oldVersion, int newVersion) {

    }}