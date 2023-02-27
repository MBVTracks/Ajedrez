package org.example;

/**
 * clase Torre que hereda de la clase Pieza
 * @author MB.
 * @version 0.01 29/01/2023.
 */

public class Torre extends Pieza{
    /**
     * Constructor que hereda de la clase padre (Pieza).
     * @param color
     * @param nombre
     */
    public Torre(boolean color, String nombre) {
        super(color, nombre);
    }

    /**
     * Constructor.
     */
    public Torre() {
        super();
    }

    /**
     * Metodo que valida el movimiento de la pieza.
     * @param mov
     * @return boolean = true si el movimiento es valido.
     */
    @Override
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        boolean respuesta = false;
        if ((mov.esVertical() || mov.esHorizontal()) && !tablero.hayPiezaEntre(mov))
            respuesta = true;
        else
            System.out.println("No puedes hacer ese movimiento");
        return respuesta;
    }

    /**
     * Metodo para pintar una pieza dada.
     */
    @Override
    public void pintarPieza() {

    }
}
