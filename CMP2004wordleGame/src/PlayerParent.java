public class PlayerParent {
	
    private String playerName;
    private String playerGuess;

    public PlayerParent(String name){
        playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(String playerGuess) {
        this.playerGuess = playerGuess;
    }
}
