import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class task4 {

    public static void findMinMaxAndLog(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        logToFile(min, max);
    }

    private static void logToFile(int min, int max) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String currentDateTime = LocalDateTime.now().format(formatter);
        String logMessage = currentDateTime + " {min: " + min + ", max: " + max + "}\n";

        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 9, 1, 4, 8};

        findMinMaxAndLog(array);
    }
}
