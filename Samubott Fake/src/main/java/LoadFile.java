import dev.langchain4j.data.document.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LoadFile {
    public static Document loadDocument(String filePath) throws IOException {
        Path path = Path.of(filePath);
        List<String> lines = Files.readAllLines(path);
        String documentContent = String.join("\n", lines);
        return new Document(documentContent);
    }
}