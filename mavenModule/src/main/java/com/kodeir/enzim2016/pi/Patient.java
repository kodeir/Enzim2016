package com.kodeir.enzim2016.pi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei Riabinin on 11.06.2016.
 */
public class Patient implements Comparable{

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;

    private List<Coefficients> coefficients;

    public Patient(long id, String name, String surname, String patronymic, LocalDate birthDate) {
        this(id, name, surname, patronymic, birthDate, new ArrayList<>());
    }

    public Patient(long id, String name, String surname, String patronymic, LocalDate birthDate, List<Coefficients> coefficients) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.coefficients = coefficients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Coefficients> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Coefficients> coefficients) {
        this.coefficients = coefficients;
    }

    public String toString(){
        String newLine = System.getProperty("line.separator");
        return "Patient: " + name + " " + surname + " " + patronymic + "; born: " + birthDate
                + newLine
                + "Coefficients: " + coefficients.toString()
                + newLine
                + newLine;
    }

    @Override
    public int compareTo(Object o) {
        Patient p = (Patient) o;
        return surname.compareTo(p.surname) == 0 ? name.compareTo(p.name) : surname.compareTo(p.surname);
    }
}
