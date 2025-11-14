public class TriviaGame implements Game {

    public int calculateScore(Object data) {
        // Ejemplo: data podría ser número de respuestas correctas
        int correctAnswers = (int) data;
        return correctAnswers * 10;
    }
}
