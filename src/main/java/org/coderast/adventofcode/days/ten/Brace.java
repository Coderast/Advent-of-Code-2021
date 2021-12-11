package org.coderast.adventofcode.days.ten;

public class Brace {
    private final BraceType braceType;
    private final BraceDirection braceDirection;

    private Brace(BraceType braceType, BraceDirection braceDirection) {
        this.braceType = braceType;
        this.braceDirection = braceDirection;
    }

    public BraceType getBraceType() {
        return braceType;
    }

    public BraceDirection getBraceDirection() {
        return braceDirection;
    }

    public static Brace fromChar(final char ch) {
        return switch (ch) {
            case '(' -> new Brace(BraceType.Parentheses, BraceDirection.Open);
            case ')' -> new Brace(BraceType.Parentheses, BraceDirection.Close);
            case '{' -> new Brace(BraceType.Braces, BraceDirection.Open);
            case '}' -> new Brace(BraceType.Braces, BraceDirection.Close);
            case '<' -> new Brace(BraceType.Brackets, BraceDirection.Open);
            case '>' -> new Brace(BraceType.Brackets, BraceDirection.Close);
            case '[' -> new Brace(BraceType.Square, BraceDirection.Open);
            case ']' -> new Brace(BraceType.Square, BraceDirection.Close);
            default -> throw new RuntimeException("Illegal character: " + ch);
        };
    }
    public enum BraceType {
        Parentheses, // ()
        Braces, // {}
        Brackets, // <>
        Square // []
    }

    public enum BraceDirection {
        Open, Close
    }
}
