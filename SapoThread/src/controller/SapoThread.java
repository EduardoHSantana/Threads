package controller;

import java.util.Random;

public class SapoThread extends Thread {
    private int idSapo;
    private int distanciaTotal;
    private int maxPulo;
    private static int colocacao = 0; // Contador estático para definir a ordem de chegada

    public SapoThread(int idSapo, int distanciaTotal, int maxPulo) {
        this.idSapo = idSapo;
        this.distanciaTotal = distanciaTotal;
        this.maxPulo = maxPulo;
    }

    @Override
    public void run() {
        Random random = new Random();
        int distanciaPercorrida = 0;

        // Enquanto o sapo não percorrer toda a distância
        while (distanciaPercorrida < distanciaTotal) {
            int pulo = random.nextInt(maxPulo + 1); // Gera um pulo aleatório entre 0 e o máximo permitido
            distanciaPercorrida += pulo;

            // Verifica se o sapo ultrapassou a distância total e ajusta, se necessário
            if (distanciaPercorrida > distanciaTotal) {
                distanciaPercorrida = distanciaTotal;
            }

            // Mostra o salto e a distância percorrida
            System.out.println("Sapo " + idSapo + " deu um pulo de " + pulo + " metros. Total percorrido: " + distanciaPercorrida + "/" + distanciaTotal + " metros.");
        }

        // Incrementa a colocação dos sapos
        colocacao++;
        System.out.println("Sapo " + idSapo + " chegou em " + colocacao + "º lugar!");
    }
}