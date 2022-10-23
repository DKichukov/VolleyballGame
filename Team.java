package Game;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Team implements Playable, Comparator<Team> {
    private String teamName;
    private String stadiumName;
    private String coachName;
    private Map<String, VolleyballPlayer> players;


    public Team(String teamName) {
        this.teamName = teamName;
        this.stadiumName = "Unknown";
        this.coachName = "Unknown";
        this.players = new HashMap<>();
    }

    public Team(String teamName, String stadiumName, String coachName) {
        this.teamName = teamName;
        this.stadiumName = stadiumName;
        this.coachName = coachName;
        this.players = new HashMap<>();
    }

    public String getTeamName() {
        return teamName;
    }


    public HashMap<String, VolleyballPlayer> getPlayers() {
        return new HashMap<>(this.players);
    }


    public void addPlayer(VolleyballPlayer p) {
        if (!players.containsKey(p.getName())) {
            players.put(p.getName(), p);
        }
    }


    public double calculateTeamStrength() {
        double strength = 0.0;
        int count = 0;
        for (Map.Entry<String, VolleyballPlayer> p : players.entrySet()) {
            strength += p.getValue().getStrength();
            count++;
        }
        return (strength / count);
    }

    public double calculateStrength(int number) {
        return calculateTeamStrength() +number;

    }


    @Override
    public void teamTraining() {
        for (Map.Entry<String, VolleyballPlayer> p : players.entrySet()) {
            p.getValue().train();
            FileManager.writeToFile((HashMap<String, VolleyballPlayer>) players,this.teamName);
        }
        System.out.println("All players of " + getTeamName() + " are training ..");
    }

    @Override
    public void teamRest() {
        for (Map.Entry<String, VolleyballPlayer> p : players.entrySet()) {
            p.getValue().rest();
            FileManager.writeToFile((HashMap<String, VolleyballPlayer>) players,this.teamName);
            System.out.println("All players of " + getTeamName() + " are resting ..");
        }
    }

    @Override
    public String toString() {
        return  "teamName='" + this.teamName +
                ", stadiumName='" + this.stadiumName +
                ", coachName='" + this.coachName +
                ", players=" +"\n"+ getPlayers()+ "\n";

   }

    @Override
    public int compare(Team o1, Team o2) {
        Random rand = new Random();
        int number1 = rand.nextInt(25)+1;
        int number2 = rand.nextInt(25)+1;
        System.out.println("RandNumber1: " + number1 + " and RandNumber2: " + number2);
        System.out.println("=========================");
        return (int) (o1.calculateStrength(number1 )- o2.calculateStrength(number2 ));
    }
}
