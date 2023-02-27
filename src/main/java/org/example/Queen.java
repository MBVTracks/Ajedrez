package org.example;
/**
 * clase King que hereda de la clase Pieza
 * @author MB.
 * @version 0.01 29/01/2023.
 */

public class Queen extends Pieza{
    /**
     * clase Peon que hereda de la clase Pieza
     * @author MB.
     * @version 0.01 29/01/2023.
     */
    public Queen(boolean color, String nombre) {
        super(color, nombre);
    }

    /**
     * Constructor.
     */
    public Queen() {
        super();
    }

    /**
     * Metodo que valida el movimiento de la pieza.
     * @param movimiento
     * @return boolean = true si el movimiento es valido.
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return movimiento.esDiagonal() || movimiento.esHorizontal() || movimiento.esVertical();
    }

    /**
     * Metodo para pintar una pieza dada.
     */
    @Override
    public void pintarPieza() {

    }
}
