package DataStructures.People;

import java.util.Date;

public class People {
    private Date birthDate;
    private String name;
    private String username;
    private Gender gender;

    private String pesel;
    public People(Date birthDate, Gender gender, String name, String username, String pesel) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = name;
        this.username = username;
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

}

