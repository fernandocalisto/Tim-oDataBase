package calistofernando.model;

import java.time.LocalDate;

public class Player {

    private String name;
    private LocalDate birth_date;
    private String position;

    public Player() {
    }

    public Player(String name, LocalDate birth_date, String position) {
        this.name = name;
        this.birth_date = birth_date;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        // Formata a data para o padrão brasileiro
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format(
                "--------------------------------------\n" +
                        " ATLETA: %-20s \n" +
                        " NASCIMENTO: %-10s \n" +
                        " POSIÇÃO: %-15s \n" +
                        "--------------------------------------",
                name.toUpperCase(),
                birth_date.format(dtf),
                position
        );
    }
}
