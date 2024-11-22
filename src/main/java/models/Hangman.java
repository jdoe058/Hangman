package models;

public class Hangman {
    public static final int MAX_STAGE_OF_HANGING = 12;
    final public int maxStageOfHanging;
    private int currentStageOfHanging;

    public Hangman() {
        this(0, MAX_STAGE_OF_HANGING);
    }

    public Hangman(int minStageOfHanging, int maxStageOfHanging) {
        this.currentStageOfHanging = minStageOfHanging;
        this.maxStageOfHanging = maxStageOfHanging;
    }

    public int getCurrentStageOfHanging() {
        return currentStageOfHanging;
    }

    public void increaseHangingStage() {
        if(isAlive()) {
            currentStageOfHanging++;
        }
    }

    public boolean isAlive() {
        return currentStageOfHanging < maxStageOfHanging;
    }
}
