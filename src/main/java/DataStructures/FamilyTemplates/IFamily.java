package DataStructures.FamilyTemplates;

import DataStructures.People.People;
import PeopleGenerator.PeopleGenerator;

import java.util.List;

public interface IFamily {

    /**
     * Dla danego wzorca funkcja tworzy losową rodzinę
     * @return Stworzona rodzina
     */
    public List<People> Create(PeopleGenerator generator);
    public void Export();
}
