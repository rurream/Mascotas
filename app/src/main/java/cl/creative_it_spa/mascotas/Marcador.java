package cl.creative_it_spa.mascotas;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Marcador extends AppCompatActivity  {

    Toolbar barra;
    ArrayList<ListaMascotas> favoritos;
    RecyclerView rvlistaMascotasTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);

        barra = (Toolbar) findViewById(R.id.barra_sup);
        setSupportActionBar(barra);
        barra.setTitleTextColor(getResources().getColor(R.color.colorBlanco));

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        rvlistaMascotasTop=(RecyclerView) findViewById(R.id.rvTop_5_Mascotas);
        favoritos=new ArrayList<>();
        favoritos=MainActivity.mascotas_top;

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvlistaMascotasTop.setLayoutManager(llm);

        inicializarAdaptadorMascotasTop();
    }




    public void inicializarAdaptadorMascotasTop(){
        AdaptMascotasTop adaptadorTop =new AdaptMascotasTop(favoritos, this);
        rvlistaMascotasTop.setAdapter(adaptadorTop);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_acerca_de:
                Toast.makeText(this, "Has seleccionado Acerca de ...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_configuraciones:
                Toast.makeText(this, "Has seleccionado Configuración", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
