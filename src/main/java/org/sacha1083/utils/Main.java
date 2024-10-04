package org.sacha1083.utils;

import org.sacha1083.bot.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        loadEnvVariables();
        String botUsername = System.getProperty("BOT_USERNAME");
        String botToken = System.getProperty("BOT_TOKEN");

        try {
            System.out.println("⚙️ Iniciando bot... ⚙️");
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot(botUsername, botToken));
            System.out.println("✅\uD83D\uDEDC El bot ha establecido conexión correctamente \uD83D\uDEDC✅.");
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al iniciar el bot: " + e.getMessage() + " ❗");
        }
    }

    private static void loadEnvVariables() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(".env")) {
            if (input == null) {
                System.out.println("❗ Error: No se encontró el archivo .env ❗");
                return;
            }

            List<String> lines = new BufferedReader(new InputStreamReader(input)).lines().toList();
            for (String line : lines) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    System.setProperty(parts[0], parts[1]);
                }
            }
            System.out.println("✅ Variables de entorno cargadas correctamente ✅");
        } catch (IOException e) {
            System.out.println("❗ Error al leer el archivo .env: " + e.getMessage() + " ❗");
        }
    }
}