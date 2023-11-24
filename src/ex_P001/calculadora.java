
package ex_P001;

import java.util.Scanner;

	public class calculadora {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Digite o primeiro número:");
	        double num1 = scanner.nextDouble();
	        System.out.println("Digite o segundo número:");
	        double num2 = scanner.nextDouble();
	        System.out.println("Escolha a operação (+ , - , * , / ):");
	        String operacao = scanner.next();

	        double resultado;
	        switch (operacao) {
	            case "+":
	                resultado = num1 + num2;
	                break;
	            case "-":
	                resultado = num1 - num2;
	                break;
	            case "*":
	                resultado = num1 * num2;
	                break;
	            case "/":
	                resultado = num1 / num2;
	                break;
	            default:
	                System.out.println("Operação inválida.");
	                return;
	        }
	        System.out.println("O resultado é: " + resultado);
	    }
	}
