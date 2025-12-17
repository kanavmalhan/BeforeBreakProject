
public class Game {
    private Location[][] board;
    private TimeOfDay time;

    public void init(){
        //Initializes the entire board to be empty locations so that I can go in and create specific locations later in the function
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Location(i, j, "Nothing");
            }
        }
    }

}
