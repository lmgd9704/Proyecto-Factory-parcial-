import java.util.Scanner;

public class MainSystem {

    private ScoreService scoreService;

    public MainSystem() {
        GameFactory factory = new ConcreteGameFactory();
        scoreService = new ScoreService(factory);
    }

    // Métodos para formato ANSI
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    public static final String ANSI_REVERSED = "\u001B[7m";

    // Métodos para colores ANSI
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";

    public void initialize() {
        System.out.println(ANSI_BOLD + ANSI_BLUE + "╔══════════════════════════════════════════╗" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_BLUE + "║" + ANSI_RESET + ANSI_YELLOW + "   Sistema de Clasificación en Tiempo Real   " + ANSI_BOLD + ANSI_BLUE + "║" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_BLUE + "╚══════════════════════════════════════════╝" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Sistema inicializado correctamente.\n" + ANSI_RESET);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ANSI_BLUE + ANSI_BOLD + "Ingrese el ID del usuario:" + ANSI_RESET);
        String userId = scanner.nextLine();

        System.out.println(ANSI_BLUE + ANSI_BOLD + "Ingrese el nombre del usuario:" + ANSI_RESET);
        String username = scanner.nextLine();

        User user = new User(userId, username);

        System.out.println("\n" + ANSI_BLUE + ANSI_BOLD + "Seleccione el tipo de juego:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + ANSI_BOLD + "1. Trivia" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + ANSI_BOLD + "2. Racing" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + ANSI_BOLD + "3. Reaction" + ANSI_RESET);
        System.out.print(ANSI_BLUE + ANSI_BOLD + "Opción: " + ANSI_RESET);
        int option = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        String gameType = "";
        switch(option) {
            case 1: gameType = "trivia"; break;
            case 2: gameType = "racing"; break;
            case 3: gameType = "reaction"; break;
            default:
                System.out.println(ANSI_RED + ANSI_BOLD + "Opción inválida. Terminando programa." + ANSI_RESET);
                return;
        }

        System.out.println("\n" + ANSI_BLUE + ANSI_BOLD + "Ingrese los datos necesarios para el puntaje:" + ANSI_RESET);

        Object data = null;

        if (gameType.equals("trivia")) {
            System.out.println(ANSI_BLUE + ANSI_BOLD + "Número de respuestas correctas:" + ANSI_RESET);
            data = scanner.nextInt();
        }
        else if (gameType.equals("racing")) {
            System.out.println(ANSI_BLUE + ANSI_BOLD + "Tiempo total en segundos:" + ANSI_RESET);
            data = scanner.nextInt();
        }
        else if (gameType.equals("reaction")) {
            System.out.println(ANSI_BLUE + ANSI_BOLD + "Tiempo de reacción en milisegundos:" + ANSI_RESET);
            data = scanner.nextInt();
        }

        // Guardar puntaje
        scoreService.submitScore(user, gameType, data);

        // Mostrar ranking del usuario
        int ranking = scoreService.getUserRanking(user);
        System.out.println("\n" + ANSI_GREEN + ANSI_BOLD + "El puntaje actual del usuario es: " + ranking + ANSI_RESET);

        System.out.println(ANSI_BOLD + ANSI_BLUE + "╔══════════════════════════════════════════╗" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_BLUE + "║" + ANSI_RESET + ANSI_YELLOW + "             Fin del programa             " + ANSI_BOLD + ANSI_BLUE + "║" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_BLUE + "╚══════════════════════════════════════════╝" + ANSI_RESET);
    }

    public static void main(String[] args) {
        MainSystem system = new MainSystem();
        system.initialize();
        system.run();
    }
}
