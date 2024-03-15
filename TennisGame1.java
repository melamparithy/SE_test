
public class TennisGame1 implements TennisGame {

    private static final int MAX_SCORE = 4;
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    @Override
    public String getScore() {
        if (player1Score == player2Score) {
            if (player1Score < 3) {
                return SCORE_NAMES[player1Score] + "-All";
            } else {
                return "Deuce";
            }
        } else if (player1Score >= MAX_SCORE || player2Score >= MAX_SCORE) {
            int scoreDifference = player1Score - player2Score;
            String leadingPlayer = (scoreDifference == 1) ? player1Name : player2Name;
            String winningPlayer = (scoreDifference >= 2) ? player1Name : player2Name;
            if (Math.abs(scoreDifference) == 1) {
                return "Advantage " + leadingPlayer;
            } else {
                return "Win for " + winningPlayer;
            }
        } else {
            return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
        }
    }
}
