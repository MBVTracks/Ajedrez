package org.example;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        System.out.println("***********************************");
        tablero.pintarTablero();
        Juego juego = new Juego();
        juego.jugada("a8a5", tablero);
        System.out.println("***********************************");
        tablero.pintarTablero();
        System.out.println("***********************************");
    }
}
