import java.util.Scanner;


public class Game {
    private Location[][] board;
    private TimeOfDay time;
    private Scanner input;
    private String name;
    private Player player;

    public Game(Scanner input){
        this.input = input;
        this.board = new Location[Constants.X_SIZE.getValue()][Constants.Y_SIZE.getValue()];
        this.time = TimeOfDay.MORNING;
        this.name = "Matchday: The Final Trial";
    }
//Initializes the board. Prints initial directions. 
    public void init(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                this.board[i][j] = new Location(i, j, "Empty Block");
            }
        } 

        initializeBoard();

        System.out.println("Welcome to " + this.name);
        System.out.println("What is your name?");
        String name = this.input.nextLine();
        System.out.println("Hello, " + name);
        this.player = new Player(name, 100, 5, 5, 0);
        System.out.println("By tonight, the coach will decide who makes the team \nYou have one day to prepare");
        System.out.println("Train wisely. Manage your stamina");
        System.out.println("What you do today will decide your future");
        System.out.println("You arrive at Training Square \nIt is " + this.time + "\nYou have: " + player.getStamina() + " stamina" + "\nYou have: " + player.getReadiness() + " readiness");
        System.out.println("You have to achieve 100 readiness to be approved for your trial. \nYou also have to have ample stamina so that you can perform well at the trial. \nGood luck");
    }

    public void update(){
        parseCommand(this.input.nextLine());
    }

    public void parseCommand(String command){
        switch(command){
            case "help":
                printCommands();
                break;
            case "exit":
                System.out.println("Thank you for playing " + this.name);
                System.exit(0);
                break;
            case "move north":
                this.player.move(0, 1);
                System.out.println(this.player.getXLocation());
                System.out.println(this.player.getYLocation());
                break;
            case "move south":
                this.player.move(0, -1);
                System.out.println(this.player.getXLocation());
                System.out.println(this.player.getYLocation());    
                break;
            case "move east":
                this.player.move(1, 0);
                System.out.println(this.player.getXLocation());
                System.out.println(this.player.getYLocation());    

                break;
            case "move west":
                this.player.move(-1, 0);
                System.out.println(this.player.getXLocation());
                System.out.println(this.player.getYLocation());    
                break;
            case "print board":
                System.out.println(printBoard());
                break;
            case "look":
                System.out.println(lookAround(this.player.getXLocation(), this.player.getYLocation()));
                break;
            case "inventory":
                System.out.println(this.player.printInventory());
        }
    }

    public void printCommands(){
        System.out.println("Type 'move [direction]' to move in a given direction \nType look to scan your surroundings \nType 'exit' to exit the game ");
    }

    public String printBoard(){
        String output = "";
        for(int i = 0; i < Constants.X_SIZE.getValue(); i++){
            for(int j = 0; j < Constants.Y_SIZE.getValue(); j++){
                output += this.board[i][j] + ", ";
            }
        }
        return output;
    }
//Looks for named locations within a certain radius of the player and gives the player directions to the given locations
    public String lookAround(int currentX, int currentY){
        String output = "";
        for(int i = 0; i < Constants.X_SIZE.getValue(); i++){
            for(int j = 0; j < Constants.Y_SIZE.getValue(); j++){
                if(this.board[i][j].getName() != "Empty Block"){
                    if(Math.abs(currentX-i) <= Constants.VISIBILITY.getValue()){
                        if(Math.abs(currentY-j) <= Constants.VISIBILITY.getValue()){
                            output += "\n"+this.board[i][j].getName() + " is " + (i-currentX) + " blocks away in the X direction, and " + (i-currentY) + " blocks away in the Y direction";
                        }
                    }

                }
            }
        }
        return output;
    }
//Puts locations in their spots
    public void initializeBoard(){
        this.board[6][6] = new Location(6, 6, "Cleats Shop");
    }
}
