package view;

import controller.ThreadLinux;

public class Principal {

    public static void main(String[] args) {
        // Verifica se o sistema operacional é Linux
        String so = System.getProperty("os.name").toLowerCase();
        if (!so.contains("linux")) {
            System.out.println("Aplicação suporta apenas o Sistema Operacional Linux.");
            return;
        }

        // Criação das threads para ping nos servidores
        ThreadLinux uolThread = new ThreadLinux("www.uol.com.br", "UOL");
        ThreadLinux terraThread = new ThreadLinux("www.terra.com.br", "Terra");
        ThreadLinux googleThread = new ThreadLinux("www.google.com.br", "Google");

        // Inicia as threads
        uolThread.start();
        terraThread.start();
        googleThread.start();

        // Aguarda o término de todas as threads
        try {
            uolThread.join();
            terraThread.join();
            googleThread.join();
        } catch (InterruptedException e) {
            // Em caso de interrupção, não faz nada
        }
    }
}