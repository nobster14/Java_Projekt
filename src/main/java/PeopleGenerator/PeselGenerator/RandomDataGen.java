package PeopleGenerator.PeselGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RandomDataGen {
    public Date getRandomDate(int startYear, int stopYear){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(startYear, stopYear);
        gc.set(Calendar.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return new Date(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));

    }

    public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
