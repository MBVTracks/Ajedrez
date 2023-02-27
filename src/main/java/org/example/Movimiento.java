package org.example;

/**
 * clase Movimiento.
 * @author MB.
 * @version 0.01 29/01/2023
 */

public class Movimiento {
    Posicion posicionInicial;
    Posicion posFinal;

    /**
     * Constructor vacio.
     */
    public Movimiento(){
        posicionInicial = new Posicion();
        posFinal = new Posicion();
    }

    /**
     * Constructor.
     * @param posicionInicial
     * @param posFinal
     */
    public Movimiento(Posicion posicionInicial, Posicion posFinal) {
        this.posicionInicial = posicionInicial;
        this.posFinal = posFinal;
    }

    /**
     * Metodo que calcula si el movimiento es vertical
     * @return boolean = true en caso de producirse movimiento vertical.
     */
    public boolean esVertical(){
        return posicionInicial.getColumna() == posFinal.getColumna() && posicionInicial.getFila() != posFinal.getFila();
    }

    /**
     * Metodo que calcula si el movimiento es horizontal.
     * @return boolean = true en caso de producirse movimiento horizontal.
     */
    public boolean esHorizontal(){
        return posicionInicial.getFila() == posFinal.getFila() && posicionInicial.getColumna() != posFinal.getColumna();
    }

    /**
     * Metodo que calcula si el movimiento es diagonal.
     * @return boolean = true en caso de producirse movimiento diagonal.
     */
    public boolean esDiagonal(){
        return posicionInicial.getFila() != posFinal.getFila() && posicionInicial.getColumna() != posFinal.getColumna() &&
                (posFinal.getFila()-posicionInicial.getFila()) == (posFinal.getColumna()-posicionInicial.getColumna());
    }

    /**
     * Devuelve el numero de movimiento horizontal.
     * @return cantidad de movimiento (int).
     */
    public int saltoHorizontal(){
        return Math.abs(posFinal.getColumna() - posicionInicial.getColumna());
    }

    /**
     * Devuelve el numero de movimiento vertical.
     * @return cantidad de movimiento (int).
     */
    public int saltoVertical(){
        return Math.abs(posFinal.getFila() - posicionInicial.getFila());
    }

    /**
     * Devuelve el numero de movimiento diagonal.
     * @return cantidad de movimiento (int).
     */
    public int saltoDiagonal(){
        int a = 0;
        if (this.esDiagonal() && this.saltoVertical() == this.saltoHorizontal()){
            a = this.saltoHorizontal();
        }
        return a;
    }
}
