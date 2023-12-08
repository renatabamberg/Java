package ex3;

import java.util.Scanner;
import java.util.Random;

public class ManipulaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criar array a partir da entrada do usuário:");
        int[] arrayUsuario = criarArrayUsuario(scanner);

        System.out.println("\nCriar array aleatório:");
        int[] arrayAleatorio = criarArrayAleatorio();

        System.out.println("\nArray do usuário:");
        imprimirArray(arrayUsuario);
        System.out.println("\nArray aleatório:");
        imprimirArray(arrayAleatorio);

        System.out.println("\nSoma dos elementos do array do usuário: " + calcularSoma(arrayUsuario));
        System.out.println("Soma dos elementos do array aleatório: " + calcularSoma(arrayAleatorio));

        System.out.println("\nMaior valor do array do usuário: " + encontrarMaiorValor(arrayUsuario));
        System.out.println("Maior valor do array aleatório: " + encontrarMaiorValor(arrayAleatorio));

        System.out.println("\nMenor valor do array do usuário: " + encontrarMenorValor(arrayUsuario));
        System.out.println("Menor valor do array aleatório: " + encontrarMenorValor(arrayAleatorio));

        scanner.close();
    }

    public static int[] criarArrayUsuario(Scanner scanner) {
        System.out.print("Quantos números deseja inserir? ");
        int tamanho = scanner.nextInt();

        int[] array = new int[tamanho];

        System.out.println("Digite os números um por um:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static int[] criarArrayAleatorio() {
        Random random = new Random();

        int tamanho = 5 + random.nextInt(10); 
        int[] array = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(100); 
        }

        return array;
    }

    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int calcularSoma(int[] array) {
        int soma = 0;
        for (int num : array) {
            soma += num;
        }
        return soma;
    }

    public static int encontrarMaiorValor(int[] array) {
        int maior = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maior) {
                maior = array[i];
            }
        }
        return maior;
    }

    public static int encontrarMenorValor(int[] array) {
        int menor = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < menor) {
                menor = array[i];
            }
        }
        return menor;
    }
}
