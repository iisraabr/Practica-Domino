package trabajo.estructuras.domino;

import java.util.LinkedList;

public class Mesa implements MesaITF {
//Usar linkedlist para que mesa actue como bicola
    private LinkedList<Ficha> FichasEnMesa;

    public Mesa() {
        this.FichasEnMesa = new LinkedList<>();
    }

    //helpers simples
    @Override
    public boolean estaVacia() {
        return FichasEnMesa.isEmpty();
    }

    @Override
    public void colocarFichaInicio(Ficha f) {
        FichasEnMesa.addFirst(f);
    }

    @Override
    public void colocarFichaFinal(Ficha f) {
        FichasEnMesa.addLast(f);
    }

    @Override
    public int getValorIzquierdo() {
        if (estaVacia()) {
            return -1;
        }

        return FichasEnMesa.getFirst().getLado1();
    }

    @Override
    public int getValorDerecho() {
        if (estaVacia()) {
            return -1;
        }

        return FichasEnMesa.getLast().getLado2();
    }

    //se usará en el TAD Partida
    @Override
    public void mostrarMesa() {
        if (this.estaVacia()) {
            System.out.println("Mesa: [Vacia]");
        } else {

            System.out.print("Mesa: ");

            for (int i = 0; i < FichasEnMesa.size(); i++) {
                Ficha f = FichasEnMesa.get(i);
                System.out.print(f.toString() + " ");
            }
            System.out.println();
        }
    }

}
