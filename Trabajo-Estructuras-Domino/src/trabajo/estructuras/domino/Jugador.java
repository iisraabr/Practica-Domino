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
    public void robarFicha(Monton monton) {
        if (!monton.estaVacio()) {
            Ficha f = monton.extraerFicha();
            mano.add(f);
        }
    }

    @Override
    public void mostrarMano() {
        System.out.println("Fichas " + nombre + ":");

        for (int i = 0; i < mano.size(); i++) {
            System.out.print(mano.get(i).toString() + " ");
        }
        System.out.println();
        System.out.println("Numero de ficha:");
        for (int i = 0; i < mano.size(); i++) {
            System.out.print("  " + i + "   ");
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
}
