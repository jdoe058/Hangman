package model;

public enum Hangman {
    ROPE("|",new Cell(0,0)),
    HEAD("o",new Cell(1,0)),
    TORSO("|",new Cell(2,0)),
    LEFT_HAND("/",new Cell(2,-1)),
    RIGHT_HAND("\\",new Cell(2,1)),
    LEFT_FOOT("/",new Cell(3,-1)),
    RIGHT_FOOT("\\",new Cell(3, 1)),
    LEFT_SOLE("_",new Cell(3,-2)),
    RIGHT_SOLE("_",new Cell(3,2));

    final String sprite;
    final Cell cell;

    Hangman(String sprite, Cell cell) {
        this.sprite = sprite;
        this.cell = cell;
    }

    final public static int HALF_WIDTH = 3;
    final public static int HEIGHT = 4;
    final public static String EMPTY = " ";
}
