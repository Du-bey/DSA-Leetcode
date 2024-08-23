import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String fractionAddition(String expr) {
        int nume = 0;
        int deno = 1;

        int i = 0;
        int n = expr.length();
        while (i < n) {
            int currNume = 0;
            int currDeno = 0; 
            boolean isNeg = (expr.charAt(i) == '-');

            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                i++;
            }

            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                currNume = (currNume * 10) + val;
                i++;
            }

            i++;

            if (isNeg) {
                currNume *= -1; 
            }

            while (i < n && Character.isDigit(expr.charAt(i))) {
                int val = expr.charAt(i) - '0';
                currDeno = (currDeno * 10) + val;
                i++;
            }

            nume = nume * currDeno + currNume * deno;
            deno = deno * currDeno;
        }

        int gcd = gcd(Math.abs(nume), deno);

        nume /= gcd;
        deno /= gcd;

        return nume + "/" + deno;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}