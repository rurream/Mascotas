package cl.creative_it_spa.mascotas;


import java.util.ArrayList;

/**
 * Created by Rodrigo on 09-06-2017.
 */

public class MascotasTopFive {
    
   ArrayList<ListaMascotas> listado_total, listado_total_LOCAL, lista_top_5;

    public MascotasTopFive(ArrayList<ListaMascotas> listado_total) {
        this.listado_total = listado_total;
    }


    public ArrayList<ListaMascotas> mascotas_top(){

        listado_total_LOCAL=new ArrayList<ListaMascotas>();

        for(int y=0; y<listado_total.size();y++){
            ListaMascotas mascota_y= listado_total.get(y);
            ListaMascotas mascota_local= listado_total.get(y);
            listado_total_LOCAL.add(new ListaMascotas(mascota_y.getPosicion_lista(),
                    mascota_y.getNombre_mascota(),
                    mascota_y.getPuntaje_mascota(),
                    mascota_y.getFoto_mascota()));
        }


        ArrayList mascota_ya_seleccionada=new ArrayList() ;
        int puntaje=0, numero_mascotas=0, posición_de_la_lista=0;
        lista_top_5=new ArrayList<ListaMascotas>();
        while (numero_mascotas<5){
            puntaje=0;
            posición_de_la_lista=-1;
            for(int x=0; x<listado_total_LOCAL.size();x++){
                if (!mascota_ya_seleccionada.contains(x)) {
                    ListaMascotas mascota_x= listado_total_LOCAL.get(x);
                    String puntajex=mascota_x.getPuntaje_mascota().toString();
                    int puntosx=Integer.parseInt(puntajex.toString());
                    if (puntaje<puntosx){
                        posición_de_la_lista=x;
                        puntaje=puntosx;
                    }
                }
            }
            if (posición_de_la_lista==-1){
                for(int x=0;x<5;x++){
                    if (!mascota_ya_seleccionada.contains(x)) {
                        posición_de_la_lista=x;
                        break;
                    }
                }
            }


            ListaMascotas mascota_seleccionada= listado_total_LOCAL.get(posición_de_la_lista);
            lista_top_5.add(new ListaMascotas(mascota_seleccionada.getPosicion_lista(),
                    mascota_seleccionada.getNombre_mascota(),
                    mascota_seleccionada.getPuntaje_mascota(),
                    mascota_seleccionada.getFoto_mascota()));
            numero_mascotas++;
            mascota_ya_seleccionada.add(posición_de_la_lista);
        }
        return lista_top_5;
    }
}
