public class task3 {

    public static String removeEmptyLines(String text) {
        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                result.append(line).append("\n");
            }
        }

        return result.toString().trim(); // Удаляем последний перевод строки
    }

    public static void main(String[] args) {
        String text = "This is a line\n\nThis is another line\n  \nAnd another one\n";
        String result = removeEmptyLines(text);
        System.out.println(result);
    }
}