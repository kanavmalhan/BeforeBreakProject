public class Coach extends NonPlayerCharacter{
    public Coach(String name, String role){
        super(name, role);
    };
    @Override
    public void talk(Player player, boolean isFirstConversation){
        if(evaluate(player) == true){
            System.out.println("You have succeeded. Good luck with your tryout!");
        }
        else{
               System.out.println("Coach Miller studies you for a moment. \n" + //
                        " \n" + //
                        "“Today's evaluation isn't just about talent.\n" + //
                        "It's about preparation. \n" + //
                        " \n" + //
                        "He glances at your gear, then at his clipboard. \n" + //
                        " \n" + //
                        "“You'll need three things before I even let you step on the field tonight. \n" + //
                        " \n" + //
                        "“First proper cleats. \n" + //
                        "No cleats, no tryout. Simple as that. \n" + //
                        " \n" + //
                        "“Second clearance from the admin office. \n" + //
                        "They won't let anyone play without it. \n" + //
                        " \n" + //
                        "“And third you need enough stamina. \n" + //
                        "If you're exhausted before kickoff, you're done. \n" + //
                        " \n" + //
                        "He looks back up at you. \n" + //
                        " \n" + //
                        "“Start with the cleats store. \n" + //
                        "Get equipped, then handle the rest. \n" + //
                        " \n" + //
                        "I'll be right here. \n" + //
                        "Come back when you 're ready.");
        }
     
    };
    @Override
    public boolean evaluate(Player player){
        return false;
    };

}
