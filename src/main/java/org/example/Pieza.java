package org.example;

/**
 * clase abstracta Pieza.
 * @author MB
 * @version 0.01 29/01/2023
 */
public abstract class Pieza {
    protected boolean color; //"False" para piezas negras, "True" para piezas blancas.
    protected String nombre;

    /**
     * Constructor.
     * @param color
     * @param nombre
     */
    public Pieza(boolean color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    /**
     * Constructor.
     */
    public Pieza(){
        this.color = false;
    }

    /**
     * Getter
     * @return color.
     */
    public boolean isColor() {
        return color;
    }

    /**
     * Metodo abstracto que comprueba si un movimento lo puede realizar una pieza determinada.
     * @param movimiento
     * @return boolean = true si la accion es valida.
     */
    public abstract boolean validoMovimiento(Movimiento movimiento, Tablero tablero);
    /**
     * Metodo abstracto para pintar pieza.
     */
    public abstract void pintarPieza();

    @Override
    public String toString() {
        char colorP;
        if (color == false){
            colorP = 'n';
        }else
            colorP = 'b';
        return "|"+nombre+""+colorP+" ";
    }
}
