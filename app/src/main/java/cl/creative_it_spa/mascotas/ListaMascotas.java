package cl.creative_it_spa.mascotas;

/**
 * Created by Rodrigo on 08-06-2017.
 * ESTA ES LA CLASE POJO o DATASET
 */

public class ListaMascotas {

    String nombre_mascota;
    String puntaje_mascota;
    String posicion_lista;
    int foto_mascota;



    public ListaMascotas(String posicion_lista, String nombre_mascota, String puntaje_mascota, int foto_mascota) {
        this.nombre_mascota = nombre_mascota;
        this.puntaje_mascota = puntaje_mascota;
        this.foto_mascota = foto_mascota;
        this.posicion_lista = posicion_lista;
    }

    public String getPosicion_lista() {
        return posicion_lista;
    }

    public void setPosicion_lista(String posicion_lista) {
        this.posicion_lista = posicion_lista;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getPuntaje_mascota() {
        return puntaje_mascota;
    }

    public void setPuntaje_mascota(String puntaje_mascota) {
        this.puntaje_mascota = puntaje_mascota;
    }

    public int getFoto_mascota() {
        return foto_mascota;
    }

    public void setFoto_mascota(int foto_mascota) {
        this.foto_mascota = foto_mascota;
    }
}
