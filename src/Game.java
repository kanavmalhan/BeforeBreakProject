import java.util.Scanner;


public class Game {
    private Location[][] board;
    private TimeOfDay time;
    private Scanner input;

    public Game(Scanner input){
        this.input = input;
        this.board = new Location[10][10];
        this.time = TimeOfDay.MORNING;
    }

    public void init(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.board[i][j] = new Location(i, j, "Empty Block");
            }
        }

        System.out.println("Welcome to Matchday: The Final Trial");
        System.out.println("What is your name?");
        String name = this.input.nextLine();
        System.out.println("Hello, " + name);
        Player player = new Player(name, 100, 5, 5, 0);
        System.out.println("By tonight, the coach will decide who makes the team \nYou have one day to prepare");
        System.out.println("Train wisely. Manage your stamina");
        System.out.println("What you do today will decide your future");
        System.out.println("You arrive at Training Square \nIt is " + this.time + "\nYou have: " + player.getStamina() + " stamina" + "\nYou have: " + player.getReadiness() + " readiness");
        System.out.println("You have to achieve 100 readiness to be approved for your trial. \nYou also have to have ample stamina so that you can perform well at the trial. \nGood luck");
    }
}
