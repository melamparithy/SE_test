ic class TennisGame1 implements TennisGame {

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
        if (isPlayer1(playerName)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    private boolean isPlayer1(String playerName) {
        return playerName.equals(player1Name);
    }

    @Override
    public String getScore() {
        if (isEqualScore()) {
            return getEqualScore();
        } else if (isGameFinished()) {
            return getWinningScore();
        } else {
            return getRegularScore();
        }
    }

    private boolean isEqualScore() {
        return player1Score == player2Score;
    }

    private boolean isGameFinished() {
        return player1Score >= MAX_SCORE || player2Score >= MAX_SCORE;
    }

    private String getEqualScore() {
        if (player1Score < 3) {
            return SCORE_NAMES[player1Score] + "-All";
        } else {
            return "Deuce";
        }
    }

    private String getWinningScore() {
        int scoreDifference = player1Score - player2Score;
        String leadingPlayer, winningPlayer;
        if (Math.abs(scoreDifference) == 1) {
            leadingPlayer = (scoreDifference == 1) ? player1Name : player2Name;
            return "Advantage " + leadingPlayer;
        } else {
            winningPlayer = (scoreDifference >= 2) ? player1Name : player2Name;
            return "Win for " + winningPlayer;
        }
    }

    private String getRegularScore() {
        return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
    }
}