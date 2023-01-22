package DataStructures.People;

import java.util.Date;

public class People {
    private Date birthDate;
    private String name;
    private String surname;
    private Gender gender;

    private String pesel;
    public People(Date birthDate, Gender gender, String name, String surname, String pesel) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public Gender GetGender() {
        return gender;
    }
    public Date GetBirthDate() {
        return birthDate;
    }
    public void SetPesel(String pesel) {
        this.pesel = pesel;
    }
    public String GetSurname() {
        return this.surname;
    }

}

