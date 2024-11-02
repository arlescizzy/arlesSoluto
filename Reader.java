/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static int[] readIntegers() {
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter list of integers, press enter to stop :");

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine().trim();
            if (line.isEmpty()) break;

            try {
                int num = Integer.parseInt(line);
                list.add(num);
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
        int[] list1 = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(list1);
        return list1;
    }

    public static int readKey(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + s + " to search for: ");
        int key = scanner.nextInt();
        return key;

    }

}



