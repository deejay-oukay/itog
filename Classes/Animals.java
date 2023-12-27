package Classes;

import java.util.ArrayList;

public class Animals {
    private Integer id;
    private String name;
    private ArrayList<String> commands = new ArrayList<String>();
    private String birthday;

    public Animals() {
        id = Counter.add();
        setName();
        setBirthday();
        Main.errorCodes(0);
        System.out.println("Можете добавить ещё одно животное...");
    }

    public void setName() {
        String name = "";
        do {
            System.out.print("Введите имя животного: ");
            name = Main.in.nextLine();
        } while (name.equals(""));
        this.name = name;
    }

    public String getCommands() {
        return commands.toString();
    }

    public void addCommand() {
        String command = "";
        do {
            System.out.print("Введите новую команду: ");
            command = Main.in.nextLine();
        } while (command.equals(""));
        if (commands.contains(command))
            Main.errorCodes(6, command);
        else {
            commands.add(command);
            Main.errorCodes(0);
        }
    }

    public void setBirthday() {
        String birthday = "";
        do {
            System.out.print("Введите дату рождения (можно примерную): ");
            birthday = Main.in.nextLine();
        } while (birthday.equals(""));
        // возможность ввести что угодно вместо даты - это не баг, а фитча :-)
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": [ID = " + id + ", Имя = " + name + ", Дата рождения = " + birthday + "]";
    }

    public Integer getId() {
        return id;
    }

}