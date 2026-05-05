package trabajo.estructuras.domino;

public class Ficha {

    int lado1;
    int lado2;

    public Ficha(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }

    public void girar() {
        int aux = lado1;
        lado1 = lado2;
        lado2 = aux;
    }

    public int getsuma() {
        return lado1 + lado2;
    }

    public String toString() {
        return "[ " + lado1 + " | " + lado2 + " ]";
    }
}
