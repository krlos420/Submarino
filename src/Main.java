public class Main {
    public static void main(String[] args) {
        boolean menu;
        while (menu=true) {
            System.out.println("Menú Principal");
            System.out.println("1. Jugar Partida");
            System.out.println("2. Ajuda");
            System.out.println("0. Salir");
            int opcio = Leer.leerEntero("Opció (1, 2, 0): ");
            if (opcio == 1) {
                int intentos;
                intentos = Leer.leerEntero("Cuantos intentos quieres?");
                String[][] mar = metodos.jugar();
                int[] submarino = metodos.iniciarSubmarino(mar);
                while (intentos > 0) {
                    if (!metodos.posicionCalibrar(mar)) {
                        intentos = intentos - 1;
                        metodos.moverSubmarino(mar, submarino[0], submarino[1]);
                    } else {
                        metodos.imprimirTablero(mar, mar.length);
                        menu = false;
                        break;
                    }
                }
                if (intentos == 0) {
                    System.out.println("Has perdut");
                    menu = true;
                }


            } else if (opcio == 2) {
                metodos.mostrarAyuda();
            } else if (opcio == 0) {
                menu = false;
                break;
            }
        }



    }
}