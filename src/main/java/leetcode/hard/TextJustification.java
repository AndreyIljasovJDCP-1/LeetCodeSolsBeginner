package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 *<a href="https://leetcode.com/problems/text-justification/description/">68. Text Justification</a>
 */
public class TextJustification {
    public static List<String> fullJustifyLC(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int index = i;
            int length = 0;
            line.clear();
            while (index < words.length && (length + 1 + words[index].length()) <= maxWidth) {
                line.add(words[index++]);
                length = String.join(" ", line).length();
            }
            result.add(line.size() == 0
                    ? words[index++]
                    : index == words.length
                    ? String.join(" ", line) + " ".repeat(maxWidth - length)
                    : formLineLC(line, maxWidth));
            i = index;
        }
        return result;
    }

    private static String formLineLC(List<String> line, int width) {
        if (line.size() == 1) return String.join("", line) + " ".repeat(width - line.get(0).length());
        int spaces = width - String.join("", line).length();
        while (spaces > 0) {
            for (int j = 0; j < line.size() - 1; j++) {
                line.set(j, line.get(j) + " ");
                spaces--;
                if (spaces == 0) break;
            }
        }
        return String.join("", line);
    }
}
