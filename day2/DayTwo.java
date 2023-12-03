import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("all")
public class DayTwo {
    static int indexMap(String color) {
        return switch (color) {
            case "red" -> 0;
            case "green" -> 1;
            case "blue" -> 2;
            default -> -1;
        };
    }

    public static void main(String... args) throws FileNotFoundException {
        int[] rgb = {12, 13, 14};
        int sum = 0;

        Scanner scnr = new Scanner(new File("C:\\Users\\rlham\\aoc\\2023\\day2\\input.txt"));
        lines: while (scnr.hasNextLine()) {
            String game = scnr.nextLine();
            int colonIndex = game.indexOf(":");
            int id = Integer.parseInt(game.substring(game.indexOf(" ") + 1, colonIndex));
            game = game.substring(colonIndex + 1);
            String[] sets = game.split(";");
            for (String set : sets) {
                String[] entries = set.split(",");
                for (String entry : entries) {
                    String[] values = entry.substring(1).split(" ");
                    if (Integer.parseInt(values[0]) > rgb[indexMap(values[1])]) {
                        continue lines;
                    }
                }
            }
            sum += id;
        }

        System.out.println(sum);
    }
}