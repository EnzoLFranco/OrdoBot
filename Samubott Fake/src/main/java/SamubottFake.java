//Imports
import dev.langchain4j.data.document.Document;
import dev.langchain4j.chain.ConversationalRetrievalChain;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.splitter.ParagraphSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.exceptions.ToolInvocationException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import et.telebof.BotClient;
import java.io.IOException;

import java.util.List;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;



//Inicio da classe
public class SamubottFake {
    static final String TOKEN = "";

    public static void main(String[] args) throws ToolInvocationException, OllamaBaseException, IOException, InterruptedException {
        final BotClient bot = new BotClient(TOKEN);
        final String GEMMA_API = "http://127.0.0.1:11434";
        final String MODEL_ID = "gemma2";
        EmbeddingStore<TextSegment> embeddingStore;
        EmbeddingModel embeddingModel;
        ConversationalRetrievalChain chain;

        Document document = loadDocument(toPath("text.txt"));

        // Configurando a API Gemma2
        OllamaAPI ollamaAPI = new OllamaAPI(GEMMA_API);
        


        // Comando /start
        bot.onMessage(filter -> filter.commands("start"), (context, message) -> {
            context.reply("Olá, sou o Samubott! Como posso te ajudar hoje?").exec();
        });

        // Detecção da mensagem
        bot.onMessage(filter -> filter.text(), (context, message) -> {
            //Solução para o timed out
            ollamaAPI.setRequestTimeoutSeconds(200);
                try {
                    // Resposta padrão para outros tipos de perguntas usando Gemma2
                    String userInput = message.text;
                    OllamaResult userResponse = ollamaAPI.generate("gemma2", userInput, true, new OptionsBuilder().build());
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