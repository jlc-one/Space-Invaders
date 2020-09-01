package Logic;

public class Score {

    //to add - load score from file / save score to file


    private int p1Score;
    private int p2Score;
    private int hiScore;

    public Score() {
        p1Score = 0;
        p2Score = 0;
        // getHighScore(); =]
    }

    public String formattedString(int score) {
        StringBuilder sb = new StringBuilder();
        if (score < 10) {
            sb.append("0000");
        } else if (score < 100) {
            sb.append("00");
            sb.append(score);
        } else if (score < 1000) {
            sb.append("0");
            sb.append(score);
        } else {
            sb.append(score);
        }
        return sb.toString();
    }

    public void p1addToScore(int score) {
        this.p1Score += score;
    }

    public void p2addToScore(int score) {
        this.p2Score += score;
    }

    public int p1getScoreInt() {
        return p1Score;
    }

    public String p1GetScoreString() {
         return formattedString(p1Score);
    }

    public int p2getScoreInt() {
        return p2Score;
    }

    public String p2GetScoreString() {
        return "0000";
    }

    public int getHiScoreInt() {
        return hiScore;
    }

    public String getHighScoreString() {
        return formattedString(hiScore);
    }


}
