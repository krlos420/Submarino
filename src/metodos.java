import java.util.Random;
public class metodos {
    public static String[][] mar;
    public static String[][] jugar() {
        int dim;
        dim = Leer.leerEntero("Que dimensión quieres que tenga el mar? ");
        mar = new String[dim][dim];
        iniciarMar();
        return mar;
    }

    public static int [] iniciarSubmarino(String[][] mar) {
        Random random = new Random();
        int filaSub = random.nextInt(mar.length);
        int columnaSub = random.nextInt(mar[0].length);
        int []submarino = {filaSub, columnaSub};

        mar[filaSub][columnaSub] = "X";
        if (filaSub>0){
            mar[filaSub - 1][columnaSub] = "+";
        }
        if (filaSub<mar.length) {
            mar[filaSub + 1][columnaSub] = "+";
        }
        if (columnaSub>0) {
            mar[filaSub][columnaSub - 1] = "+";
        }
        if (columnaSub<mar.length) {
            mar[filaSub][columnaSub + 1] = "+";
        }
        if (filaSub<mar.length && columnaSub<mar.length) {
            mar[filaSub + 1][columnaSub + 1] = "+";
        }
        if (filaSub>0 && columnaSub>0) {
            mar[filaSub - 1][columnaSub - 1] = "+";
        }
        if (columnaSub>0) {
            mar[filaSub + 1][columnaSub - 1] = "+";
        }
        if (filaSub>0) {
            mar[filaSub - 1][columnaSub + 1] = "+";
        }
        return submarino;
    }

    public static boolean posicionCalibrar(String[][] mar) {
        int filaAdivinar = Leer.leerEntero("Introduix la fila on penses que està el submarí (desde 1 fins a "+(mar.length)+") : ")-1;
        int columnaAdivinar = Leer.leerEntero("Introduix la columna on penses que està el submarí (desde 1 fins a "+(mar.length)+") : ")-1;

        if (filaAdivinar < 0 || filaAdivinar >= mar.length || columnaAdivinar < 0 || columnaAdivinar >= mar[0].length) {
            System.out.println("Coordenades fora del rang. Intenta de nou.");
            return false;
        }
        if (mar[filaAdivinar][columnaAdivinar].equalsIgnoreCase("X")) {
            System.out.println("¡Felicitats! Has trobat el submarí.");
            return true;
        } if (mar[filaAdivinar][columnaAdivinar].equalsIgnoreCase("+")){
            System.out.println("Les coordenades que has introduit están al costat del submarí");
            return false;
        } else {
            System.out.println("No es el submarí seguix intentant-ho");
            return false;
        }
    }
    public static void iniciarMar(){
        for (int i = 0; i < mar.length; i++) {
            for (int j = 0; j < mar.length; j++) {
                mar[i][j] = "~";
            }
        }
    }
    public static void moverSubmarino(String[][] mar, int filaSub, int columnaSub){
        Random random = new Random();
        int movimientsFiles = random.nextInt(2) + 1;
        int movimientsColumnes = random.nextInt(2) + 1;
        int novaFila = Math.max(0, Math.min(mar.length - 1, filaSub - movimientsFiles));
        int novaColumna = Math.max(0, Math.min(mar[0].length - 1, columnaSub - movimientsColumnes));
        iniciarMar();
        if (novaFila>0){
            mar[novaFila - 1][novaColumna] = "+";
        }
        if (novaFila<mar.length) {
            mar[novaFila + 1][novaColumna] = "+";
        }
        if (novaColumna>0) {
            mar[novaFila][novaColumna - 1] = "+";
        }
        if (novaColumna<mar.length) {
            mar[novaFila][novaColumna + 1] = "+";
        }
        if (novaFila<mar.length && novaColumna<mar.length) {
            mar[novaFila + 1][novaColumna + 1] = "+";
        }
        if (novaFila>0 && novaColumna>0) {
            mar[novaFila - 1][novaColumna - 1] = "+";
        }
        if (novaColumna>0) {
            mar[novaFila + 1][novaColumna - 1] = "+";
        }
        if (novaFila>0) {
            mar[novaFila - 1][novaColumna + 1] = "+";
        }
        mar[novaFila][novaColumna] = "X";
    }
    public static void imprimirTablero(String[][] mar, int dim){
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(mar[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void mostrarAyuda(){
        System.out.println("En el proyecto Submarino se trata de pequeño programa para la locaización de un\n" +
                "submarino utilizando un radar guiado por el usuario.El usuario dispondrá de un número finito de\n" +
                "intentos para encontrar la posición exacta del submarino.\n" +
                "La zona de búsqueda será un mar ficticio finito. En la tabla adjunta muestra un posible mar\n" +
                "y posición del submarino. Las casillas marcadas en color gris muestran las posiciones alrededor del\n" +
                "submario. La posición del submarino viene determinado por las coordenadas x de fila y y de columna\n" +
                "de la casilla.");
    }
}
