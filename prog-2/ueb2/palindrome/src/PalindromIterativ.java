public class PalindromIterativ implements Palindrom {
    @Override
    public boolean istPalindrom(String s) {
        s = s.toLowerCase(); // Kleinbuchstaben

        if (s.length() <= 1)
            return true;

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "iterativ";
    }
}
