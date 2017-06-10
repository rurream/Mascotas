package cl.creative_it_spa.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar barra;
    public static ArrayList<ListaMascotas> mascotas;
    public static ArrayList<ListaMascotas> mascotas_top;
    RecyclerView rvlistaMascotas;
    ImageButton bt_top_five;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = (Toolbar) findViewById(R.id.barra_sup);
        setSupportActionBar(barra);
        barra.setTitleTextColor(getResources().getColor(R.color.colorBlanco));
        rvlistaMascotas=(RecyclerView) findViewById(R.id.rvTotalMascotas);

        bt_top_five=(ImageButton) findViewById(R.id.bt_top_five);
        bt_top_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.playSoundEffect(android.view.SoundEffectConstants.CLICK);

                MascotasTopFive mascotas_seleccionadas=new MascotasTopFive(mascotas);
                mascotas_top=new ArrayList<ListaMascotas>();
                mascotas_top=mascotas_seleccionadas.mascotas_top();

                Intent llamado=new Intent(getApplicationContext(), Marcador.class);
                startActivity(llamado);
            }
        });


        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvlistaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptadorMascotas();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Toast.makeText(this, "numero: " + mascotas.size(), Toast.LENGTH_SHORT).show();
    }

    public void inicializarListaMascotas(){
        mascotas=new ArrayList<>();
        mascotas.add(new ListaMascotas("0", "Cheef", "0", R.drawable.m1));
        mascotas.add(new ListaMascotas("1", "Niña", "0", R.drawable.m2));
        mascotas.add(new ListaMascotas("2", "Twins", "0", R.drawable.m3));
        mascotas.add(new ListaMascotas("3", "Pancho Malo", "0",  R.drawable.m4));
        mascotas.add(new ListaMascotas("4", "Math", "0",  R.drawable.m5));
        mascotas.add(new ListaMascotas("5", "Loquillo", "0",  R.drawable.m6));
        mascotas.add(new ListaMascotas("6", "Paco", "0",  R.drawable.m7));
        mascotas.add(new ListaMascotas("7", "Cachupin", "0",  R.drawable.m8));
        mascotas.add(new ListaMascotas("8", "Dentin", "0",  R.drawable.m9));
        mascotas.add(new ListaMascotas("9", "Lucky", "0",  R.drawable.m10));
        mascotas.add(new ListaMascotas("10", "Epidemia", "0",  R.drawable.m11));
    }

    public void inicializarAdaptadorMascotas(){
        AdaptadorMascotas adaptador =new AdaptadorMascotas(mascotas, this);
        rvlistaMascotas.setAdapter(adaptador);

    }

}
