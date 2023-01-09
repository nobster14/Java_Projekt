package PeopleGenerator.PeselGenerator;

import DataStructures.People.Gender;
import DataStructures.People.People;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Random;

public class PeselGenerator {

    DecimalFormat df = new DecimalFormat("00");

    public PeselGenerator() {

    }

    public String generate(People people) {
        String pesel = "";

        try {
            pesel = String.valueOf(df.format(people.GetBirthDate().getYear() % 100));
            pesel += getMonthForPesel(people.GetBirthDate().getYear(), people.GetBirthDate().getMonth());
            pesel += df.format(Double.valueOf(people.GetBirthDate().getDay()));
            pesel += getSeriesNumberForPesel();
            pesel += getSexNumberForPesel(people.GetGender());
            pesel += String.valueOf(calculateControlNumber(pesel));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return pesel;
    }

    private int calculateControlNumber(String pesel) {
        char[] p = pesel.toCharArray();
        Integer sum = Integer.valueOf(String.valueOf(p[0])) * 1
                + Integer.valueOf(String.valueOf(p[1])) * 3
                + Integer.valueOf(String.valueOf(p[2])) * 7
                + Integer.valueOf(String.valueOf(p[3])) * 9
                + Integer.valueOf(String.valueOf(p[4])) * 1
                + Integer.valueOf(String.valueOf(p[5])) * 3
                + Integer.valueOf(String.valueOf(p[6])) * 7
                + Integer.valueOf(String.valueOf(p[7])) * 9
                + Integer.valueOf(String.valueOf(p[8])) * 1
                + Integer.valueOf(String.valueOf(p[9])) * 3;

        int result = sum % 10;
        result = 10 - result;
        return result % 10;

    }

    public boolean validate(String number) {
        char[] p = number.toCharArray();

        Integer controlNumber = calculateControlNumber(number);

        if (controlNumber.equals(Integer.valueOf(String.valueOf(p[10])))) {
            return true;
        }

        return false;
    }

    private String getMonthForPesel(int year, int month) throws Exception {


        if (year < 1800) {
            throw new Exception();
        } else if (year >= 1800 && year < 1900) {
            return String.valueOf(month + 80);
        } else if (year >= 1900 && year < 2000) {
            return df.format(Double.valueOf(month));
        } else if (year >= 2000 && year < 2100) {
            return String.valueOf(month + 20);
        } else if (year >= 2100 && year < 2200) {
            return String.valueOf(month + 40);
        } else if (year >= 2200 && year < 2300) {
            return String.valueOf(month + 60);
        } else {
            throw new Exception();
        }
    }

    private String getSeriesNumberForPesel() {
        RandomDataGen rdg = new RandomDataGen();
        DecimalFormat df = new DecimalFormat("000");
        String result = df.format(rdg.randBetween(0, 999));
        return result;
    }

    private String getSexNumberForPesel(Gender gender) {
        if (gender == Gender.female)
            return Integer.toString(new int[]{0, 2, 4, 6, 8}[new Random().nextInt(5)]);
        else
            return Integer.toString(new int[]{1, 3, 5, 7, 9}[new Random().nextInt(5)]);
    }
}
