package PeopleGenerator;

import DataStructures.Config;
import DataStructures.Mappers.FileType.FileType;
import DataStructures.People.Gender;
import DataStructures.People.People;
import PeopleGenerator.PeselGenerator.PeselGenerator;
import PeopleGenerator.PeselGenerator.RandomDataGen;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Date;

public class PeopleGenerator implements IPeopleGenerator{
    private final ArrayList<String> maleSurnames = new ArrayList<>();
    private final ArrayList<String> maleNames = new ArrayList<>();
    private final ArrayList<String> femaleSurnames = new ArrayList<>();
    private final ArrayList<String> femaleNames = new ArrayList<>();

    private final PeselGenerator peselGenerator = new PeselGenerator();

    private final Random random = new Random();
    private final RandomDataGen randomData = new RandomDataGen();

    private final Date currentDate = new Date(System.currentTimeMillis());

    @Override
    public People GetRandomAdult(Boolean isMan) {
        var gender = GetRandomGender(isMan);
        var name = GetRandomName(gender);
        var surname = GetRandomSurname(gender, "");
        var birthDate = GetRandomBirthDate(Config.maxAdultAge, Config.minAdultAge);
        var ret = new People(birthDate, gender, name, surname, "");
        ret.SetPesel(GeneratePesel(ret));

        return ret;
    }

    @Override
    public People GetRandomSpouse(People husband) {
        var name = GetRandomName(Gender.female);
        var surname = GetRandomSurname(Gender.female, husband.GetSurname());
        var birthDate = GetRandomBirthDate(currentDate.getYear() - husband.GetBirthDate().getYear() + Config.ageDiff,
                currentDate.getYear() - husband.GetBirthDate().getYear() - Config.ageDiff);
        var ret = new People(birthDate, Gender.female, name, surname, "");
        ret.SetPesel(GeneratePesel(ret));

        return ret;
    }

    @Override
    public People GetRandomChild(People dad, People mum) {
        return null;
    }

    @Override
    public void AddData(FileType fileType, String data) {
        switch (fileType) {
            case maleNames -> maleNames.add(data);
            case femaleNames -> femaleNames.add(data);
            case maleSurnames -> maleSurnames.add(data);
            case femaleSurnames -> femaleSurnames.add(data);
        }
    }

    private String GeneratePesel(People people) {
        return peselGenerator.Generate(people);
    }
    private Gender GetRandomGender(Boolean isMan) {
        return isMan ? Gender.male : random.nextBoolean() ? Gender.male : Gender.female;
    }
    private String GetRandomName(Gender gender) {
        return gender == Gender.female ? femaleNames.get(random.nextInt(femaleNames.size())) :
                maleNames.get(random.nextInt(maleNames.size()));
    }
    private String GetRandomSurname(Gender gender, String husbandSurname) {
        if (!Objects.equals(husbandSurname, "")) {
            var username = femaleSurnames.stream()
                    .filter(x -> x.startsWith(husbandSurname.substring(0, husbandSurname.length() - 1)))
                    .findFirst();

            return username.orElseGet(() -> femaleSurnames.get(random.nextInt(femaleSurnames.size())));
        }

        return gender == Gender.female ? femaleSurnames.get(random.nextInt(femaleSurnames.size())) :
                maleSurnames.get(random.nextInt(maleSurnames.size()));
    }

    private Date GetRandomBirthDate(int maxAge, int minAge) {
        return randomData.getRandomDate(currentDate.getYear() - maxAge < Config.maxAdultAge ? Config.maxAdultAge : maxAge,
                currentDate.getYear() - minAge < Config.minAdultAge ? Config.minAdultAge : minAge);
    }
}
