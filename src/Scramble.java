import java.util.*;

public class Scramble {

    public static String scrambleWord(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 'A' && arr[i+1] != 'A') {
                char temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i++;
            }
        }
        return new String(arr);
    }

    public static void scrambleOrRemove(List<String> wordList) {
        Iterator<String> iter = wordList.iterator();
        while (iter.hasNext()) {
            String word = iter.next();
            String scrambled = scrambleWord(word);
            if (scrambled.equals(word)) {
                iter.remove();
            } else {
                int index = wordList.indexOf(word);
                wordList.set(index, scrambled);
            }
        }
    }
}