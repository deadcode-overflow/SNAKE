public class Player {
    public Player() {
        this.score = 0;
        this.level = 1;
    }

    public int getScore() {
        return this.score;
    }

    public int getLevel() {
        return level;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLevel() {
        this.level = 1 + (Window.player.getScore() / 5);
    }

    private int score;
    private int level;
}
