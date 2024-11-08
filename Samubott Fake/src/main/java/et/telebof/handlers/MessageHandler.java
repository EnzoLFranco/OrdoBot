package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.Message;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.exceptions.ToolInvocationException;

import java.io.IOException;

@FunctionalInterface
public interface MessageHandler {
    void handle(BotContext context, Message message) throws ToolInvocationException, OllamaBaseException, IOException, InterruptedException;
}
