package PeopleGenerator.IdNumberGenerator;

import PeopleGenerator.PeselGenerator.RandomDataGen;

import java.text.DecimalFormat;
import java.util.Random;

public class IdNumberGenerator {
    public String Generate() {
        String id = "";

        try {
            id = RandGeneratedStr(3);
            var z = getRandomNumberString();
            id += getControlNumber(id + z);
            id += z;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    static String RandGeneratedStr(int n) {
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder s = new StringBuilder(n);
        for (int i=0; i<n; i++) {
            int ch = (int)(AlphaNumericStr.length() * Math.random());
            s.append(AlphaNumericStr.charAt(ch));
        }
        return s.toString();
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        // 5 losowych cyfr
        int number = rnd.nextInt(99999);
        return String.format("%05d", number);
    }

    public static char getControlNumber(String id) {
        int checkSum;
        int control;
        char[] p = id.toCharArray();
        // mapowanie z ASCII na wartości z sumy kontrolnej dowodu
        checkSum = 7 * ((int)p[0] - 55)
                + 3 * ((int)p[1] - 55)
                + ((int)p[2] - 55)
                + 7 * Integer.parseInt(String.valueOf(p[3]))
                + 3 * Integer.parseInt(String.valueOf(p[4]))
                + Integer.parseInt(String.valueOf(p[5]))
                + 7 * Integer.parseInt(String.valueOf(p[6]))
                + 3 * Integer.parseInt(String.valueOf(p[7]));
        control = checkSum % 10;
        return (char) (control + (int)'0');
    }
}
