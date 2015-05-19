package texas.controle;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

/**
 * Created by User on 19/05/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "BD";
    private static final String CATEGORIA_TABLE_NAME = "categoria";

    DatabaseHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory().getAbsolutePath() + "/nome-da-aplicacao/database/" + DATABASE_NAME, null, DATABASE_VERSION);

    }

    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + CATEGORIA_TABLE_NAME + " (" +
                    " _id INT, " +
                    " nome TEXT);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {

    }


}