package ex1;

import java.util.Scanner;

public class ConversorMoeda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Conversor de Moeda!");
        System.out.print("Insira a quantidade em dólares: ");
        double quantidadeDolares = scanner.nextDouble();

        System.out.print("Insira a taxa de câmbio: ");
        double taxaCambio = scanner.nextDouble();

        double valorConvertido = quantidadeDolares * taxaCambio;

        System.out.println(quantidadeDolares + " dólares equivalem a " + valorConvertido + " na outra moeda.");
        
        scanner.close();
    }
}