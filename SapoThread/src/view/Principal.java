package view;

import controller.SapoThread;

public class Principal {

    public static void main(String[] args) {
        int distanciaCorrida = 20; // Distância total que os sapos devem percorrer (em metros)
        int maxPulo = 5; // Tamanho máximo de cada pulo (em metros)

        // Criando e iniciando 5 threads, uma para cada sapo
        for (int i = 1; i <= 5; i++) {
            SapoThread sapo = new SapoThread(i, distanciaCorrida, maxPulo);
            sapo.start();
        }
    }
}