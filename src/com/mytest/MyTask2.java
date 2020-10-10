package com.mytest;

import org.jetbrains.annotations.Nullable;


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

        if (discount >= 1 && discount <= 99) {

            int[] newPrice = new int[readLength];
            int i, j;
            for (i = offset, j = 0; j < newPrice.length; i++, j++) {
                price[i] = (int) Math.floor(price[i] - ((price[i] * discount) / 100));
                newPrice[j] = price[i];
            }
            System.out.println("Прайс-лист обновлен успешно.\nЦены со скидкой:" + discount + "%");
            return newPrice;
        } else {
            System.out.println("Недопустимый размер скидки!\nПрайс-лист не обновлен! ");
            return price;
        }

    }


}
