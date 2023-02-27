package org.example;
/**
 * clase Juego
 * @author MB
 * @version 0.01 29/01/2023.
 */
public class Juego {
    private boolean turno;
    /**
     * Getter.
     * @return turno.
     */
    public boolean isTurno() {
        return turno;
    }
    /**
     * Setter.
     * @param turno
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    /**
     * Metodo que introduce por parametros una jugada determinada. Para ello va a comprobar si la informacion que se mete por parametro
     * es correcta y luego procede a realizar el movimiento.
     * @param jugada
     * @param tablero
     * @return Movimiento.
     */
    public Movimiento jugada(String jugada, Tablero tablero) {
        //Validar el string y convertirlo en Movimiento si es valido.
        Movimiento mov; //Inicializacion de un nuevo movimiento.
        char parteUno = jugada.toUpperCase().charAt(0); //Recoge la posicion uno de una coordenada dada.
        char parteDos = jugada.toUpperCase().charAt(2); //Recoge la posicion tres de una coordenada dada.
        int parteTres = jugada.charAt(1); //Recoge la posicion dos de una coordenada dada.
        int parteCuatro = jugada.charAt(3); //Recoge la posicion cuatro de una coordenada dada.

        int coordenada = 0; //Pasa a numero entero una letra de la posicion uno de la coordenada dada (fila primera parte).
        int coordenadaDos = 0; //Pasa a numero entero una letra de la posicion tres de la coordenada dada (columna).
        int coordenadaTres = 0; //Pasa a numero entero un numero de la posicion dos del array (columna primera parte).
        int coordenadaCuatro = 0; //Pasa a numero entero un numero de la posicion cuatro del array (fila).
        String mensaje = "Jugada no valida, introduzca movimiento de nuevo."; //Mensaje de error.

        if (jugada.length() != 4) { //Condicion que aparece al meter una coordenada superior 4 digitos.
            System.out.println(mensaje);
        }else if (parteUno < (char) 65 || parteUno > (char) 72) { //Condicion que aparece al no introducir una de las opciones (letras) validas. Se pasa a ascii.
            System.out.println(mensaje);
        }else if (parteDos < (char) 65 || parteDos > (char) 72) {
            System.out.println(mensaje);
        }else if (parteTres < (char) 49 || parteTres > (char) 56) { //Condicion que aparece al no introducir uno de las opciones (numeros) validos.
            System.out.println(mensaje);
        }else if (parteCuatro < (char) 49 || parteCuatro > (char) 56) {
            System.out.println(mensaje);
        }switch (parteUno) { //Paso de letras a numeros de posicion del array (columnas).
            case (char) 65:
                coordenada = 0;
                break;
            case (char) 66:
                coordenada = 1;
                break;
            case (char) 67:
                coordenada = 2;
                break;
            case (char) 68:
                coordenada = 3;
                break;
            case (char) 69:
                coordenada = 4;
                break;
            case (char) 70:
                coordenada = 5;
                break;
            case (char) 71:
                coordenada = 6;
                break;
            case (char) 72:
                coordenada = 7;
                break;
            default:
                System.out.println("Error.");
        }switch (parteDos) { //Paso de letras a numeros de posicion del array (columnas).
            case (char) 65:
                coordenadaDos = 0;
                break;
            case (char) 66:
                coordenadaDos = 1;
                break;
            case (char) 67:
                coordenadaDos = 2;
                break;
            case (char) 68:
                coordenadaDos = 3;
                break;
            case (char) 69:
                coordenadaDos = 4;
                break;
            case (char) 70:
                coordenadaDos = 5;
                break;
            case (char) 71:
                coordenadaDos = 6;
                break;
            case (char) 72:
                coordenadaDos = 7;
                break;
            default:
                System.out.println("Error.");
        }switch (parteTres) { //Paso a numeros de posicion del array (filas).
            case (char) 49:
                coordenadaTres = 0;
                break;
            case (char) 50:
                coordenadaTres = 1;
                break;
            case (char) 51:
                coordenadaTres = 2;
                break;
            case (char) 52:
                coordenadaTres = 3;
                break;
            case (char) 53:
                coordenadaTres = 4;
                break;
            case (char) 54:
                coordenadaTres = 5;
                break;
            case (char) 55:
                coordenadaTres = 6;
                break;
            case (char) 56:
                coordenadaTres = 7;
                break;
            default:
                System.out.println("Error.");
        }switch (parteCuatro) { //Paso a numeros de posicion del array (filas).
            case (char) 49:
                coordenadaCuatro = 0;
                break;
            case (char) 50:
                coordenadaCuatro = 1;
                break;
            case (char) 51:
                coordenadaCuatro = 2;
                break;
            case (char) 52:
                coordenadaCuatro = 3;
                break;
            case (char) 53:
                coordenadaCuatro = 4;
                break;
            case (char) 54:
                coordenadaCuatro = 5;
                break;
            case (char) 55:
                coordenadaCuatro = 6;
                break;
            case (char) 56:
                coordenadaCuatro = 7;
                break;
            default:
                System.out.println("Error.");
        }if (tablero.hayPieza(coordenadaTres, coordenada) != true){ // Hay pieza en la posicion inicial? No hay <-- Error.
            System.out.println("Error. No hay pieza en esa posicion");
        }else if (tablero.hayPieza(coordenadaTres,coordenada) == true && tablero.devuelvePieza(coordenadaTres,coordenada).color != turno){ // Color de pieza en posicion inicial no coincide con el turno <-- Error.
            System.out.println("Error. No puedes mover esa pieza, no es de tu color.");
        }else if (tablero.hayPieza(coordenadaCuatro, coordenadaDos) == true && tablero.hayPieza(coordenadaCuatro, coordenadaDos) == turno) //Hay pieza en la posicion final y si la hay el color coincide con el turno
            System.out.println("Error. No puedes comerte tus propias piezas.");
        mov = new Movimiento(new Posicion(coordenadaTres,coordenada), new Posicion(coordenadaCuatro,coordenadaDos)); // Inicializa un movimiento nuevo con las coordenadas.
        if (tablero.devuelvePieza(coordenadaTres, coordenada).validoMovimiento(mov, tablero)){ // Movimiento de piezas.
            if (!tablero.hayPiezaEntre(mov)){
                //
            }else{
                tablero.ponPieza(tablero.devuelvePieza(coordenadaTres, coordenada), coordenadaCuatro, coordenadaDos);
                tablero.quitaPieza(coordenadaTres, coordenada);
            }
        }
        return mov;
    }
    /* Traducciones:
           - hayPieza: Sirve para determinar si hay alguna pieza pintada en el tablero (metiendo los parametros de fila y columna).
           - devuelvePieza: Es el metodo que sirve para devolver una pieza determinada. Para ello se debe introducir la posicion de la fila/columna y si se encuentra dicha pieza, devuelve tanto esta como sus atributos (color, nombre...).
           - ponPieza: Pone una pieza en el tablero. En el primer parametro se pondria la figura que va a devolver el metodo y en el segundo la posicion de destino.
           - quitarPieza: Sirve para quitar una pieza del tablero. Para llevarlo a cabo se introduce por parametro la fila/columna.


           /* else if (tablero.hayPieza(coordenadaTres, coordenada) == true)
     tablero.ponPieza(tablero.devuelvePieza(coordenadaTres,coordenada), coordenadaCuatro,coordenadaDos);
                tablero.quitaPieza(coordenadaTres,coordenada);

    public void mover(Movimiento movimiento, Tablero tablero){
        boolean b = tablero.devuelvePieza(movimiento.posicionInicial).validoMovimiento(movimiento, tablero);
        if (b){
            tablero.ponPieza(tablero.devuelvePieza(movimiento.posicionInicial), movimiento.posFinal);
            tablero.quitaPieza(movimiento.posicionInicial);
        }else
            System.out.println("Movimiento no valido");
    }
        */
}
