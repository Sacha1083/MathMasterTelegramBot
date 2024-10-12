package org.sacha1083.utils;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static final String LOG_FILE = Paths.get(System.getProperty("user.dir"),"log", "app.log").toString();
    private static final String LOG_MESSAGE = Paths.get(System.getProperty("user.dir"),"log", "messages.log").toString();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss - dd/MM/yyyy");

    // Log levels: INFO, SUCCESS, WARN, ERROR, CONFIG
    public static void log(String level, String message) {
        String logEntry = String.format("[%s] [%s] %s", dtf.format(LocalDateTime.now()), level, message);

        // Print to console
        System.out.println(logEntry);

        // Write to log file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void info(String message) {
        log("INFO", "ℹ️ " + message + " ℹ️");
    }

    public static void success(String message) {
        log("SUCCESS", "🎉 " + message + " 🎉");
    }

    public static void warn(String message) {
        log("WARN", "⚠️ " + message + " ⚠️");
    }

    public static void error(String message) {
        log("ERROR", "❗ " + message + " ❗");
    }

    public static void config(String message) {
        log("CONFIG", "⚙️ " + message + " ⚙️");
    }

    // Save user messages to a separate log file
    public static void saveUserMessage(Update update) {
        String message = update.getMessage().getText();
        String username = update.getMessage().getFrom().getUserName();
        String userId = update.getMessage().getFrom().getId().toString();
        log("USER", "👤 " + username + " (" + userId + ") sent: " + message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_MESSAGE, true))) {
            writer.write("👤 " + username + " (" + userId + ") sent: " + message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static String getLogFile() {
        return LOG_FILE;
    }

    public static String getLogMessage() {
        return LOG_MESSAGE;
    }
}