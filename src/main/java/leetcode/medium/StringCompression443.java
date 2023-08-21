package leetcode.medium;

public class StringCompression443 {
    public static void main(String[] args) {
        //compress(new char[]{'a', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'});
        compress(new char[]{'a','a','b','b','c','c','c'});
    }

    public static int compress(char[] chars) {
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
                //if (i == chars.length - 1) break;
            }
            if (count > 1) {
                s += chars[i - 1] + "" + count;
            } else {
                s += chars[i];
            }
            System.out.println("s= " + s);
        }
        System.out.println("s= " + s);
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        return s.length();
    }

    public int compressBest(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}
