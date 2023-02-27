package org.example;

/**
 * clase Posicion.
 * @author MB
 * @version 0.01 29.01.2023
 */

public class Posicion {
    private int fila;
    private int columna;

    /**
     * Constructor vacio.
     */
    public Posicion(){
        fila = 0;
        columna = 0;
    }

    /**
     *Constructor.
     * @param fila
     * @param columna
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Getter
     * @return fila.
     */
    public int getFila() {
        return fila;
    }

    /**
     *
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Getter.
     * @return columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     *
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
