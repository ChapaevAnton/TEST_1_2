package com.mytest;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        //задание 1

        Vacancy[] vacancies = {item("Developer"), item("Engineer")};
        ArrayList<Vacancy> vacanciesBase = new ArrayList<>(Arrays.asList(vacancies));
        vacanciesBase.add(item("Programmer"));
        vacanciesBase.add(item("Сleaner"));

        ArrayList<User> usersBase = new ArrayList<User>();

        usersBase.add(user(1, 0, vacanciesBase));
        usersBase.add(user(2, 10, vacanciesBase));
        usersBase.add(user(3, 1, vacanciesBase));
        usersBase.add(user(4, 2, vacanciesBase));

        showConsole(usersBase);

    }

    private static Vacancy item(String nameVacancy) {
        return new Vacancy(nameVacancy);
    }

    private static User user(int id, int idVacancy, ArrayList<Vacancy> baseVacancy) {
        try {
            return new User(id, baseVacancy.get(idVacancy));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private static void showConsole(ArrayList<User> usersBase) {

        for (int i = 0; i < usersBase.size(); i++) {
            if (usersBase.get(i) != null) {
                System.out.println(usersBase.get(i).getId());
                System.out.println(usersBase.get(i).getVacancy());
            } else System.out.println("Такой вакансии не существует");
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
