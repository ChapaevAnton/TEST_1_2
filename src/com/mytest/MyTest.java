package com.mytest;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        //region Задание 1 результат
        User tester = new User(7, new Vacancy("Developer"));
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());
        //первоначальный массив вакансии
        Vacancy[] vacancies = {item("Developer"), item("Engineer")};
        //список вакнасии на основе первоначального массива
        ArrayList<Vacancy> vacanciesBase = new ArrayList<>(Arrays.asList(vacancies));
        //дополнительные вакансии
        vacanciesBase.add(item("Programmer"));
        vacanciesBase.add(item("Сleaner"));
        //список кандидатов
        ArrayList<User> usersBase = new ArrayList<User>();
        //добавляем кандидата на соответсвующую вакансию
        usersBase.add(user(0, 0, vacanciesBase));
        usersBase.add(user(1, 10, vacanciesBase));
        usersBase.add(user(2, 1, vacanciesBase));
        usersBase.add(user(3, 2, vacanciesBase));
        //если вдруг нет вакансии в базе но надо временную создать не из  общего пула
        usersBase.add(user(4, item("temp_vacancy")));
        usersBase.add(new User(5, new Vacancy("temp_vacancy1")));
        //выводим базу кандидатов
        showConsole(usersBase);
        //endregion

        //region Задание 2 результат
        int[] price = {5, 100, 20, 66, 16};
        MyTask2 upData = new MyTask2();
        upData.showPrice(upData.decryptData(price, 30, 0, -1));
        //endregion
    }

    //region Задание 1
    private static Vacancy item(String nameVacancy) {
        return new Vacancy(nameVacancy);
    }

    private static User user(int idUser, int idVacancy, ArrayList<Vacancy> baseVacancy) {
        try {
            return new User(idUser, baseVacancy.get(idVacancy));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private static User user(int idUser, Vacancy nameVacancy) {
        return new User(idUser, nameVacancy);
    }

    private static void showConsole(ArrayList<User> usersBase) {

        for (int i = 0; i < usersBase.size(); i++) {
            if (usersBase.get(i) != null) {
                System.out.println(usersBase.get(i).getId());
                System.out.println(usersBase.get(i).getVacancy());
            } else
                System.out.println("Вакансии с индексом[" + i + "]\nне существует в базе, пользователь не создан...");
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
    //endregion
}
