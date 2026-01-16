import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveManager {

    private static final String SAVE_FILE = "save.txt";

    public static void save(Player player) {
        try {
            try (FileWriter writer = new FileWriter(SAVE_FILE)) {
                writer.write(player.getName() + "\n");
                writer.write(player.getStamina() + "\n");
                writer.write(player.getReadiness() + "\n");
                writer.write(player.getX() + "\n");
                writer.write(player.getY() + "\n");
            }
            System.out.println("Game saved.");
        } catch (IOException e) {
            System.out.println("Failed to save game.");
        }
    }

    public static Player load() {
        try {
            File file = new File(SAVE_FILE);
            Scanner reader = new Scanner(file);

            String name = reader.nextLine();
            int stamina = Integer.parseInt(reader.nextLine());
            int readiness = Integer.parseInt(reader.nextLine());
            int x = Integer.parseInt(reader.nextLine());
            int y = Integer.parseInt(reader.nextLine());
            boolean hasCleats = Boolean.parseBoolean(reader.nextLine());

            reader.close();
            System.out.println("Game loaded.");
            return new Player(name, stamina, x, y, readiness, hasCleats);

        } catch (Exception e) {
            System.out.println("No save file found.");
            return null;
        }
    }

    public static boolean saveExists() {
        File file = new File(SAVE_FILE);
        return file.exists();
    }
}
