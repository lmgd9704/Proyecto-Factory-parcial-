public class ReactionGame implements Game {

    public int calculateScore(Object data) {
        // data es milisegundos de reacción
        int reactionTime = (int) data;

        return Math.max(0, 500 - reactionTime);
    }
}
