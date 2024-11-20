import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.ToolInvocationException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import et.telebof.BotClient;
import java.io.IOException;

public class OrdoBot {
    static final String TOKEN = "7271337289:AAHPdqcfv4QR9uxL7R1EhpmQpon8fej2pOs";

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
            context.reply("Olá, sou o OrdoBot, seu assistente pessoal para suas sessões de Ordem Paranormal RPG! O que vamos fazer hoje? (Dê /help para ver todos os comandos)").exec();
        });

        //Comando /help
        bot.onMessage(filter -> filter.commands("help"), (context, message) -> {
            String ajuda = "Comandos disponíveis:\n" +
                    "- /start: Carrega as informações das criaturas e introduz o bot.\n" +
                    "- /rolar [d4, d6, d8, d10, d12, d20]: Rola o dado especificado.\n" +
                    "- /aleatorio: Exibe uma criatura aleatória.\n" +
                    "- Para informações sobre as criaturas, apenas pergunte! :)";
            context.reply(ajuda).exec();
        });


        //Comando /rolar
        bot.onMessage(filter -> filter.commands("rolar"), (context, message) -> {
            String dado = message.text.replace("/rolar ", "").toLowerCase();
            int resultado = 0;
            switch (dado) {
                case "d4":
                    resultado = (int) (Math.random() * 4) + 1;
                    break;
                case "d6":
                    resultado = (int) (Math.random() * 6) + 1;
                    break;
                case "d8":
                    resultado = (int) (Math.random() * 8) + 1;
                    break;
                case "d10":
                    resultado = (int) (Math.random() * 10) + 1;
                    break;
                case "d12":
                    resultado = (int) (Math.random() * 12) + 1;
                    break;
                case "d20":
                    resultado = (int) (Math.random() * 20) + 1;
                    break;
                default:
                    context.reply("Comando inválido. Use /rolar [d4, d6, d8, d10, d12, d20]").exec();
                    return;
            }
            context.reply("O resultado da rolagem do " + dado + ": " + resultado).exec();
        });

        //Comando /aleatorio
        bot.onMessage(filter -> filter.commands("aleatorio"), (context, message) -> {
            ollamaAPI.setRequestTimeoutSeconds(300);
            try {
                String userInput = documentContent + "\n\nDê o nome e atributos de uma das criaturas, apenas isso.";
                OllamaResult userResponse = ollamaAPI.generate(MODEL_ID, userInput, true, new OptionsBuilder().build());
                context.reply(userResponse.getResponse()).exec();
            } catch (Exception e) {
                System.out.println("Erro ao processar a mensagem: " + e.getMessage());
                context.reply("Erro ao processar a mensagem.").exec();
            }
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
