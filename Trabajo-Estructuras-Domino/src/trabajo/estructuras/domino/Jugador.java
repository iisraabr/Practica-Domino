package trabajo.estructuras.domino;

import java.util.ArrayList;

public class Jugador implements JugadorITF {

    private ArrayList<Ficha> mano;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<Ficha>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int buscarFicha(int l1, int l2) {
        for (int i = 0; i < mano.size(); i++) {
            Ficha f = mano.get(i);
            if ((f.getLado1() == l1 && f.getLado2() == l2)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Ficha verFicha(int posicion) {
        if (posicion >= 0 && posicion < mano.size()) {
            return mano.get(posicion);
        }
        return null;
    }

    @Override
    public void robarFicha(Monton monton) {
        if (!monton.estaVacio()) {
            Ficha f = monton.extraerFicha();
            mano.add(f);
        }
    }

    @Override
    public void mostrarMano() {
        System.out.println("Fichas " + nombre + ":");
        // Imprime las fichas (cada una ocupa 10 caracteres con el espacio extra)
        for (int i = 0; i < mano.size(); i++) {
            System.out.print(mano.get(i).toString() + " ");
        }
        System.out.println();
        
        System.out.println("Indices:");
        // Imprime los números centrados debajo del "|" de cada ficha [ 0 | 0 ]
        for (int i = 0; i < mano.size(); i++) {
            // 4 espacios + el número + 5 espacios = 10 caracteres de ancho
            System.out.print("    " + i + "     "); 
        }
        System.out.println();
    }

    @Override
    public Ficha elegirFicha(int posicion) {
        if (posicion >= 0 && posicion < mano.size()) {
            return mano.remove(posicion);
        }
        return null;
    }

    @Override
    public int numFichas() {
        return mano.size();
    }

    @Override
    public int sumarPuntosMano() {
        int total = 0;
        for (int i = 0; i < mano.size(); i++) {
            total += mano.get(i).getsuma();
        }
        return total;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}