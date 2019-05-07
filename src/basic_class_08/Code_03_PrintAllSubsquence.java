package basic_class_08;

public class Code_03_PrintAllSubsquence {
    public static void printAllSubsquence(String str) {
        char[] chars = str.toCharArray();
        printAllSubsquence(chars, 0, "");
    }

    public static void printAllSubsquence(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSubsquence(str, i + 1, res);
        printAllSubsquence(str, i + 1, res + String.valueOf(str[i]));
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSubsquence(str);
    }
}
