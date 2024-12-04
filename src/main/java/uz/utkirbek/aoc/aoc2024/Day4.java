package uz.utkirbek.aoc.aoc2024;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        problem2();
    }

    private static void problem1() {
        //8 ta tomonlardan biri bo'yicha XMAS yozuvi bor bo'lsa sanoqqa qo'shish kerak
        int count = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("day4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> rows = new ArrayList<>();

        while (sc.hasNext()) {
            rows.add(sc.nextLine());
        }

        char[][] table = new char[rows.size()][rows.get(0).length()];

        for (int i = 0; i < rows.size(); i++) {
            table[i] = rows.get(i).toCharArray();
        }
        int[][] directions = {
                {1, 0},
                {1, 1},
                {0, 1},
                {-1, 1},
                {-1, 0},
                {-1, -1},
                {0, -1},
                {1, -1}
        };

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {

                for (int k = 0; k < directions.length; k++) {
                    if (isXmas(table, i, j, directions[k])) {
                        count++;
                    }
                }

            }
        }
        System.out.println(count);
    }

    private static boolean isXmas(char[][] table, int row, int column, int[] direction) {
        String xmas = "XMAS";
        int currentRow, currentColumn;

        for (int i = 0; i < 4; i++) {
            currentRow = row + i * direction[0];
            currentColumn = column + i * direction[1];

            if (currentRow < 0 || currentColumn < 0 || currentRow >= table.length || currentColumn >= table[0].length || table[currentRow][currentColumn] != xmas.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    private static void problem2() {
        /**
         * A harfini atrofida MAS yozuvlaridan ikkitasi X hosil qilsa sanoqqa qo'shish kerak
         */
        int count = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("day4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> rows = new ArrayList<>();

        while (sc.hasNext()) {
            rows.add(sc.nextLine());
        }

        char[][] table = new char[rows.size()][rows.get(0).length()];

        for (int i = 0; i < rows.size(); i++) {
            table[i] = rows.get(i).toCharArray();
        }


        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'A') {
                    count += isXmas2(table, i, j);
                }
            }
        }
        System.out.println(count);


    }

    private static int isXmas2(char[][] table, int i, int j) {
        int count = 0;

        if (i == table.length - 1 || j == table[0].length - 1 || i == 0 || j == 0) {
            return count;
        }


        if (table[i - 1][j - 1] == 'M' && table[i + 1][j + 1] == 'S' &&
                (table[i + 1][j - 1] == 'M' && table[i - 1][j + 1] == 'S' || table[i - 1][j + 1] == 'M' && table[i + 1][j - 1] == 'S')
                || table[i - 1][j - 1] == 'S' && table[i + 1][j + 1] == 'M' &&
                (table[i + 1][j - 1] == 'M' && table[i - 1][j + 1] == 'S' || table[i - 1][j + 1] == 'M' && table[i + 1][j - 1] == 'S')) {
            count++;
        }


        return count;
    }

}
