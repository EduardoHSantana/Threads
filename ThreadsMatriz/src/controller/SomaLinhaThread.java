package controller;

public class SomaLinhaThread extends Thread {
    private int[] linha;
    private int idLinha;

    public SomaLinhaThread(int[] linha, int idLinha) {
        this.linha = linha;
        this.idLinha = idLinha;
    }

    @Override
    public void run() {
        int soma = 0;
        for (int valor : linha) {
            soma += valor;
        }
        System.out.println("Soma da linha " + idLinha + ": " + soma);
    }
}