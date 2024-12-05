import java.util.*;
import java.io.*;

public class Two {//what if you remove the second value being checked
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
                if (testLogic(list, true)) {
                    sum++;
                }
            }   
        } catch (FileNotFoundException e) {
            System.out.println("You're an idiot");
        }
        System.out.println(sum);
    }

    public static boolean testLogic(ArrayList<Integer> list, boolean first) {
        if (list.get(0) > list.get(1) && descending(list, first)) {
            return true;
        } else if (list.get(0) < list.get(1) && ascending(list, first)) {
            return true;
        }
        return false;
    }

    public static boolean descending(ArrayList<Integer> list, boolean first) {
        int length = list.size();
        for (int i = 0; i < length-1; i++) {
            if (!(list.get(i) > list.get(i+1) && list.get(i)-list.get(i+1) <= 3)) {
                if (first) {
                    return removing(list, i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean ascending(ArrayList<Integer> list, boolean first) {
        int length = list.size();
        for (int i = 0; i < length-1; i++) {
            if (!(list.get(i) < list.get(i+1) && list.get(i+1)-list.get(i) <= 3)) {
                if (first) {
                    return removing(list, i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean removing(ArrayList<Integer> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            int removed = list.remove(i);
            if (testLogic(list, false)) {
                return true;
            }
            list.add(i, removed);
        }
        return false;
    }
}