package org.sacha1083.bot;

import org.sacha1083.handlers.Chat;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.sacha1083.utils.UserState;

import java.util.HashMap;
import java.util.Map;

public class TelegramBot extends TelegramLongPollingBot {
    private final String botUsername;
    private final String botToken;
    private final Map<Long, UserState> userStates = new HashMap<>();

    public TelegramBot(String botUsername, String botToken) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        System.out.println("ℹ️ Bot creado con nombre de usuario: " + botUsername + " ℹ️");
        onWait();
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        UserState userState = userStates.getOrDefault(chatId, new UserState());
        Chat chat = new Chat(this, userState);
        chat.handleUpdate(update);
        userStates.put(chatId, userState);
        System.out.println("✅ Mensaje procesado ✅");
        onWait();
    }

    public void onWait() {
        System.out.println("\uD83D\uDD0D A la espera de mensajes... \uD83D\uDD0D");
    }
}