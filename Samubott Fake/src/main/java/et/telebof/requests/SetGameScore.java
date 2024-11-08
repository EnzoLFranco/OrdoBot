package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Message;

public class SetGameScore extends AbstractBaseRequest<SetGameScore, Message> {
    public SetGameScore(long chatId, long userId, int score, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "setGameScore", Message.class);
        add("user_id", userId);
        add("message_id", messageId);
        add("score",score);
    }

    public SetGameScore(String inlineMessageId, long userId, int score, RequestSender requestSender) {
        super(requestSender, "setGameScore", Message.class);
        add("user_id", userId);
        add("inline_message_id", inlineMessageId);
        add("score",score);
    }

    public SetGameScore force(boolean force) {
        return add("force", force);
    }

    public SetGameScore disableEditMessage(boolean disableEditMessage) {
        return add("disable_edit_message", disableEditMessage);
    }

}
