package org.example;
/**
 * clase King que hereda de la clase Pieza
 * @author MB.
 * @version 0.01 29/01/2023.
 */
public class King extends Pieza{
    /**
     * clase Peon que hereda de la clase Pieza
     * @author MB.
     * @version 0.01 29/01/2023.
     */
    public King(boolean color, String nombre) {
        super(color, nombre);
    }

    /**
     * Constructor.
     */
    public King() {
        super();
    }

    /**
     * Metodo que valida el movimiento de la pieza.
     * @param movimiento
     * @return boolean = true si el movimiento es valido.
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        if (movimiento.esVertical() && movimiento.saltoVertical() == 1)
            return true;
        else if (movimiento.esHorizontal() && movimiento.saltoHorizontal() == 1)
            return true;
        else if (movimiento.esDiagonal() && movimiento.saltoDiagonal() == 1)
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
