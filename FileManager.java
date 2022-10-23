package Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    public static void writeToFile(HashMap<String, VolleyballPlayer> players, String fileName) {
        try {
            String file = fileName + ".csv";
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, VolleyballPlayer> p : players.entrySet()) {
                writer.write(p.getValue().getName() + "," + p.getValue().getAge() + "," + p.getValue().getPosition() +
                        "," + p.getValue().getStrength() + "," + p.getValue().getHealth());
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("The file can not be written on the disk drive! Ooops!");
        }
    }

    public static void writeResult(ArrayList<String> txt, String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
           ArrayList<String> memory = new ArrayList<>();
            for (String str :txt ){
            memory.add(str);
            }
            memory.add(message);
            for (String str :memory ){
                writer.write(str);
                writer.newLine();
            }
            writer.close();

        } catch (Exception e) {
            System.out.println("The file can not be written on the disk drive! Ooops!");
        }
    }

    public static ArrayList<String> readResultFile(String fileName) {
        ArrayList<String> text = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("result.txt"));
            String line = "";

            while ((line = reader.readLine()) != null) {
             text.add(line);
            }
            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }

        return text;
    }

    public static void readFromFile(Team team, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] words = null;
                words = line.toString().split(",");

                VolleyballPlayer player = new VolleyballPlayer(words[0], Integer.parseInt(words[1]),
                        words[2], Integer.parseInt(words[3]), Integer.parseInt(words[4]));
                team.addPlayer(player);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found on the disk drive!");
        }
    }


//    public static void updateFile(HashMap<String,VolleyballPlayer> players, String name) {
//        try {
//            String file = HashMap.class + ".csv";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//
//            for (Map.Entry<String, VolleyballPlayer> p :players.entrySet()) {
//                if()
//                writer.write(p.getValue().getName() + "," + p.getValue().getAge() + "," + p.getValue().getPosition() +
//                        "," + p.getValue().getStrength() +  "," + p.getValue().getHealth());
//                writer.newLine();
//            }
//            writer.close();
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }

}
