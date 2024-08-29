import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
      
        // Clase Scanner para obtener las entradas del usuario.
        Scanner sc = new Scanner(System.in);

        // Declaraciones de variables y asignaciones.
        String[] palabrasSecretas = {"extraterrestre", "computadora", "programacion", "ahorcado", "java"};
        
        // Usamos la clase Random para seleccionar una palabra al azar del array.
        Random rand = new Random();
        String palabraSecreta = palabrasSecretas[rand.nextInt(palabrasSecretas.length)];
        
        int cantidadIntentos = 10;  // Número total de intentos permitidos.
        int intentos = 0;  // Contador de intentos realizados.
        boolean palabraAdivinada = false;  // Bandera para indicar si la palabra ha sido adivinada.

        // Arreglo para almacenar las letras encontradas.
        char[] letrasEncontradas = new char[palabraSecreta.length()];

        // Bucle para inicializar el arreglo de letras encontradas con guiones bajos.
        for (int i = 0; i < letrasEncontradas.length; i++) {
            letrasEncontradas[i] = '_';  // Inicialmente, todas las posiciones son guiones bajos.
        }

        // Bucle principal del juego. Se repite mientras la palabra no haya sido adivinada y queden intentos.
        while (!palabraAdivinada && intentos < cantidadIntentos) {
            // Mostrar la palabra con las letras adivinadas y las letras restantes como guiones bajos.
            System.out.println("Palabra a adivinar : " + String.valueOf(letrasEncontradas) + " ( " + palabraSecreta.length() + " letras" + " )");
            System.out.println("Introduce una letra");
            
            // Leer una letra del usuario y convertirla a minúscula.
            char letra = Character.toLowerCase(sc.next().charAt(0));
            boolean letraCorrecta = false;  // Bandera para indicar si la letra ingresada es correcta.

            // Bucle para verificar si la letra ingresada está en la palabra secreta.
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasEncontradas[i] = letra;  // Actualizar el arreglo de letras encontradas.
                    letraCorrecta = true;  // Cambiar la bandera a verdadero si se encontró la letra.
                }
            }

            // Si la letra no se encuentra en la palabra secreta, aumentar el contador de intentos.
            if(!letraCorrecta){
                intentos++;
                System.out.println("Letra incorrecta te quedan " + (cantidadIntentos - intentos) + " intentos.");
            }

            // Verificar si todas las letras han sido adivinadas.
            if(String.valueOf(letrasEncontradas).equals(palabraSecreta)){
                palabraAdivinada = true;  // Cambiar la bandera a verdadero si la palabra ha sido adivinada.
                System.out.println("Ha encontrado la palabra : " + palabraSecreta);
            }
        }

        // Mensaje de finalización si se acaban los intentos y no se adivinó la palabra.
        if(!palabraAdivinada){
            System.out.println("Te has quedado sin intentos.");
        }

        sc.close();  // Cerrar el Scanner para liberar recursos.
    }
}
