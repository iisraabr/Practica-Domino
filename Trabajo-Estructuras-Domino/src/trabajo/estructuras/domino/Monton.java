package trabajo.estructuras.domino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monton implements MontonITF {

    private ArrayList<Ficha> fichas;
    int numFichas = 28;
    public Monton() {
        this.fichas = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new Ficha(i, j));
            }
        }
    }

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
        if (!estaVacio()) {
            return fichas.remove(fichas.size() - 1);
        }
        return null;
    }
    
    
}
