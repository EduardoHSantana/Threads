package controller;

public class ThreadVetor extends Thread {
    private int num;
    private int[] vet;

    public ThreadVetor(int num, int[] vet) {
        this.num = num;
        this.vet = vet;
    }

    @Override
    public void run() {
        long tempoInicial = System.nanoTime(); // Marca o tempo inicial

        if (num % 2 == 0) { // Caso o número seja par
            for (int i = 0; i < vet.length; i++) {
                // Apenas percorre o vetor
                int valor = vet[i];
            }
        } else { // Caso o número seja ímpar
            for (int valor : vet) {
                // Apenas percorre o vetor
            }
        }

        long tempoFinal = System.nanoTime(); // Marca o tempo final
        double tempoSegundos = (tempoFinal - tempoInicial) / 1_000_000_000.0; // Converte para segundos

        System.out.println("Tempo Thread " + num + ": " + tempoSegundos + " s");
    }
}