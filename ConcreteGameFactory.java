public class ConcreteGameFactory extends GameFactory {

    public Game createGame(String type) {
        switch(type.toLowerCase()) {
            case "trivia": 
                return new TriviaGame();
            case "racing": 
                return new RacingGame();
            case "reaction": 
                return new ReactionGame();
            default:
                throw new IllegalArgumentException("Tipo de juego no reconocido: " + type);
        }
    }
}
