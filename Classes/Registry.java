package Classes;

import java.util.ArrayList;

public class Registry {
    // список животных в реестре
    private static ArrayList<Animals> list = new ArrayList<>();

    // добавление животного в реестр
    public static void addAnimal() {
        Main.clearScreen();
        boolean need2stop = false;
        while (!need2stop) {
            System.out.println("dog     - Завести собаку");
            System.out.println("cat     - Завести кошку");
            System.out.println("hamster - Завести хомяка");
            System.out.println("horse   - Завести лошадь");
            System.out.println("camel   - Завести верблюда");
            System.out.println("donkey  - Завести осла");
            System.out.println("cancel  - Отменить добавление");
            System.out.print("Введите тип добавляемого животного: ");
            String command = Main.in.nextLine();
            if (command.equals("dog")) {
                list.add(new Dogs());
            } else if (command.equals("cat")) {
                list.add(new Cats());
            } else if (command.equals("hamster")) {
                list.add(new Hamsters());
            } else if (command.equals("horse")) {
                list.add(new Horses());
            } else if (command.equals("camel")) {
                list.add(new Camels());
            } else if (command.equals("donkey")) {
                list.add(new Donkeys());
            } else if (command.equals("cancel")) {
                need2stop = true;
            } else
                Main.errorCodes(2, command);
        }
        Main.errorCodes(0);
    }

    // просмотр списка команд для животного
    public static void listCommands() {
        if (list.isEmpty()) {
            Main.errorCodes(4);
            return;
        }
        Main.clearScreen();
        boolean need2stop = false;
        while (!need2stop) {
            Main.clearScreen();
            listAnimals();
            System.out.println("cancel - Отменить просмотр");
            System.out.print("Введите ID животного, список команд которого хотите увидеть: ");
            String command = Main.in.nextLine();
            if (command.equals("cancel")) {
                need2stop = true;
            } else {
                try {
                    Animals animal = getAnimalById(Integer.parseInt(command));
                    if (!animal.equals(null)) {
                        String commands = animal.getCommands();
                        if (commands.equals("[]"))
                            Main.errorCodes(5);
                        else
                            System.out.println(commands);
                        System.out.println("Нажмите Enter, чтобы продолжить...");
                        Main.in.nextLine();
                    }
                } catch (NumberFormatException e) {
                    Main.errorCodes(3, command);
                } catch (NullPointerException e) {
                    Main.errorCodes(3, command);
                }

            }
        }
    }

    private static void listAnimals() {
        for (Animals animal : list) {
            System.out.println(animal.toString());
        }
    }

    private static Animals getAnimalById(Integer id) {
        for (Animals animal : list) {
            if (animal.getId().equals(id))
                return animal;
        }
        Main.errorCodes(3, Integer.toString(id));
        return null;
    }

    public static void newCommand() {
        if (list.isEmpty()) {
            Main.errorCodes(4);
            return;
        }
        Main.clearScreen();
        boolean need2stop = false;
        while (!need2stop) {
            listAnimals();
            System.out.println("cancel - Отменить добавление");
            System.out.print("Введите ID животного, для которого хотите добавить новую команду: ");
            String command = Main.in.nextLine();
            if (command.equals("cancel")) {
                need2stop = true;
            } else {
                try {
                    Animals animal = getAnimalById(Integer.parseInt(command));
                    if (!animal.equals(null)) {
                        Main.clearScreen();
                        animal.addCommand();
                    }
                } catch (NumberFormatException e) {
                    Main.errorCodes(3, command);
                } catch (NullPointerException e) {
                    Main.errorCodes(3, command);
                }
            }
        }
        Main.errorCodes(0);
    }

}
