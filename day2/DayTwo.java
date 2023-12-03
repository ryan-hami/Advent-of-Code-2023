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

    static void part1(Integer... rgb) throws FileNotFoundException {
        int sum = 0;

        Scanner scnr = new Scanner(new File("C:\\Users\\rlham\\aoc\\2023\\day2\\input.txt"));
        lines: while (scnr.hasNextLine()) {
            int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

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

    static void part2() throws FileNotFoundException {
        int sum = 0;

        Scanner scnr = new Scanner(new File("C:\\Users\\rlham\\aoc\\2023\\day2\\input.txt"));
        lines: while (scnr.hasNextLine()) {
            int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

            String game = scnr.nextLine();
            int colonIndex = game.indexOf(":");
            int id = Integer.parseInt(game.substring(game.indexOf(" ") + 1, colonIndex));
            game = game.substring(colonIndex + 1);
            String[] sets = game.split(";");
            for (String set : sets) {
                String[] entries = set.split(",");
                for (String entry : entries) {
                    String[] values = entry.substring(1).split(" ");
                    int num = Integer.parseInt(values[0]);
                    int index = indexMap(values[1]);
                    max[index] = Math.max(num, max[index]);
                }
            }
            int power = max[0] * max[1] * max[2];
            sum += power;
        }

        System.out.println(sum);
    }

    public static void main(String... args) throws FileNotFoundException {
        part1(12, 13, 14);
        part2();
    }
}