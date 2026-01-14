public class Coach extends NonPlayerCharacter{
    public Coach(String name, String role){
        super(name, role);
    };
    @Override
    public void talk(Player player){
        if(evaluate(player) == true){
            System.out.println("You have succeeded. Good luck with your tryout!");
        }
        else{
               System.out.println("Coach Miller studies you for a moment.\r\n" + //
                        "\r\n" + //
                        "“Today’s evaluation isn’t just about talent.\r\n" + //
                        "It’s about preparation.”\r\n" + //
                        "\r\n" + //
                        "He glances at your gear, then at his clipboard.\r\n" + //
                        "\r\n" + //
                        "“You’ll need three things before I even let you step on the field tonight.”\r\n" + //
                        "\r\n" + //
                        "“First — proper cleats.\r\n" + //
                        "No cleats, no tryout. Simple as that.”\r\n" + //
                        "\r\n" + //
                        "“Second — clearance from the admin office.\r\n" + //
                        "They won’t let anyone play without it.”\r\n" + //
                        "\r\n" + //
                        "“And third — you need enough stamina.\r\n" + //
                        "If you’re exhausted before kickoff, you’re done.”\r\n" + //
                        "\r\n" + //
                        "He looks back up at you.\r\n" + //
                        "\r\n" + //
                        "“Start with the cleats store.\r\n" + //
                        "Get equipped, then handle the rest.”\r\n" + //
                        "\r\n" + //
                        "“I’ll be right here.\r\n" + //
                        "Come back when you’re ready.”");
        }
     
    };
    @Override
    public boolean evaluate(Player player){
        return false;
    };

}
