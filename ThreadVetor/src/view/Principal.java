package view;

import controller.ThreadVetor;

public class Principal {

    public static void main(String[] args) {
        int[] vetor = new int[1000];

        // Gerando números aleatórios para o vetor (valores de 1 a 100)
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100) + 1;
        }

        // Criando e iniciando as duas ThreadVetor
        ThreadVetor thread1 = new ThreadVetor(1, vetor); // Passa número 1 (ímpar)
        ThreadVetor thread2 = new ThreadVetor(2, vetor); // Passa número 2 (par)

        thread1.start();
        thread2.start();
    }
}