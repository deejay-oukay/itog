package Classes;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        clearScreen();
        mainMenu();
    }

    public static void errorCodes(int code, String moreInfo) {
        String[] codes = {
                /* 0 */ "Успешно",
                /* 1 */ "Введена некорретная команда: %s",
                /* 2 */ "Указан некорректный класс животного: %s",
                /* 3 */ "Указан некорректный ID животного: %s",
                /* 4 */ "Список животных пока пуст",
                /* 5 */ "Список команд пока пуст",
                /* 6 */ "Это животное ранее уже было обучено команде %s"
        };
        clearScreen();
        System.out.printf("!!!" + codes[code] + "!!!\n", moreInfo);
    }

    public static void errorCodes(int code) {
        errorCodes(code, "");
    }

    private static void mainMenu() {
        boolean need2stop = false;
        while (!need2stop) {
            System.out.println("add  - Завести новое животное");
            System.out.println("list - Увидеть список команд, которое выполняет животное");
            System.out.println("new  - Обучить животное новым командам");
            System.out.println("exit - Выйти");
            System.out.print("Введите одну из перечисленных команд: ");
            String command = in.nextLine();
            if (command.equals("add")) {
                Registry.addAnimal();
            } else if (command.equals("list")) {
                Registry.listCommands();
            } else if (command.equals("new")) {
                Registry.newCommand();
            } else if (command.equals("exit")) {
                need2stop = true;
            } else
                errorCodes(1, command);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}