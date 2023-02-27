package org.example;

/**
 * clase Caballo que hereda de la clase Pieza
 * @author MB.
 * @version 0.01 29/01/2023.
 */
public class Alfil extends Pieza{

    /**
     * Constructor que hereda de la clase padre (Pieza).
     * @param color
     * @param nombre
     */
    public Alfil (boolean color, String nombre) {
        super(color, nombre);
    }

    /**
     * Constructor.
     */
    public Alfil() {
        super();
    }

    /**
     * Metodo que valida el movimiento de la pieza.
     * @param movimiento
     * @return boolean = true si el movimiento es valido.
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento, Tablero tablero) {
        return movimiento.esDiagonal();
    }

    /**
     * Metodo para pintar una pieza dada.
     */
    @Override
    public void pintarPieza() {

    }
}
