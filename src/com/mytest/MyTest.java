package com.mytest;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        //задание 1

        Vacancy[] vacancies = {new Vacancy("Developer"), new Vacancy("Engineer")};
        ArrayList<Vacancy> vacanciesBase = new ArrayList<>(Arrays.asList(vacancies));
        vacanciesBase.add(new Vacancy("Programmer"));
        vacanciesBase.add(new Vacancy("Сleaner"));

        ArrayList<User> usersBase = new ArrayList<User>();

        usersBase.add(new User(1, vacanciesBase.get(0)));
        usersBase.add(new User(2, vacanciesBase.get(3)));
        usersBase.add(new User(3, vacanciesBase.get(1)));

        showConsole(usersBase);

    }

    private static void showConsole(ArrayList<User> usersBase) {
        for (int i = 0; i < usersBase.size(); i++) {
            System.out.println(usersBase.get(i).getId());
            System.out.println(usersBase.get(i).getVacancy());
        }
    }

    static class User {
        private long id;
        private Vacancy vacancy;

        User(long id, Vacancy vacancy) {
            this.vacancy = vacancy;
            this.id = id;
        }

        String getVacancy() {
            return vacancy.getVacancy();
        }

        long getId() {
            return id;
        }
    }

    static class Vacancy {
        String nameVacancy;

        Vacancy(String nameVacancy) {
            this.nameVacancy = nameVacancy;
        }

        String getVacancy() {
            return nameVacancy;
        }
    }
}
