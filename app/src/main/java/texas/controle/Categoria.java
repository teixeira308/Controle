package texas.controle;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 19/05/2015.
 */
public class Categoria {

    public int ID_CATEOGIA;
    public String NOME_CATEGORIA;

    public Categoria(int ID_CATEOGIA, String NOME_CATEGORIA) {
        this.ID_CATEOGIA = ID_CATEOGIA;
        this.NOME_CATEGORIA = NOME_CATEGORIA;
    }

    public int getID_CATEOGIA() {
        return ID_CATEOGIA;
    }

    public void setID_CATEOGIA(int ID_CATEOGIA) {
        this.ID_CATEOGIA = ID_CATEOGIA;
    }

    public String getNOME_CATEGORIA() {
        return NOME_CATEGORIA;
    }

    public void setNOME_CATEGORIA(String NOME_CATEGORIA) {
        this.NOME_CATEGORIA = NOME_CATEGORIA;
    }


}
