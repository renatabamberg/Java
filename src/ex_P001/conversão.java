
package ex_P001;

import java.util.Scanner;

public class conversão {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a temperatura:");
        double temperatura = scanner.nextDouble();

        System.out.println("Digite a unidade de origem (C ou F):");
        String unidade = scanner.next();

        double resultado;
        if (unidade.equalsIgnoreCase("C")) {
            resultado = (temperatura * 9/5) + 32;
            System.out.println("A temperatura em Fahrenheit é: " + resultado+ "ºF");
        } else if (unidade.equalsIgnoreCase("F")) {
            resultado = (temperatura - 32) * 5/9;
            System.out.println("A temperatura em Celsius é: " + resultado+"ºC");
        } else {
            System.out.println("Unidade inválida.");
        }
    }
}
