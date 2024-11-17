# MathMasterTelegramBot

**MathMasterTelegramBot** is a Telegram bot that facilitates the calculation of areas and perimeters of various geometric figures. Users can select a figure and get automatic results or receive a step-by-step explanation on how to perform the calculations manually. Ideal for students, teachers, and geometry enthusiasts.

## Features

- **Automatic Calculation**: Quickly get the area and perimeter of geometric figures.
- **Step-by-Step Explanations**: Learn how to perform manual calculations with detailed guides.
- **User-Friendly Interface**: Easily interact with the bot through simple Telegram commands.

## Supported Figures

- Circle
- Square
- Rectangle
- Triangle
- More figures coming soon...

## Installation

Follow these steps to set up and run the bot in your local environment:

1. **Clone the repository**:

    ```sh
    git clone https://github.com/Sacha1083/MathMasterTelegramBot.git
    ```

2. **Navigate to the project directory**:

    ```sh
    cd MathMasterTelegramBot
    ```

3. **Add a `.env` file with the following properties**:

    ```plaintext
    BOT_USERNAME=your_bot_username
    BOT_TOKEN=your_bot_token
    ```

4. **Compile the project using Maven**:

    ```sh
    mvn clean package
    ```

5. **Run the bot**:

    - **Using the JAR file**:

        ```sh
        java -jar out/artifacts/MathMasterTelegramBot_jar/MathMasterTelegramBot.jar
        ```

    - **Using IntelliJ IDEA**:

        Open the project in IntelliJ IDEA and run the `Main` class.

## Usage

Once the bot is running, you can interact with it through Telegram:

- **/start** - Start the conversation with the bot.
- **/info** - Show video tutorials on how to calculate area and perimeter.
- **/operaciones** - Show a list of available operations.

## Contributions

**Contributions are welcome!** If you want to contribute, follow these steps:

1. Fork the project.
2. Create a new branch (`git checkout -b feature/new-feature`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push your changes to the repository (`git push origin feature/new-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.