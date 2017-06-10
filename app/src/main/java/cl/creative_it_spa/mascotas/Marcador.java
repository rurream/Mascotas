package cl.creative_it_spa.mascotas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
}
