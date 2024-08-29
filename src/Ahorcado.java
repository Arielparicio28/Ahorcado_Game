import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
      
        //Clase Scanner para obtener las entradas del usuario.
        Scanner sc = new Scanner(System.in);

        //Declaraciones de variables y asignaciones.
        String palabraSecreta = "extraterrestre";
        int cantidadIntentos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;
        //Arreglos(Array)
        char[] letrasEncontradas = new char[palabraSecreta.length()];

        //Estructura de control de tipo iterativa (Bucle)
        for (int i = 0; i < letrasEncontradas.length; i++) {
            letrasEncontradas[i] = '_';
        }

        //Estructura de control 

        while (!palabraAdivinada && intentos < cantidadIntentos) {
            System.out.println("Palabra a adivinar : " + String.valueOf(letrasEncontradas) + " ( " + palabraSecreta.length() + " letras" + " )" );
            System.out.println("Introduce una letra");
            
            char letra = Character.toLowerCase(sc.next().charAt(0));
            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasEncontradas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("Letra incorrecta te quedan " + (cantidadIntentos - intentos) + " intentos.");
            }

            if(String.valueOf(letrasEncontradas).equals(palabraSecreta)){
               palabraAdivinada = true;
               System.out.println("Ha encontrado la palabra : " + palabraSecreta);
            }
        }

        if(!palabraAdivinada){
            System.out.println("Te has quedado sin intentos.");
        }

        sc.close();
    }
}
