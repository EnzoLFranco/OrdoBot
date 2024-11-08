import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentLoader;
import dev.langchain4j.data.document.FileSystemDocumentLoader;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadFile {
    public static Document loadDocument(String fileName) {
        Path filePath = toPath(fileName);
        return FileSystemDocumentLoader.loadDocument(filePath);
    }

    // Metodo auxiliar para converter o nome do arquivo em um Path
    private static Path toPath(String fileName) {
        try {
            URL fileUrl = DocumentLoader.class.getResource(fileName);
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
