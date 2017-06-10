package cl.creative_it_spa.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Rodrigo on 08-06-2017.
 */

public class AdaptadorMascotas  extends RecyclerView.Adapter<AdaptadorMascotas.MascotasViewHolder>{

    ArrayList<ListaMascotas> mascotas;
    Activity activity;

    public AdaptadorMascotas(ArrayList<ListaMascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotasViewHolder holder_de_mascotas, int position) {
        final ListaMascotas mascota= mascotas.get(position);
        holder_de_mascotas.img_foto_mascota.setImageResource(mascota.getFoto_mascota());
        holder_de_mascotas.tv_nombre_mascota.setText(mascota.getNombre_mascota());
        holder_de_mascotas.tv_puntos_mascota.setText(mascota.getPuntaje_mascota());

        holder_de_mascotas.img_hueso_blanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.playSoundEffect(android.view.SoundEffectConstants.CLICK);

                String puntaje=mascota.getPuntaje_mascota().toString();
                int puntos=Integer.parseInt(puntaje.toString());
                puntos=puntos+1;
                ListaMascotas mascota_modif=new ListaMascotas(mascota.getPosicion_lista(), mascota.getNombre_mascota(),
                        ""+ puntos, mascota.getFoto_mascota());
                String place=mascota.getPosicion_lista().toString();
                int place_lista=Integer.parseInt(place.toString());
                mascotas.set(place_lista, mascota_modif);

                cambiarPuntaje(holder_de_mascotas, place_lista);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public void cambiarPuntaje(MascotasViewHolder holder_de_mascotas, int position){
        onBindViewHolder(holder_de_mascotas,  position);
        MainActivity.mascotas=new ArrayList<ListaMascotas>();
        MainActivity.mascotas=mascotas;
    }







    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

         ImageView img_foto_mascota, img_hueso_color;
         TextView tv_nombre_mascota;
        TextView tv_puntos_mascota;
        ImageButton img_hueso_blanco;

        public MascotasViewHolder(View itemView) {
            super(itemView);

            img_foto_mascota=(ImageView) itemView.findViewById(R.id.img_foto_mascota);
            tv_nombre_mascota=(TextView) itemView.findViewById(R.id.tv_nombre_mascota);
            tv_puntos_mascota=(TextView) itemView.findViewById(R.id.tv_puntos_mascota);
            img_hueso_blanco=(ImageButton) itemView.findViewById(R.id.img_hueso_blanco);
            img_hueso_color=(ImageView) itemView.findViewById(R.id.img_hueso_color);
        }
    }
}
