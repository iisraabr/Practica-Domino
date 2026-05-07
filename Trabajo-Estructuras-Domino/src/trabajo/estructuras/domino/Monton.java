package trabajo.estructuras.domino;

import java.util.ArrayList;
import java.util.Random;

public class Monton implements MontonITF {

    //al final no usamos MAXFICHAS porque usamos (size)
    private ArrayList<Ficha> fichas;

    //Constructor
    public Monton() {
        this.fichas = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }
        }
    }
//Helpers simples
    @Override
    public boolean estaVacio() {
        return fichas.isEmpty();
    }

    @Override
    public int fichasRestantes() {
        return fichas.size();
    }

    @Override
    public Ficha extraerFicha() {
        if (estaVacio()) {
            System.out.println("El monton esta vacio.");
            return null;
        }
        //randomizar extracción de ficha para evitar mezclarlas
        Random generador = new Random();
        int rnd = generador.nextInt(fichas.size());

        Ficha fichaExtraida = fichas.remove(rnd);

        return fichaExtraida;
    }

}
