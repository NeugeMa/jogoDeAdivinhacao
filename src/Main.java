/*
Crie um programa que simula um jogo de adivinhação, que deve gerar um número aleatório entre 0 e 100 e pedir para que o usuário tente adivinhar o
número, em até 5 tentativas.

A cada tentativa, o programa deve informar se o número digitado pelo usuário é maior ou menor do que o número gerado.
*/

import java.util.Random; // Usado para gerar um número aleatório
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = random.nextInt(101);
        int tentativas = 5;

        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Tente adivinhar o número entre 0 e 100. Você tem " + tentativas + " tentativas.");

        for (int tentativa = 1; tentativa <= tentativas; tentativa++) {
            System.out.print("Tentativa " + tentativa + "/" + tentativas + ": Digite seu palpite: ");

            try {
                int palpite = Integer.parseInt(scanner.nextLine());

                if (palpite < 0 || palpite > 100) {
                    System.out.println("Por favor, digite um número entre 0 e 100.");
                    continue;
                }

                if (palpite == numeroSecreto) {
                    System.out.println("Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativa + " tentativas!");
                    scanner.close();
                    return;
                } else if (palpite < numeroSecreto) {
                    System.out.println("O número é maior!");
                } else {
                    System.out.println("O número é menor!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        }

        System.out.println("Fim de jogo! O número secreto era " + numeroSecreto + ".");
        scanner.close();
    }
}
