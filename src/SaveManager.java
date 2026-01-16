import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
//Class which helps the user save his work
public class SaveManager {
//This is the name of the file it will be saved with
//Can add different slots so that a player can maybe even save multiple times
    private static final String SAVE_FILE = "save.txt";
//Save function. Saves name, stamina, readiness, x, y, and whether the player has cleats or not
    public static void save(Player player) {
        try {
            try (FileWriter writer = new FileWriter(SAVE_FILE)) {
                writer.write(player.getName() + "\n");
                writer.write(player.getStamina() + "\n");
                writer.write(player.getReadiness() + "\n");
                writer.write(player.getX() + "\n");
                writer.write(player.getY() + "\n");
                writer.write(player.hasCleats() + "\n");
            }
            System.out.println("Game saved.");
        } catch (IOException e) {
            System.out.println("Failed to save game.");
        }
    }
//Loads file. Uses try and catch to account for errors. Scans for the things written above and returns a player instance with the things in the file
    public static Player load() {
        File file = new File(SAVE_FILE);
        System.out.println(file.getAbsolutePath());
        try (Scanner reader = new Scanner(file)){
            String name = reader.nextLine();
            int stamina = Integer.parseInt(reader.nextLine());
            int readiness = Integer.parseInt(reader.nextLine());
            int x = Integer.parseInt(reader.nextLine());
            int y = Integer.parseInt(reader.nextLine());
            boolean hasCleats = Boolean.parseBoolean(reader.nextLine());

            reader.close();
            System.out.println("Game loaded.");
            return new Player(name, stamina, x, y, readiness, hasCleats);

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
            return null;
        }
    }
//Checks whether the save file exists or not.
    public static boolean saveExists() {
        File file = new File(SAVE_FILE);
        return file.exists();
    }
}
