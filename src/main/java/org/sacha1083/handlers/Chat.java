package org.sacha1083.handlers;

import org.sacha1083.bot.TelegramBot;
import org.sacha1083.shapes.*;
import org.sacha1083.utils.Log;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.sacha1083.utils.UserState;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private final List<String> figuras = List.of("cuadrado", "rectángulo", "triángulo", "rombo", "pentágono", "hexágono", "círculo", "trapecio", "paralelogramo");
    private final TelegramBot bot;
    private final UserState userState;

    public Chat(TelegramBot bot, UserState userState) {
        this.bot = bot;
        this.userState = userState;
    }

    // Handle user input
    public void handleUpdate(Update update) {
        String text = update.getMessage().getText().toLowerCase();
        switch (text) {
            case "/start" -> sendWelcomeMessage(update);
            case "/operaciones" -> {
                sendFigureOptions(update);
                userState.setExpectedResponse("figure");
            }
            case "/info" -> sendInfo(update);
            case "/help" -> sendHelp(update);
            case "/salir" -> sendExitMessage(update);
            default -> handleUserResponse(update, text);
        }
    }

    private void handleUserResponse(Update update, String text) {
        if ("figure".equals(userState.getExpectedResponse())) {
            if (figuras.contains(text)) {
                userState.setCurrentFigure(text);
                userState.setExpectedResponse("dimension");
                askForDimensions(update, text);
            } else {
                sendMessage(update, "⚠️ Figura no reconocida. Por favor, elige una figura válida. ⚠️");
            }
        } else if ("dimension".equals(userState.getExpectedResponse())) {
            calculateFigure(update, userState.getCurrentFigure(), text);
            userState.setExpectedResponse("");
        } else {
            sendMessage(update, "⚠️ Lo siento, no entiendo lo que me pides. ¿Podrías repetirlo? ⚠️");
        }
    }

    private void askForDimensions(Update update, String figure) {
        String prompt = switch (figure) {
            case "cuadrado" -> "Introduce el lado del cuadrado:";
            case "rectángulo" -> "Introduce la base y la altura del rectángulo (separados por un espacio):";
            case "triángulo" -> "Introduce la base y la altura del triángulo (separados por un espacio):";
            case "rombo" -> "Introduce la diagonal mayor y la diagonal menor del rombo (separados por un espacio):";
            case "pentágono" -> "Introduce el lado y la apotema del pentágono (separados por un espacio):";
            case "hexágono" -> "Introduce el lado del hexágono:";
            case "círculo" -> "Introduce el radio del círculo:";
            case "trapecio" -> "Introduce la base mayor, la base menor y la altura del trapecio (separados por un espacio):";
            case "paralelogramo" -> "Introduce la base y la altura del paralelogramo (separados por un espacio):";
            default -> "⚠️ Figura no reconocida. ⚠️";
        };
        sendMessage(update, prompt);
    }

    private void calculateFigure(Update update, String figure, String dimensions) {
        String[] dims = dimensions.split(" ");
        double area = 0;
        double perimetro = 0;

        try {
            switch (figure) {
                case "cuadrado" -> {
                    double lado = Double.parseDouble(dims[0]);
                    Square square = new Square(lado);
                    area = square.area();
                    perimetro = square.perimetro();
                }
                case "rectángulo" -> {
                    double base = Double.parseDouble(dims[0]);
                    double altura = Double.parseDouble(dims[1]);
                    Rectangle rectangle = new Rectangle(base, altura);
                    area = rectangle.area();
                    perimetro = rectangle.perimetro();
                }
                case "triángulo" -> {
                    double base = Double.parseDouble(dims[0]);
                    double altura = Double.parseDouble(dims[1]);
                    Triangle triangle = new Triangle(base, altura);
                    area = triangle.area();
                    perimetro = triangle.perimetro();
                }
                case "rombo" -> {
                    double diagonalMayor = Double.parseDouble(dims[0]);
                    double diagonalMenor = Double.parseDouble(dims[1]);
                    Rhombus rhombus = new Rhombus(diagonalMayor, diagonalMenor);
                    area = rhombus.area();
                    perimetro = rhombus.perimetro();
                }
                case "pentágono" -> {
                    double lado = Double.parseDouble(dims[0]);
                    double apotema = Double.parseDouble(dims[1]);
                    Pentagon pentagon = new Pentagon(lado, apotema);
                    area = pentagon.area();
                    perimetro = pentagon.perimetro();
                }
                case "hexágono" -> {
                    double lado = Double.parseDouble(dims[0]);
                    Hexagon hexagon = new Hexagon(lado);
                    area = hexagon.area();
                    perimetro = hexagon.perimetro();
                }
                case "círculo" -> {
                    double radio = Double.parseDouble(dims[0]);
                    Circle circle = new Circle(radio);
                    area = circle.area();
                    perimetro = circle.perimetro();
                }
                case "trapecio" -> {
                    double baseMayor = Double.parseDouble(dims[0]);
                    double baseMenor = Double.parseDouble(dims[1]);
                    double altura = Double.parseDouble(dims[2]);
                    Trapezoid trapezoid = new Trapezoid(baseMenor, baseMayor, altura);
                    area = trapezoid.area();
                    perimetro = trapezoid.perimetro();
                }
                case "paralelogramo" -> {
                    double base = Double.parseDouble(dims[0]);
                    double altura = Double.parseDouble(dims[1]);
                    Parallelogram parallelogram = new Parallelogram(base, altura);
                    area = parallelogram.area();
                    perimetro = parallelogram.perimetro();
                }
                default -> sendMessage(update, "⚠️ Figura no reconocida.");
            }
            sendMessage(update, "✅ Área: " + area + ", Perímetro: " + perimetro);
            sendWelcomeMessage(update); // Return to main menu
        } catch (NumberFormatException e) {
            sendMessage(update, "⚠️ Error en el formato de las dimensiones. Por favor, inténtalo de nuevo.");
        }
    }

    private void sendMessage(Update update, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(text);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            Log.error("Error al enviar el mensaje: " + e.getMessage());
        }
    }

    private void sendWelcomeMessage(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("\uD83D\uDC4B Hola, soy el Virtuoso de las Matemáticas. ¿Qué te gustaría que hiciera? ❔");
        message.setReplyMarkup(createMainKeyboard());
        try {
            bot.execute(message);
            Log.info("Mensaje de bienvenida enviado");
        } catch (TelegramApiException e) {
            Log.error("Error al enviar el mensaje de bienvenida: " + e.getMessage());
        }
    }

    private void sendFigureOptions(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("\uD83E\uDD1D Puedo ayudarte a calcular el área o el perímetro de las siguientes figuras: " +
                "cuadrado, rectángulo, triángulo, rombo, pentágono, hexágono, círculo, trapecio y paralelogramo. \uD83E\uDD1D");
        message.setReplyMarkup(createFigureKeyboard());
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            Log.error("Error al enviar las opciones de figuras: " + e.getMessage());
        }
    }

    private void sendInfo(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("Puedes encontrar toda esa información en el siguiente enlace:\nhttps://www.youtube.com/watch?v=wYNvY_bOGdc");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            Log.error("Error al enviar la información: " + e.getMessage());
        }
    }

    private void sendHelp(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("Puedes pedirme ayuda en cualquier momento. ¿En qué puedo ayudarte?");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            Log.error("Error al enviar la ayuda: " + e.getMessage());
        }
    }

    // Send exit message and reset user state
    private void sendExitMessage(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("👋 ¡Hasta luego! 👋 Para reiniciar el chat, escribe /start.");
        message.setReplyMarkup(onlyStartButton());
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            Log.error("Error al enviar el mensaje de salida: " + e.getMessage());
        }

        // Reset user state
        userState.setExpectedResponse("");
        userState.setCurrentFigure("");
    }

    // Keyboard with the main options
    private ReplyKeyboardMarkup createMainKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        row1.add(new KeyboardButton("/operaciones"));
        row1.add(new KeyboardButton("/info"));
        row2.add(new KeyboardButton("/help"));
        row2.add(new KeyboardButton("/salir"));
        keyboard.add(row1);
        keyboard.add(row2);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }

    // Keyboard with the available figures
    private ReplyKeyboardMarkup createFigureKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Cuadrado"));
        row1.add(new KeyboardButton("Rectángulo"));
        row1.add(new KeyboardButton("Triángulo"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Rombo"));
        row2.add(new KeyboardButton("Pentágono"));
        row2.add(new KeyboardButton("Hexágono"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Círculo"));
        row3.add(new KeyboardButton("Trapecio"));
        row3.add(new KeyboardButton("Paralelogramo"));

        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboardMarkup.setKeyboard(keyboard);

        return keyboardMarkup;
    }

    // Keyboard with only the /start button
    private ReplyKeyboardMarkup onlyStartButton() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton("/start"));
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }
}