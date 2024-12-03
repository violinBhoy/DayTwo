import java.util.*;
import java.io.*;

public class PartOne {
    public static void main(String args[]) {
        int sum = 0;
        Scanner in;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            in = new Scanner(new File("input.txt"));
            while (in.hasNextLine()) {
                list.clear();
                String s = in.nextLine();
                String ins[] = s.split(" ");
                for (int i = 0; i < ins.length; i++) {
                    list.add(Integer.parseInt(ins[i]));
                }
                if (list.get(0) > list.get(1) && descending(list)) {
                    sum++;
                } else if (list.get(0) < list.get(1) && ascending(list)) {
                    sum++;
                }
            }   
        } catch (FileNotFoundException e) {
            System.out.println("You're an idiot");
        }
        System.out.println(sum);
    }

    public static boolean descending(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (!(list.get(i) > list.get(i+1) && list.get(i)-list.get(i+1) <= 3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean ascending(ArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (!(list.get(i) < list.get(i+1) && list.get(i+1)-list.get(i) <= 3)) {
                return false;
            }
        }
        return true;
    }
}