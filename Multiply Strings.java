public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lena = num1.length();
        int lenb = num2.length();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] ni1 = new int[lena];
        int[] ni2 = new int[lenb];
        for (int i = 0; i < lena; i++) {
            ni1[i] = n1[i] - '0';
        }
        for (int i = 0; i < lenb; i++) {
            ni2[i] = n2[i] - '0';
        }
        reverse(ni1, 0, lena - 1);
        reverse(ni2, 0, lenb - 1);
        int len = lena + lenb;
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i = 0; i < lena; i++) {
            a[i] = ni1[i];
        }
        for (int i = 0; i < lenb; i++) {
            b[i] = ni2[i];
        }
        int[] c = new int[len];
        mul(a, b, c);
        reverse(c, 0, len - 1);
        int i = 0;
        while (i < len - 1 && c[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (; i < len; i++) {
            char ch = (char) ('0' + c[i]);
            sb.append(ch);
        }
        return sb.toString();
    }

    private void mul(int[] a, int[] b, int[] c) {
        int len = a.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(tmp, 0);
            mul(a, b[i], tmp);
            for (int j = 0; j < len - i; j++) {
                c[i + j] += tmp[j];
                if (i + j + 1 < len) {
                    c[i + j + 1] += c[i + j] / 10;
                }
                c[i + j] %= 10;
            }
        }
    }

    private void mul(int[] a, int b, int[] c) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            c[i] += a[i] * b;
            if (i + 1 < len) {
                c[i + 1] += c[i] / 10;
            }
            c[i] %= 10;
        }
    }

    private void reverse(int[] n, int s, int e) {
        for (; s < e; s++, e--) {
            swap(n, s, e);
        }
    }

    private void swap(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }
}


public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        reverse(c1);
        reverse(c2);
        char[] c3 = new char[c1.length + c2.length + 1];
        multi(c1, c2, c3);
        reverse(c3);
        int index = 0;
        while(index < c3.length - 1 && c3[index] == '0'){
            index++;
        }
        return new String(c3, index, c3.length - index);
    }
    
    // c3 = c1 * c2
    private void multi(char[] c1, char[] c2, char[] c3){
        Arrays.fill(c3, '0');
        int len1 = c1.length;
        int len2 = c2.length;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                c3[i + j] += toInt(c1[i]) * toInt(c2[j]);
                int val = toInt(c3[i + j]);
                c3[i + j + 1] += val / 10;
                c3[i + j] = toChar(val % 10);
            }
        }
    }

    private int toInt(char c){
        return (int)(c - '0');
    }
    
    private char toChar(int i){
        return (char)(i + '0');
    }
    
    private void reverse(char[] c){
        reverse(c, 0, c.length - 1);
    }
    
    private void reverse(char[] c, int s, int e){
        while(s < e){
            swap(c, s++, e--);
        }
    }
    
    private void swap(char[] c, int i, int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}