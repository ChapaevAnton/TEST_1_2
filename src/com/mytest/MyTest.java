package com.mytest;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        //задание 1
        User tester = new User(7, "Developer");
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());


        //задание 2 прайс лист и скидки
        int[] price = {5, 100, 20, 66, 16};

        MyTask2 tester1 = new MyTask2();
        price = tester1.decryptData(price, 50, 1, 3);

        String newPrice = Arrays.toString(price);

        System.out.print(newPrice);

    }

    static class User {
        private long id;
        private String str;
        //private Vacancy vacancy;

        User(long id, String str) {
            this.str = str;
            this.id = id;
        }

        String getVacancy() {
            return Vacancy.getVacancy(str);
        }

        long getId() {
            return id;
        }
    }

    static class Vacancy {
        static String getVacancy(String str) {
            return str;
        }
    }
}
