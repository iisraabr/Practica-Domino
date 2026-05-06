package trabajo.estructuras.domino;

public interface JugadorITF {
    
    void robarFicha(Monton monton);
    Ficha elegirFicha(int posicion);
    void mostrarMano();
    int sumarPuntosMano();
    int numFichas();
    String getNombre();
    Ficha verFicha(int posicion);
    int buscarFicha(int l1, int l2);
}