package crasp;
import java.util.Random;
import java.util.Scanner;

public class Crasp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego Crasp!");

        while (true) {
            System.out.println("Presiona 'Enter' para lanzar los dados...");
            scanner.nextLine();

            int dado1 = tirarDado();
            int dado2 = tirarDado();
            int sum = dado1 + dado2;

            System.out.println("Resultado del lanzamiento: " + sum);

            if (sum == 7 || sum == 11) {
                System.out.println("¡Ganaste!");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Crasp, la casa gana. ¡Perdiste!");
            } else {
                int puntos = sum;
                System.out.println("Tu punto es: " + puntos);

                while (true) {
                    System.out.println("Presiona 'Enter' para lanzar los dados nuevamente...");
                    scanner.nextLine();

                    dado1 = tirarDado();
                    dado2 = tirarDado();
                    int nuevaSum = dado1 + dado2;

                    System.out.println("Resultado del lanzamiento: " + nuevaSum);

                    if (nuevaSum == puntos) {
                        System.out.println("¡Ganaste al alcanzar tu punto!");
                        break;
                    } else if (nuevaSum == 7) {
                        System.out.println("Sacaste un 7 antes de alcanzar tu punto. ¡Perdiste!");
                        break;
                    }
                }
            }

            System.out.println("¿Quieres jugar otra vez? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                System.out.println("Gracias por jugar. ¡Hasta luego!");
                break;
            }
        }

        scanner.close();
    }

    private static int tirarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}