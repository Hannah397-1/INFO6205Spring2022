public class Q1 {
    /**
     * Question1: String Compression: Implement a method to perform basic string compression using the counts of repeated
     * characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
     * become smaller than the original string, your method should
     * return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     */
    public String compressString(String str){
        //TODO: Write your code here
        if (str == null || str.length() == 0) {
            return str;
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                sb.append(str.charAt(i));
                sb.append(j - i);
                i = j;
            }
            j++;
        }
        sb.append(str.charAt(i));
        sb.append(j - i);

        if (sb.length() >= str.length()) {
            return str;
        }
        return sb.toString();
    }

}


























