package com.mytest;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;


public class MyTask2 {
    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции
     * offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     *
     * @param price      - исходные цены.
     * @param discount   - % скидки, от 1 до 99.
     * @param offset     - номер позиции, с которой нужно применить скидку.
     * @param readLength - количество позиций, к которым нужно применить скидку.
     * @return - массив новых цен.
     */

    public @Nullable int[] decryptData(@NonNull int[] price,
                                       @IntRange(from = 1) int discount,
                                       @IntRange(from = 0) int offset,
                                       @IntRange(from = 1) int readLength) {
//TODO реализовать метод
        final int COUNT=price.length-1;
        final int COUNT_READ=offset+readLength-1;


        if (discount < 1 || discount > 99) {
            showInfo();
            return price;
        } else if (offset>COUNT||COUNT_READ>COUNT||readLength==0) {
            showInfo();
            return price;
        } else {
            int[] newPrice = new int[readLength]; //Exception in thread "main" java.lang.NegativeArraySizeException: -1
            int i, j;
            try {
                for (i = offset, j = 0; j < newPrice.length; i++, j++) {
                    price[i] = (int) Math.floor(price[i] - ((price[i] * discount) / 100));
                    newPrice[j] = price[i];
                }
            } catch (ArrayIndexOutOfBoundsException err) {
                showInfo(err.getMessage());
                return price;
            }
            showInfo(discount);
            return newPrice;
        }

    }


    public void showPrice(int[] price) {
        System.out.print(Arrays.toString(price));
    }

    private void showInfo() {
        System.out.println("Ошибка!\nПрайс-лист не обновлен!\nНекорректные входные параметры!");
    }

    private void showInfo(int discount) {
        System.out.println("Прайс-лист обновлен успешно.\nЦены со скидкой:" + discount + "%");
    }

    private void showInfo(String msg) {
        System.out.println("Ошибка!\nПрайс-лист не обновлен!\n" + msg);
    }

}

