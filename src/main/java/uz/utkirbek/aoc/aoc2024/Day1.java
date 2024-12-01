package uz.utkirbek.aoc.aoc2024;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        problem1();
    }

    private static void problem1() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("day1.txt"));
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();

        while (sc.hasNext()) {
            left.add(sc.nextInt());
            right.add(sc.nextInt());
        }

        left.sort(Comparator.naturalOrder());
        right.sort(Comparator.naturalOrder());

        long sum = 0;
        for (int i = 0; i < left.size(); i++) {
            sum += Math.abs(right.get(i) - left.get(i));
        }

        System.out.println(sum);
    }

    private static void problem2() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("day1.txt"));
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int num1, num2;

        while (sc.hasNext()) {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            left.put(num1, left.getOrDefault(num1, 0) + 1);
            right.put(num2, right.getOrDefault(num2, 0) + 1);
        }

        long sum=0;
        for(Map.Entry<Integer, Integer> entry : left.entrySet()) {
            if(right.containsKey(entry.getKey())) {
                sum+=entry.getKey()*right.get(entry.getKey())*entry.getValue();
            }
        }
        System.out.println(sum);
    }
}
