package org.sacha1083.utils;

import org.sacha1083.bot.TelegramBot;
import org.sacha1083.shapes.Square;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CalculateFigure {
    private static TelegramBot bot;

    public static boolean CalculateFigure(Update update, String figure, TelegramBot botR) {
        bot = botR;
        switch (figure) {
            case "cuadrado" -> {calculateSquare(update);}
            case "rectángulo" -> {calculateRectangle(update);}
            case "triángulo" -> {calculateTriangle(update);}
            case "rombo" -> {calculateRhombus(update);}
            case "pentágono" -> {calculatePentagon(update);}
            case "hexágono" -> {calculateHexagon(update);}
            case "círculo" -> {calculateCircle(update);}
            case "trapecio" -> {calculateTrapezoid(update);}
            case "paralelogramo" -> {calculateParallelogram(update);}
            default -> {System.out.println("❗ Figura no reconocida ❗"); return false;}
        }
        return true;
    }

    private static void calculateSquare(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido el lado del cuadrado
        message.setText("Introduce el lado del cuadrado:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de lado: " + e.getMessage() + " ❗");
        }

        // Espero a que el usuario introduzca el lado
        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        // Calculo el área y el perímetro del cuadrado
        double side = Double.parseDouble(update.getMessage().getText());
        Square square = new Square(side);
        double area = square.area();

        message.setText("El área del cuadrado es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del cuadrado: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área y perímetro de un cuadrado ℹ️");
    }

    private static void calculateRectangle(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido la base y la altura del rectángulo
        message.setText("Introduce la base del rectángulo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de base: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double base = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce la altura del rectángulo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de altura: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double height = Double.parseDouble(update.getMessage().getText());
        double area = base * height;

        message.setText("El área del rectángulo es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del rectángulo: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un rectángulo ℹ️");
    }

    private static void calculateTriangle(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido la base y la altura del triángulo
        message.setText("Introduce la base del triángulo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de base: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double base = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce la altura del triángulo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de altura: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double height = Double.parseDouble(update.getMessage().getText());
        double area = (base * height) / 2;

        message.setText("El área del triángulo es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del triángulo: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un triángulo ℹ️");
    }

    private static void calculateTrapezoid(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido las bases y la altura del trapecio
        message.setText("Introduce la base mayor del trapecio:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de base mayor: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double baseMayor = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce la base menor del trapecio:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de base menor: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double baseMenor = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce la altura del trapecio:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de altura: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double height = Double.parseDouble(update.getMessage().getText());
        double area = ((baseMayor + baseMenor) * height) / 2;

        message.setText("El área del trapecio es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del trapecio: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un trapecio ℹ️");
    }

    private static void calculateRhombus(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido la diagonal mayor y menor del rombo
        message.setText("Introduce la diagonal mayor del rombo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de diagonal mayor: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double diagonalMayor = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce la diagonal menor del rombo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de diagonal menor: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double diagonalMenor = Double.parseDouble(update.getMessage().getText());
        double area = (diagonalMayor * diagonalMenor) / 2;

        message.setText("El área del rombo es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del rombo: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un rombo ℹ️");
    }

    private static void calculatePentagon(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido el lado y el apotema del pentágono
        message.setText("Introduce el lado del pentágono:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de lado: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double side = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce el apotema del pentágono:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de apotema: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double apothem = Double.parseDouble(update.getMessage().getText());
        double area = (5 * side * apothem) / 2;

        message.setText("El área del pentágono es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del pentágono: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un pentágono ℹ️");
    }

    private static void calculateHexagon(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido el lado del hexágono
        message.setText("Introduce el lado del hexágono:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de lado: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double side = Double.parseDouble(update.getMessage().getText());
        double area = (3 * Math.sqrt(3) * Math.pow(side, 2)) / 2;

        message.setText("El área del hexágono es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del hexágono: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un hexágono ℹ️");
    }

    private static void calculateCircle(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido el radio del círculo
        message.setText("Introduce el radio del círculo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de radio: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double radius = Double.parseDouble(update.getMessage().getText());
        double area = Math.PI * Math.pow(radius, 2);

        message.setText("El área del círculo es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del círculo: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un círculo ℹ️");
    }

    private static void calculateParallelogram(Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        message.setReplyMarkup(null);

        // Pido la base y la altura del paralelogramo
        message.setText("Introduce la base del paralelogramo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de base: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double base = Double.parseDouble(update.getMessage().getText());

        message.setText("Introduce la altura del paralelogramo:");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje de petición de altura: " + e.getMessage() + " ❗");
        }

        while (update.getMessage().getText() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("❗ Error al esperar la respuesta del usuario: " + e.getMessage() + " ❗");
            }
        }

        double height = Double.parseDouble(update.getMessage().getText());
        double area = base * height;

        message.setText("El área del paralelogramo es " + area);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            System.out.println("❗ Error al enviar el mensaje del área del paralelogramo: " + e.getMessage() + " ❗");
        }
        System.out.println("ℹ️ Calculando área de un paralelogramo ℹ️");
    }
}