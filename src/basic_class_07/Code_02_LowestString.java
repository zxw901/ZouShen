package basic_class_07;

import java.util.Arrays;
import java.util.Comparator;

public class Code_02_LowestString {

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static StringBuilder lowestString(String[] arr) {
        StringBuilder res = new StringBuilder();
        if (arr == null || arr.length == 0) {
            return res;
        }
        Arrays.sort(arr, new MyComparator());
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestString(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestString(strs2));

        String[] strs3 = {""};
        System.out.println(lowestString(strs3));

    }
}
