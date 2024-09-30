public class task2 {

    public static String createCSV(String[] headers, String[][] data) {
        StringBuilder csv = new StringBuilder();

        for (int i = 0; i < headers.length; i++) {
            csv.append(headers[i]);
            if (i < headers.length - 1) {
                csv.append(",");
            }
        }
        csv.append("\n");

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                csv.append(row[i]);
                if (i < row.length - 1) {
                    csv.append(",");
                }
            }
            csv.append("\n");
        }

        return csv.toString();
    }

    public static void main(String[] args) {
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"John", "25", "New York"},
                {"Alice", "30", "Los Angeles"},
                {"Bob", "22", "Chicago"}
        };

        String csv = createCSV(headers, data);
        System.out.println(csv);
    }
}
