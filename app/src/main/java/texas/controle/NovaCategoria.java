package texas.controle;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class NovaCategoria extends ActionBarActivity {
    private EditText nome;
    private DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_categoria);
        nome= (EditText) findViewById(R.id.editText);
        helper = new DatabaseHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nova_categoria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

     public void salvarCategoria(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
         ContentValues values = new ContentValues();
         //values.put("_id", 1);
         values.put("descricao", nome.getText().toString());
         long resultado = db.insert("categoria", null, values);
         if(resultado != -1 ){
             Toast.makeText(this, getString(R.string.registro_salvo),
                     Toast.LENGTH_SHORT).show();
                    finish();
         }else{
             Toast.makeText(this, getString(R.string.erro_salvar),
                     Toast.LENGTH_SHORT).show();
         }
     }
    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }

}
