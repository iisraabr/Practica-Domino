package trabajo.estructuras.domino;



public interface JugadorITF {

    void robarFicha(Monton monton);
    Ficha elegirFicha(int posicion);
    void mostrarMano();
    int sumarPuntosMano();
    int numFichas();
}
