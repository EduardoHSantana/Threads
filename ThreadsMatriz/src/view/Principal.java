package view;

import controller.SomaLinhaThread;

public class Principal {

    public static void main(String[] args) {
        int[][] matriz = new int[3][5];

        // Gerando números aleatórios para a matriz 3x5 usando Math.random()
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = (int) (Math.random() * 100); // Números aleatórios de 0 a 99
            }
        }

        // Criando e iniciando uma thread para cada linha da matriz
        for (int i = 0; i < 3; i++) {
            SomaLinhaThread thread = new SomaLinhaThread(matriz[i], i + 1);
            thread.start();
        }
    }
}