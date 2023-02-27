package org.example;
/**
 * clase Tablero.
 * @author MB.
 * @version 0.01 29/01/2023
 */

public class Tablero {
    private Pieza tablero [][] = new Pieza[8][8];

    public Tablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }

    //Primer corchete [] <-- fila. Segundo corchete [] <--- columna.

    /**
     * Constructor.
     * Inicializa un array de piezas.
     * @author MB
     * @version 0.01 29/01/2023
     */
    public Tablero(){
        //<--- Fichas blancas --->
        tablero [0][0] = new Torre(true, "T");
        tablero [0][1] = new Caballo(true, "C");
        tablero [0][2] = new Alfil(true, "A");
        tablero [0][3] = new King(true, "K");
        tablero [0][4] = new Queen(true, "Q");
        tablero [0][5] = new Alfil(true, "A");
        tablero [0][6] = new Caballo(true, "C");
        tablero [0][7] = new Torre(true, "T");
        //Bucle que pinta Peon blanco.
        for (int i = 0; i < tablero.length; i++) {
            tablero[1][i] = new Peon(true, "P");
        }
        //<--- Fichas negras --->
        tablero [7][7] = new Torre(false, "T");
        tablero [7][6] = new Caballo(false, "C");
        tablero [7][5] = new Alfil(false, "A");
        tablero [7][4] = new Queen(false, "Q");
        tablero [7][3] = new King(false, "K");
        tablero [7][2] = new Alfil(false, "A");
        tablero [7][1] = new Caballo(false, "C");
        tablero [7][0] = new Torre(false, "T");
        //Bucle que pinta Peon negro.
        for (int i = tablero.length; i > 0; i--) {
            tablero[6][i-1] = new Peon(false, "P");
        }

    }

    /**
     * Metodo que pinta el tablero sobre el que se va a jugar.
     */
    public void pintarTablero(){
        System.out.println("* | A | B | C | D | E | F | G | H |");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < tablero.length; j++) {
                if(tablero[i][j] != null){
                    System.out.print(tablero[i][j]+"");
                }
                else
                    System.out.print("|   ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    /**
     * Metodo que comprueba si se encuentra una pieza en una fila/columna especifica.
     * @param fila
     * @param columna
     * @return boolean = true si es verdad.
     */
    public boolean hayPieza(int fila, int columna){ // Metodo que comprueba si hay alguna pieza pintada en el tablero (metiendo los parametros de fila y columna).
        if (tablero[fila][columna] != null)
            return true;
        else
            return false;
    }

    /**
     * Metodo que comprueba si se encuentra una pieza en el tablero segun su posicion.
     * @param posicion
     * @return boolean = true si en esa posicion se encuentra una pieza.
     */
    public boolean hayPieza(Posicion posicion){
        if (tablero[posicion.getFila()][posicion.getColumna()] != null)
            return true;
        else
            return false;
    }

    /**
     * Metodo que comprueba si al realizar un movimiento, se encuentra una pieza entre el movimiento inical y el final.
     * @param movimiento
     * @return boolean = true si la condicion es correcta.
     */
    public boolean hayPiezaEntre(Movimiento movimiento) {
        boolean comprueba = false;// Comprueba si una pieza esta entre medias de un movimiento. Si esto ocurre, se cambia a true.
        if (movimiento.esHorizontal()) { // Si el movimiento es horizontal, entonces...
            if (movimiento.posicionInicial.getColumna() < movimiento.posFinal.getColumna()) { // Movimiento horizontal derecho.
                for (int i = movimiento.posicionInicial.getColumna(); i < movimiento.posFinal.getColumna(); i++) {
                    if (tablero[movimiento.posicionInicial.getFila()][i] != null) {
                        comprueba = true;
                    }
                }
            }else if (movimiento.posicionInicial.getColumna() > movimiento.posFinal.getColumna()) { // Movimiento horizontal izquierdo.
                for (int i = movimiento.posicionInicial.getColumna(); i > movimiento.posFinal.getColumna(); i--) {
                    if (tablero[movimiento.posicionInicial.getFila()][i] != null) {
                        comprueba = true;
                    }
                }
            }
        }else if (movimiento.esVertical() == true) { // Si el movimiento es vertical, entonces...
            if (movimiento.posicionInicial.getFila() > movimiento.posFinal.getFila()) { // Movimiento vertical hacia delante
                for (int i = movimiento.posicionInicial.getFila(); i > movimiento.posFinal.getFila(); i--) {
                    if (tablero[i][movimiento.posicionInicial.getColumna()] != null) {
                        comprueba = true;
                    }
                }
            }else if (movimiento.posicionInicial.getFila() < movimiento.posFinal.getFila()) { // Movimiento vertical hacia atras.
                for (int i = movimiento.posicionInicial.getFila(); i < movimiento.posFinal.getFila(); i++) {
                    if (tablero[i][movimiento.posicionInicial.getColumna()] != null) {
                        comprueba = true;
                    }
                }
            }
        }else if (movimiento.esDiagonal()) { // Si el movimiento es diagonal, entonces...
            if (movimiento.posicionInicial.getColumna() < movimiento.posFinal.getColumna() && movimiento.posicionInicial.getFila() < movimiento.posFinal.getFila()) { // Movimiento diagonal hacia arriba - derecha.
                for (int i = movimiento.posicionInicial.getColumna(); i < movimiento.posFinal.getColumna(); i++) {
                    for (int j = movimiento.posicionInicial.getFila(); j < movimiento.posFinal.getFila(); j++) {
                        if (tablero[j][i] != null) {
                            comprueba = true;
                        }
                    }
                }
            }else if (movimiento.posicionInicial.getColumna() > movimiento.posFinal.getColumna() && movimiento.posicionInicial.getFila() > movimiento.posFinal.getFila()) { // Movimiento diagonal hacia arriba - izquierda.
                for (int i = movimiento.posicionInicial.getColumna(); i > movimiento.posFinal.getColumna(); i--) {
                    for (int j = movimiento.posicionInicial.getFila(); j < movimiento.posFinal.getFila(); j++) {
                        if (tablero[j][i] != null) {
                            comprueba = true;
                        }
                    }
                }
            }else if (movimiento.posicionInicial.getColumna() < movimiento.posFinal.getColumna() && movimiento.posicionInicial.getFila() > movimiento.posFinal.getFila()) { // Movimiento diagonal hacia abajo - derecha.
                for (int i = movimiento.posicionInicial.getColumna(); i < movimiento.posFinal.getColumna(); i++) {
                    for (int j = movimiento.posFinal.getFila(); j > movimiento.posicionInicial.getFila(); j--) {
                        if (tablero[j][i] != null) {
                            comprueba = true;
                        }
                    }
                }
            }else if (movimiento.posicionInicial.getColumna() > movimiento.posFinal.getColumna() && movimiento.posicionInicial.getFila() < movimiento.posFinal.getFila()) { // Movimiento diagonal hacia abajo - izquierda.
                for (int i = movimiento.posicionInicial.getColumna(); i > movimiento.posFinal.getColumna(); i--) {
                    for (int j = movimiento.posFinal.getFila(); j > movimiento.posicionInicial.getFila(); j--) {
                        if (tablero[j][i] != null) {
                            comprueba = true;
                        }
                    }
                }
            }
            else
                comprueba = false;
        }
        return comprueba;
    }

    /**
     * Metodo que incluye una pieza en el tablero segun la figura, fila y columna.
     * @param figura
     * @param fila
     * @param columna
     */
    public void ponPieza(Pieza figura, int fila, int columna){ // Pone una pieza en el tablero. En el primer parametro se pondria la figura que va a devolver el metodo y en el segundo la posicion de destino.
        tablero[fila][columna] = figura;
    }

    /**
     * Metodo que incluye una pieza en el tablero segun la figura y la posicion.
     * @param figura
     * @param posicion
     */
    public void ponPieza(Pieza figura, Posicion posicion){
        tablero[posicion.getFila()][posicion.getColumna()] = figura;
    }

    /**
     * Metodo que quita una pieza del tablero segun la fila y la columna.
     * @param fila
     * @param columna
     */
    public void quitaPieza(int fila, int columna){ // Sirve para quitar una pieza del tablero. Para llevarlo a cabo se introduce por parametro la fila/columna.
        if (tablero[fila][columna] != null) {
            tablero[fila][columna] = null;
        }
    }

    /**
     * Metodo que quita una pieza del tablero segun la posicion que se le pase por parametro.
     * @param pos
     */
    public void quitaPieza(Posicion pos){
        if(tablero[pos.getFila()][pos.getColumna()] != null)
            tablero[pos.getFila()][pos.getColumna()] = null;
    }

    /**
     * Metodo que devuelve una pieza segun la fila y la posicion que se le pase por parametro.
     * @param fila
     * @param columna
     * @return Pieza.
     */
    public Pieza devuelvePieza(int fila, int columna){ // Es el metodo que sirve para devolver una pieza determinada. Para ello se debe introducir la posicion de la fila/columna y si se encuentra dicha pieza, devuelve tanto esta como sus atributos (color, nombre...).
        return tablero[fila][columna];
    }

    /**
     * Metodo que devuelve una pieza segun la posicion que se introduzca por parametro.
     * @param posicion
     * @return Pieza.
     */
    public Pieza devuelvePieza(Posicion posicion){
        return tablero[posicion.getFila()][posicion.getColumna()];
    }

}
