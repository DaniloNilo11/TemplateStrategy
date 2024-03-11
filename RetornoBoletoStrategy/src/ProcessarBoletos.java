import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(final LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }


    public final void processar(URI caminhoArquivo){
        System.out.println("Boletos");
        System.out.println("**********************************************************************************************");

        final var listaBoletos = new ArrayList<Boleto>();
        try {
            var listaLinhas = Files.readAllLines(Paths.get(caminhoArquivo));
            for (String linha : listaLinhas) {
                String[] vetor = linha.split(";");
                final var boleto = leituraRetorno.processarLinhaArquivo(vetor);
                listaBoletos.add(boleto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        for (var boleto : listaBoletos) {
            System.out.println(boleto);
        }
    }


    /**
     * Altera a estratégia a ser utilizada para leitura de arquivos de retorno de boletos bancários.
     * @param leituraRetorno nova estratégia a ser utilizada
     */
    public void setLeituraRetorno(final LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}