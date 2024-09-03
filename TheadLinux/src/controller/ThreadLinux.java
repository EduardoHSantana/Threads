package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreadLinux extends Thread {
    private String servidor;
    private String nomeServidor;
    
    public ThreadLinux(String servidor, String nomeServidor) {
        this.servidor = servidor;
        this.nomeServidor = nomeServidor;
    }

    @Override
    public void run() {
        // Comando de ping para 10 iterações
        String comandoPing = "ping -4 -c 10 " + servidor;
        
        // Usando ProcessBuilder para executar o comando
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", comandoPing);
        try {
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linha;
            double somaTempo = 0;
            int contador = 0;

            // Lendo a saída do ping
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("time=")) {
                    contador++;
                    // Extrai o tempo da linha que contém "time="
                    String tempo = linha.split("time=")[1].split(" ")[0];
                    double tempoPing = Double.parseDouble(tempo);
                    somaTempo += tempoPing;
                    System.out.println(nomeServidor + " - Iteração " + contador + ": " + tempoPing + " ms");
                }
            }

            // Calcula o tempo médio e exibe no final
            if (contador > 0) {
                double tempoMedio = somaTempo / contador;
                System.out.println("\n" + nomeServidor + " - Tempo médio: " + tempoMedio + " ms\n");
            }
        } catch (Exception e) {
            // Em caso de erro, a aplicação simplesmente encerra
        }
    }
}