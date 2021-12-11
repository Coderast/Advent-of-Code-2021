package org.coderast.adventofcode.days.two;

public class Command {
    private final CommandType type;
    private final int amount;

    public Command(CommandType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public CommandType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    enum CommandType {
        Forward, Up, Down
    }
}
