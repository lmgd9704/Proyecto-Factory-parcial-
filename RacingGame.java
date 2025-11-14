public class RacingGame implements Game {

    public int calculateScore(Object data) {
        // data puede ser un tiempo en segundos
        int time = (int) data;

        // Cuanto menor el tiempo, mayor el puntaje
        return Math.max(0, 1000 - time);
    }
}
