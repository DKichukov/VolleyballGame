package Game;

public class Play {

    public static void main(String[] args) {

        // To test player's methods, uncomment next 7 rows!
       /* System.out.println("..........................................");
        VolleyballPlayer p1 = new VolleyballPlayer("Ivan",22,"Blocker",4,3);
        System.out.println("Initial player parameters: " +p1 +"\n"+ "----------------");
        p1.train();
        p1.setHealth(6);
        System.out.println(p1 + "\n" + "----------------");
        p1.rest();
        System.out.println(p1 + "\n" + "..........................................");*/
        //=================================================================================================================

        Team team1 = new Team("CSKA", "CSKA-A", "PESHO");
        Team team2 = new Team("Ludogorets", "LUDOGORETS-B", "IVAN");

        //If team files are empty use team's information to create them with some players. Uncomment next 8 rows
      /*  team1.addPlayer(new VolleyballPlayer("Ivan", 30, "Setter", 5, 1));
        team1.addPlayer(new VolleyballPlayer("Dragan", 40, "Libero", 10, 5));
        team1.addPlayer(new VolleyballPlayer("Peter", 20, "blocker", 8, 4));
        team2.addPlayer(new VolleyballPlayer("Stoian", 26, "Setter", 4, 2));
        team2.addPlayer(new VolleyballPlayer("Martin", 20, "Libero", 6, 3));
        team2.addPlayer(new VolleyballPlayer("Pavel", 24, "blocker", 8, 4));
        FileManager.writeToFile(team1.getPlayers(),"team1");
        FileManager.writeToFile(team2.getPlayers(),"team2");*/
//---------------------------------------------------------------------------------------------------------------------
//        FileManager.writeToFile(team1.getPlayers(),"team1");

        // Test the game..
        FileManager.readFromFile(team1, "team1.csv");
        FileManager.readFromFile(team2, "team2.csv");

        System.out.println("---------- Teams info ----------");
        System.out.println(team1 + "-----------------------------------------" +"\n" + team2);

        //test to change parameter of the player
        System.out.println(team1.getPlayers().get("Dragan").getHealth());
        team1.getPlayers().get("Dragan").setHealth(3);
//        team2.getPlayers().get("Stefanakis").setHealth(3);
//       To save player changes in files please use/uncomment writeToFile() [files];
        FileManager.writeToFile(team1.getPlayers(),"team1");
//        FileManager.writeToFile(team2.getPlayers(),"team2");

        System.out.println("===========================================");
        System.out.printf(team1.getTeamName() + " strength: %.01f%n", team1.calculateTeamStrength());
        System.out.printf(team2.getTeamName() + " strength: %.01f%n", team2.calculateTeamStrength());
        FileManager.writeToFile(team1.getPlayers(),"team1");
        System.out.println("===========================================");
        playMatch(team1, team2);
        System.out.println("===========================================");
    }


    public static void playMatch(Team o1, Team o2) {

        int result = o1.compare(o1, o2);
        String txt;
        if (result == 0) {
            txt = ("Result is equal (" + o1.getTeamName() + ":" + o2.getTeamName() + " )");
            FileManager.writeResult(FileManager.readResultFile("result.txt"),txt);
        } else if (result > 0) {
            txt =(o1.getTeamName() + " is the winner!");
            FileManager.writeResult(FileManager.readResultFile("result.txt"),txt);
        } else {
            txt = (o2.getTeamName() + " is the winner!");
            FileManager.writeResult(FileManager.readResultFile("result.txt"),txt);
        }
        System.out.println(txt);
    }


}
