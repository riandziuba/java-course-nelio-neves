package org.example.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Custumer {
    private String name;
    private String email;
    private Date birthDate;
    static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Custumer(String name, String email, String birthDate) throws ParseException {
        this.name = name;
        this.email = email;
        this.birthDate = dateFormat.parse(birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getFormattedBirthDate() {
        return dateFormat.format(birthDate);
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
