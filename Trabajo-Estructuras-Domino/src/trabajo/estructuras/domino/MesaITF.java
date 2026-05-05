package trabajo.estructuras.domino;

public interface MesaITF {

    boolean estaVacia();
    void colocarFichaInicio(Ficha f);
    void colocarFichaFinal(Ficha f);
    int getValorIzquierdo();
    int getValorDerecho();
    void mostrarMesa();

}
