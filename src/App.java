public class App {
    public static void main(String[] args) throws Exception {
        Player neel = new Player();
        neel.addItem(new Key());
        System.out.println(neel.printInventory());
        
    }
}
