import dev.langchain4j.chain.ConversationalRetrievalChain;
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.ToolInvocationException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import et.telebof.BotClient;
import java.io.IOException;

public class SamubottFake {
    static final String TOKEN = "6594489096:AAHCxQAmsLNqKHe1oap6rZwltceoiiDaNds";

    public static void main(String[] args) throws ToolInvocationException, IOException, InterruptedException {
        final BotClient bot = new BotClient(TOKEN);
        final String GEMMA_API = "http://127.0.0.1:11434";
        final String MODEL_ID = "gemma2";

        // Carrega o conteúdo do arquivo .txt como string
        String documentContent = LoadFile.loadDocumentContent("src/files/text.txt");

        // Configurando a API Gemma2
        OllamaAPI ollamaAPI = new OllamaAPI(GEMMA_API);

        // Comando /start
        bot.onMessage(filter -> filter.commands("start"), (context, message) -> {
            context.reply("Olá, sou o Samubott! Como posso te ajudar hoje?").exec();
        });

        // Detecção da mensagem
        bot.onMessage(filter -> filter.text(), (context, message) -> {
            ollamaAPI.setRequestTimeoutSeconds(200);
            try {
                String userInput = documentContent + "\n\nPergunta do usuário: " + message.text;
                OllamaResult userResponse = ollamaAPI.generate(MODEL_ID, userInput, true, new OptionsBuilder().build());
                context.reply(userResponse.getResponse()).exec();
            } catch (Exception e) {
                System.out.println("Erro ao processar a mensagem: " + e.getMessage());
                context.reply("Erro ao processar a mensagem.").exec();
            }
        });

        // Executa o bot
        bot.run();
    }
}
