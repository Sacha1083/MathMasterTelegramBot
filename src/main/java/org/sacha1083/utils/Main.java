package org.sacha1083.utils;

import org.sacha1083.bot.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        renameLastLog();
        loadEnvVariables();
        String botUsername = System.getProperty("BOT_USERNAME");
        String botToken = System.getProperty("BOT_TOKEN");

        if (botUsername == null || botToken == null) {
            Log.error("BOT_USERNAME and BOT_TOKEN environment variables are required");
        } else {
            Log.success("BOT_USERNAME and BOT_TOKEN environment variables loaded");
            try {
            Log.config("Iniciando bot...");
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot(botUsername, botToken));
            Log.success("Bot iniciado correctamente");
            } catch (TelegramApiException e) {
            Log.error("Error al iniciar el bot: " + e.getMessage());
            }
        }
    }

    private static void loadEnvVariables() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(".env")) {
            if (input == null) {
                Log.warn("Archivo .env no encontrado");
                return;
            }

            List<String> lines = new BufferedReader(new InputStreamReader(input)).lines().toList();
            for (String line : lines) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    System.setProperty(parts[0], parts[1]);
                }
            }
            Log.success("Variables de entorno cargadas correctamente");
        } catch (IOException e) {
            Log.error("Error al cargar las variables de entorno: " + e.getMessage());
        }
    }

    public static void renameLastLog() {
        // Create log directory if it doesn't exist in the User.dir
        String logDir = Paths.get(System.getProperty("user.dir"), "log").toString();
        if (!new File(logDir).exists()) {
            if (new File(logDir).mkdir()) {
                Log.success("Log directory created");
            } else {
                Log.error("Error creating log directory");
            }
        }

        // Rename last log file and latest message log file
        String logPath = Log.getLogFile();
        String logPathMessage = Log.getLogMessage();

        // Rename log file to include timestamp
        String newLogPath = logPath.replace(".log", "-" + System.currentTimeMillis() + ".log");
        String newLogPathMessage = logPathMessage.replace(".log", "-" + System.currentTimeMillis() + ".log");

        // If log file exists, rename it
        if (new File (logPath).exists()) {
            // Rename log file
            if (new File(logPath).renameTo(new File(newLogPath))) {
                Log.success("Log file renamed to " + newLogPath);
            } else {
                Log.error("Error renaming log file");
            }
        }

        // If message log file exists, rename it
        if (new File (logPathMessage).exists()) {
            // Rename message log file
            if (new File(logPathMessage).renameTo(new File(newLogPathMessage))) {
                Log.success("Message log file renamed to " + newLogPathMessage);
            } else {
                Log.error("Error renaming message log file");
            }
        }

        // Create new log file
        if (!new File(logPath).exists()) {
            try {
                if (new File(logPath).createNewFile()) {
                    Log.success("New log file created");
                } else {
                    Log.error("Error creating new log file");
                }
            } catch (IOException e) {
                Log.error("Error creating new log file: " + e.getMessage());
            }
        }

        // Create new message log file
        if (!new File(logPathMessage).exists()) {
            try {
                if (new File(logPathMessage).createNewFile()) {
                    Log.success("New message log file created");
                } else {
                    Log.error("Error creating new message log file");
                }
            } catch (IOException e) {
                Log.error("Error creating new message log file: " + e.getMessage());
            }
        }
    }
}