package trabajo.estructuras.domino;

import java.util.Scanner;

public class Partida implements PartidaITF {
    private Mesa mesa;
    private Monton monton;
    private Jugador j1;
    private Jugador j2;
    private Scanner teclado;

    public Partida() {
        this.teclado = new Scanner(System.in);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.mesa = new Mesa();
        this.monton = new Monton();
        this.j1 = new Jugador("Jugador 1");
        this.j2 = new Jugador("Jugador 2");
    }

    @Override
    public void repartirFichas() {
        for (int i = 0; i < 7; i++) {
            j1.robarFicha(monton);
            j2.robarFicha(monton);
        }
    }

    @Override
    public void jugar() {
        Jugador actual = null;
        boolean alguienTiene66 = false;

        // Repartir hasta que alguien tenga el 6-6
        while (!alguienTiene66) {
            inicializarComponentes();
            repartirFichas();
            if (j1.buscarFicha(6, 6) != -1) {
                actual = j1;
                alguienTiene66 = true;
            } else if (j2.buscarFicha(6, 6) != -1) {
                actual = j2;
                alguienTiene66 = true;
            }
        }

        System.out.println("¡Comienza la partida! " + actual.getNombre() + " tiene el [6|6] y debe empezar.");

        boolean partidaTerminada = false;
        while (!partidaTerminada) {
            System.out.println("\n========================================");
            mesa.mostrarMesa();
            System.out.println("Fichas en el monton: " + monton.fichasRestantes());
            actual.mostrarMano();

            // Mensaje de turno corregido
            System.out.println("\nTurno de: " + actual.getNombre());
            System.out.println("Fichas en mano: " + actual.numFichas());
            System.out.print("Elige numero de FICHA (o 'R' para ROBAR, 'P' para PASAR): ");
            String opcion = teclado.next().toUpperCase();

            if (opcion.equals("R")) {
                actual.robarFicha(monton);
            } else if (opcion.equals("P")) {
                actual = (actual == j1) ? j2 : j1; 
            } else {
                try {
                    int pos = Integer.parseInt(opcion);
                   
                    if (ejecutarJugada(actual, pos)) {
                        if (actual.numFichas() == 0) {
                            System.out.println("\n¡" + actual.getNombre() + " ha ganado la partida!");
                            partidaTerminada = true;
                        } else {
                            actual = (actual == j1) ? j2 : j1;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opcion no valida. Usa un numero, 'R' o 'P'.");
                }
            }
        }
    }

    private boolean ejecutarJugada(Jugador j, int pos) {
        Ficha f = j.verFicha(pos);
        if (f == null) {
            System.out.println("Esa posicion no existe.");
            return false;
        }

        if (mesa.estaVacia()) {
            if (f.getLado1() == 6 && f.getLado2() == 6) {
                j.elegirFicha(pos);
                mesa.colocarFichaFinal(f);
                return true;
            } else {
                System.out.println("!!! Error: Debes empezar con el [6|6].");
                return false;
            }
        }

        System.out.print("¿Colocar al INICIO (I) o al FINAL (F)?: ");
        String lado = teclado.next().toUpperCase();
        
        if (lado.equals("I")) {
            if (f.getLado2() == mesa.getValorIzquierdo()) {
                j.elegirFicha(pos);
                mesa.colocarFichaInicio(f);
                return true;
            } else if (f.getLado1() == mesa.getValorIzquierdo()) {
                f.girar();
                j.elegirFicha(pos);
                mesa.colocarFichaInicio(f);
                return true;
            }
        } else if (lado.equals("F")) {
            if (f.getLado1() == mesa.getValorDerecho()) {
                j.elegirFicha(pos);
                mesa.colocarFichaFinal(f);
                return true;
            } else if (f.getLado2() == mesa.getValorDerecho()) {
                f.girar();
                j.elegirFicha(pos);
                mesa.colocarFichaFinal(f);
                return true;
            }
        }
        
        System.out.println("!!! Movimiento invalido: La ficha " + f + " no encaja ahi.");
        return false; //  El jugador puede volver a intentarlo
    }

    @Override
    public boolean hayGanador() {
        return j1.numFichas() == 0 || j2.numFichas() == 0;
    }
}