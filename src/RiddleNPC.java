import java.util.Scanner;

//Class for all of the NPCs which show a riddle
public class RiddleNPC extends NonPlayerCharacter {
    private String riddle;
    private String answer;
    private Item reward;
    private boolean solved;

    public RiddleNPC(String name, String riddle, String answer, Item reward) {
        super(name);
        this.riddle = riddle;
        this.answer = answer.toLowerCase();
        this.reward = reward;
        this.solved = false;
    }

    public void interact(Player player) {
//Checks if player has already solved the riddles. If he has, then it doesn't show it again
        if (solved) {
            System.out.println(name + " smiles. \"I've already helped you.\"");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + name + " speaks quietly:");
        System.out.println(riddle);
        System.out.print("> ");
        String input = sc.nextLine().toLowerCase();

        if (input.contains(answer)) {
            System.out.println("Correct.");
            reward.use(player);
            solved = true;
        } else {
            System.out.println("Wrong. Think harder.");
        }
    }
}
