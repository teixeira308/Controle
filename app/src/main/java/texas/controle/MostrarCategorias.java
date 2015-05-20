package texas.controle;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MostrarCategorias extends ListActivity implements AdapterView.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferencias =
                PreferenceManager.getDefaultSharedPreferences(this);

        helper = new DatabaseHelper(this);
    setListAdapter(new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, listarViagens()));

    ListView listView = getListView();
    listView.setOnItemClickListener(this);
    }

    private DatabaseHelper helper;

    private List<Map<String,Object>>  listarViagens() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor =
        db.rawQuery("SELECT _id, descricao FROM categoria", null);
        cursor.moveToFirst();

        ArrayList categorias = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Map< String,Object> item = new HashMap<String, Object>();
            int id = cursor.getInt(0);
            String descricao = cursor.getString(1);

            item.put("descricao",descricao);
            item.put("id",id);
            categorias.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return categorias;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        TextView textView = (TextView) view;
        String mensagem = "Viagem selecionada: " + textView.getText();
        Toast.makeText(getApplicationContext(), mensagem,
                Toast.LENGTH_SHORT).show();
     //   startActivity(new Intent(this, GastoListActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_categorias, menu);
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
}
