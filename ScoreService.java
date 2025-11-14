import java.util.HashMap;
import java.util.Map;

public class ScoreService {

    private GameFactory factory;
    private Map<String, Integer> ranking;

    public ScoreService(GameFactory factory) {
        this.factory = factory;
        this.ranking = new HashMap<>();
    }

    public void submitScore(User user, String gameType, Object data) {
        Game game = factory.createGame(gameType);
        int score = game.calculateScore(data);

        ranking.put(user.getUserId(), score);
        System.out.println("Puntaje registrado: " + user.getUsername() + " → " + score);
    }

    public int calculateUserScore(String gameType, Object data) {
        Game game = factory.createGame(gameType);
        return game.calculateScore(data);
    }

    public int getUserRanking(User user) {
        return ranking.getOrDefault(user.getUserId(), 0);
    }
}
