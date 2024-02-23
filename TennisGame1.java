```java
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score) {
            score = getEqualScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getWinningScore();
        } else {
            score = getRegularScore();
        }
        return score;
    }

    private String getEqualScore() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getWinningScore() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return "Advantage " + player1Name;
        } else if (scoreDifference == -1) {
            return "Advantage " + player2Name;
        } else if (scoreDifference >= 2) {
            return "Win for " + player1Name;
        } else {
            return "Win for " + player2Name;
        }
    }

    private String getRegularScore() {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreNames[player1Score] + "-" + scoreNames[player2Score];
    }
}
```