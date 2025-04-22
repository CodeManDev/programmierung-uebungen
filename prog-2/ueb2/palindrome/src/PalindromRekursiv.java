public class PalindromRekursiv implements Palindrom {
    @Override
    public boolean istPalindrom(String s) {
        s = s.toLowerCase(); // Kleinbuchstaben
        if (s.length() <= 1)
            return true; // basisfall

        if (s.charAt(0) == s.charAt(s.length() - 1))
            return istPalindrom(s.substring(1, s.length() - 1)); // rekursiver Aufruf

        return false;
    }

    @Override
    public String toString() {
        return "rekursiv";
    }
}
