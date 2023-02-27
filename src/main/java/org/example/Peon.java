package org.example;

/**
 * clase Peon que hereda de la clase Pieza
 * @author MB.
 * @version 0.01 29/01/2023.
 */
public class Peon extends Pieza {
    /**
     * Constructor que hereda de la clase padre (Pieza).
     * @param color
     * @param nombre
     */
    public Peon(boolean color, String nombre) {
        super(color, nombre);
    }

    /**
     * Constructor.
     */
    public Peon() {
        super();
    }

    /**
     * Metodo que valida el movimiento de la pieza.
     * @param movimiento
     * @return boolean = true si el movimiento es valido.
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        if (movimiento.esVertical() && movimiento.saltoVertical() == 1 || movimiento.saltoVertical() == 2)
            return true;
        if (movimiento.esDiagonal() && movimiento.saltoDiagonal() == 1)
            return true;
        else
            return false;
    }

    /**
     * Metodo para pintar una pieza dada.
     */
    @Override
    public void pintarPieza() {

    }
}
