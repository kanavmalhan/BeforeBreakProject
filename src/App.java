import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game = new Game(input);
        game.init();
        while (true) {
            game.update();
        }
    }
}
