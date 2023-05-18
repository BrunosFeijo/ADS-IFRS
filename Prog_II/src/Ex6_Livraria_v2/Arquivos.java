package Ex6_Livraria_v2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Arquivos {
    Path caminho;

    public Arquivos(String caminho) {
        this.caminho = Path.of(caminho);
    }

    public void adicionarArquivo(String texto) {
        try {
            if (Files.notExists(caminho)) {
                Files.createFile(caminho);
            }
            Files.writeString(caminho, texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
