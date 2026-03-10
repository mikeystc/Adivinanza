//Michael Steven Taborda Ceron 
//Juego de adivinanza

import java.util.Scanner;

public class Juego {
    private int rangoInferior;
    private int rangoSuperior;
    private int numeroIntentos;
    private int numeroSecreto;
    private int intentosRealizados;

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el rango inferior: ");
        rangoInferior = scanner.nextInt();
        System.out.print("Ingrese el rango superior: ");
        rangoSuperior = scanner.nextInt();
        System.out.print("Ingrese el número de intentos: ");
        numeroIntentos = scanner.nextInt();

        numeroSecreto = (int) (Math.random() * (rangoSuperior - rangoInferior + 1)) + rangoInferior;
        intentosRealizados = 0;
    }

    public void solicitarNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adivina el número (entre " + rangoInferior + " y " + rangoSuperior + "): ");
        int numeroUsuario = scanner.nextInt();
        compararNumeros(numeroUsuario);
    }

    public void compararNumeros(int numeroUsuario) {
        intentosRealizados++;

        if (numeroUsuario == numeroSecreto) {
            System.out.println("¡Felicitaciones! Adivinaste el número en " + intentosRealizados + " intentos.");
        } else if (numeroUsuario < numeroSecreto) {
            System.out.println("El número es mayor.");
        } else {
            System.out.println("El número es menor.");
        }
    }

    public void jugar() {
        iniciarJuego();

        while (intentosRealizados < numeroIntentos) {
            solicitarNumero();
            if (intentosRealizados == numeroIntentos) {
                System.out.println("Lo siento, se te acabaron los intentos. El número era: " + numeroSecreto);
            }
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}