import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.ToolInvocationException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import et.telebof.BotClient;
import java.io.IOException;

public class OrdoBot {
    static final String TOKEN = "6594489096:AAHCxQAmsLNqKHe1oap6rZwltceoiiDaNds";

    public static void main(String[] args) throws IOException{
        final BotClient bot = new BotClient(TOKEN);
        final String GEMMA_API = "http://127.0.0.1:11434";
        final String MODEL_ID = "gemma2:2b";

        // Carrega o conteúdo do arquivo .txt como string
        String documentContent = LoadFile.loadDocumentContent("src/files/text.txt");

        // Configurando a API Gemma2
        OllamaAPI ollamaAPI = new OllamaAPI(GEMMA_API);

        // Comando /start
        bot.onMessage(filter -> filter.commands("start"), (context, message) -> {
            context.reply("Olá, sou o OrdoBot! Como posso te ajudar hoje?").exec();
        });

        //Comando /d4
        bot.onMessage(filter -> filter.commands("d4"), (context, message) -> {
            String resultd4 = RollDices.rollD4();
            context.reply(resultd4).exec();
        });

        //Comando /d6
        bot.onMessage(filter -> filter.commands("d6"), (context, message) -> {
            String resultd6 = RollDices.rollD6();
            context.reply(resultd6).exec();
        });

        //Comando /d8
        bot.onMessage(filter -> filter.commands("d8"), (context, message) -> {
            String resultd8 = RollDices.rollD8();
            context.reply(resultd8).exec();
        });

        //Comando /d10
        bot.onMessage(filter -> filter.commands("d10"), (context, message) -> {
            String resultd10 = RollDices.rollD10();
            context.reply(resultd10).exec();
        });

        //Comando /d12
        bot.onMessage(filter -> filter.commands("d12"), (context, message) -> {
            String resultd12 = RollDices.rollD12();
            context.reply(resultd12).exec();
        });

        //Comando /d20
        bot.onMessage(filter -> filter.commands("d20"), (context, message) -> {
            String resultd20 = RollDices.rollD20();
            context.reply(resultd20).exec();
        });

        // Deteccao da mensagem
        bot.onMessage(filter -> filter.text(), (context, message) -> {
            ollamaAPI.setRequestTimeoutSeconds(300);
            try {
                String userInput = documentContent + "\n\nPergunta: " + message.text;
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
