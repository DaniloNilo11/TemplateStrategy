import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        final var processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());


        URI caminhoArquivo = Main.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("Lendo arquivo " + caminhoArquivo + "\n");

        processador.processar(caminhoArquivo);
    }
}