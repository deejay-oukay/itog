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
        System.out.print("Введите имя животного: ");
        this.name = Main.in.nextLine();
    }

    public String getCommands() {
        return commands.toString();
    }

    public void addCommand() {
        System.out.print("Введите новую команду: ");
        String command = Main.in.nextLine();
        if (commands.contains(command))
            Main.errorCodes(6, command);
        else {
            commands.add(command);
            Main.errorCodes(0);

        }
    }

    public void setBirthday() {
        System.out.print("Введите дату рождения (можно примерную): ");
        // возможность ввести что угодно вместо даты - это не баг, а фитча :-)
        this.birthday = Main.in.nextLine();
    }

    @Override
    public String toString() {
        return getClass().getName() + ": [ID = " + id + ", Имя = " + name + ", Дата рождения = " + birthday + "]";
    }

    public Integer getId() {
        return id;
    }

}