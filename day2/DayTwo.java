import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("all")
public class DayTwo {
    public static void main(String... args) throws FileNotFoundException {
        //Map<Integer, String> map = new HashMap<>();

        Scanner scnr = new Scanner(new File("C:\\Users\\rlham\\aoc\\2023\\day2\\input.txt"));
        while (scnr.hasNextLine()) {
            String game = scnr.nextLine();
            int id = Integer.parseInt(String.valueOf(game.charAt(5)));
            game = game.substring(7);
            String[] sets = game.split(";");
            for (String set : sets) {
                String[] entries = set.split(",");
                for (String entry : entries) {
                    String[] values = entry.substring(1).split(" ");
                    int num = Integer.parseInt(values[0]);
                    String color = values[1];
                    System.out.println(num + " of color " + color);
                }
            }
        }
    }
}