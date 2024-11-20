import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LoadFile {
    private static String cachedContent;

    public static String loadDocumentContent(String filePath) throws IOException {
        if (cachedContent == null) {
            Path path = Path.of(filePath);
            List<String> lines = Files.readAllLines(path);
            cachedContent = String.join("\n", lines);
        }
        return cachedContent;
    }
}
