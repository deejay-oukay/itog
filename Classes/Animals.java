package Classes;

import java.util.ArrayList;

public class Animals {
    private String name;
    private ArrayList<String> commands = new ArrayList<String>();
    private String birthday;

    public Animals(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return getClass().getName() + ": [Имя=" + name + ", Команды=" + commands.toString() + ", Дата рождения="
                + birthday + "]\n";
    }

}