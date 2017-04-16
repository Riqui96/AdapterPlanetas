package unicauca.movil.adapterplanetas;

import android.content.Intent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import unicauca.movil.adapterplanetas.adapters.PlanetaAdapter;
import unicauca.movil.adapterplanetas.models.Planeta;
import unicauca.movil.adapterplanetas.util.Data;

public class MainActivity extends AppCompatActivity {

    ListView list;
    PlanetaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        Data.planetas = new ArrayList<>();
        adapter = new PlanetaAdapter(this, Data.planetas);

        list.setAdapter(adapter);
        loadPlanetas();
    }

    //region Load Data
    public void loadPlanetas(){

        Planeta p1 = new Planeta("Tierra", 9.8f);
        Planeta p2 = new Planeta("Marte", SensorManager.GRAVITY_MARS);
        Planeta p3 = new Planeta("Estrella de la muerte", SensorManager.GRAVITY_DEATH_STAR_I );

        Data.planetas.add(p1);
        Data.planetas.add(p2);
        Data.planetas.add(p3);

        adapter.notifyDataSetChanged();
    }
    //endregion


    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_add:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;

            case R.id.action_more:
                Toast.makeText(this, "Presionaste More", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
