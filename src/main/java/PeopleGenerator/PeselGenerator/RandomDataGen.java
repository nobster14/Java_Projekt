package PeopleGenerator.PeselGenerator;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomDataGen {
    public GregorianCalendar getRandomDate(int startYear, int stopYear){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(startYear, stopYear);
        gc.set(Calendar.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return gc;

    }

    public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
