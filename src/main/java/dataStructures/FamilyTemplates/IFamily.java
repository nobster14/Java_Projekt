package dataStructures.FamilyTemplates;

import dataStructures.People.People;
import PeopleGenerator.PeopleGenerator;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;

public interface IFamily {

    /**
     * Dla danego wzorca funkcja tworzy losową rodzinę
     * @return Stworzona rodzina
     */
    public List<People> Create(PeopleGenerator generator);


}
