package cl.creative_it_spa.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Rodrigo on 09-06-2017.
 */

public class AdaptMascotasTop extends RecyclerView.Adapter<AdaptMascotasTop.MascotasTopViewHolder>{

    ArrayList<ListaMascotas> mascotas_top;
    Activity activity2;

    public AdaptMascotasTop(ArrayList<ListaMascotas> mascotas_top, Activity activity2) {
        this.mascotas_top = mascotas_top;
        this.activity2 = activity2;
    }

    @Override
    public MascotasTopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_mascotas_top, parent, false);
        return new AdaptMascotasTop.MascotasTopViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotasTopViewHolder holderTop, int position) {
        final ListaMascotas mascota_top= mascotas_top.get(position);
        holderTop.img_foto_mascota_top.setImageResource(mascota_top.getFoto_mascota());
        holderTop.tv_nombre_mascota_top.setText(mascota_top.getNombre_mascota());
        holderTop.tv_puntos_mascota_top.setText(mascota_top.getPuntaje_mascota());
    }

    @Override
    public int getItemCount() {
        return mascotas_top.size();
    }


    public static class MascotasTopViewHolder extends RecyclerView.ViewHolder{

        ImageView img_foto_mascota_top, img_hueso_color_top;
        TextView tv_nombre_mascota_top;
        TextView tv_puntos_mascota_top;
        ImageView img_hueso_blanco_top;

        public MascotasTopViewHolder(View itemView) {
            super(itemView);

            img_foto_mascota_top=(ImageView) itemView.findViewById(R.id.img_foto_mascota_top);
            tv_nombre_mascota_top=(TextView) itemView.findViewById(R.id.tv_nombre_mascota_top);
            tv_puntos_mascota_top=(TextView) itemView.findViewById(R.id.tv_puntos_mascota_top);
            img_hueso_blanco_top=(ImageView) itemView.findViewById(R.id.img_hueso_blanco_top);
            img_hueso_color_top=(ImageView) itemView.findViewById(R.id.img_hueso_color_top);
        }
    }
}
