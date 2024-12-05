import java.util.*;

import java.io.File;

import java.io.FileNotFoundException;



public class Works {

    public static void main(String[] args) {

        try {

            String filePath = "input.txt";

            Scanner in = new Scanner(new File(filePath));

            List<Integer> report = new ArrayList<>();

            int sum = 0;

            // Read and process the file

            while (in.hasNextLine()){

                String line = in.nextLine();

                String[] parts = line.split(" ");

                for (String part : parts) {

                report.add(Integer.parseInt(part));

                }

                if(isSafe(report)) sum++;

                report.clear();

            }

            System.out.println(sum);

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());

        }

    }

    public static boolean isSafe(List<Integer> report) {
    

    // If the first two values are equal, it's invalid
    if (report.get(0) - report.get(1) == 0) {
        for (int i = 0; i < report.size(); i++) {
            List<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);
            if (isSafe(modifiedReport)) {
                return true;
            }
        }
        return false;
    }

    // Check for increasing sequence
    if (report.get(0) - report.get(1) < 0) {
        for (int i = 1; i < report.size(); i++) {
            int diff = report.get(i) - report.get(i - 1);
            if (!(diff > 0 && diff <= 3)) { // Invalid increase
            for (int j = 0; i < report.size(); i++) {
                List<Integer> modifiedReport = new ArrayList<>(report);
                modifiedReport.remove(i);
                if (isSafe(modifiedReport)) {
                    return true;
                }   
            }
            return false;
            }
        }
    }
    // Check for decreasing sequence
    else {
        for (int i = 1; i < report.size(); i++) {
            int diff = report.get(i) - report.get(i - 1);
            if (!(diff < 0 && diff >= -3)) { // Invalid decrease
                for (int j = 0; i < report.size(); i++) {
            List<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);
            if (isSafe(modifiedReport)) {
                return true;
            }
        }
        return false;
            }
        }
    }

    return true;
    }


}