package com.mytest;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RefreshPrices {

    private final static Logger logger = Logger.getLogger(RefreshPrices.class.getName());

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
        int[] newPrice = new int[0];
        if (discount < 1 || discount > 99) {
            logger.log(Level.WARNING,"The parameter <discount> value must be in the range from 1 to 99.");
            return newPrice;
        } else if (readLength == 0) {
            logger.log(Level.WARNING,"The parameter <readLength> value must not be null.");
            return newPrice;
        } else {
            int i, j;
            try {
                newPrice = new int[readLength];
                for (i = offset, j = 0; j < newPrice.length; i++, j++) {
                    price[i] = (int) Math.floor(price[i] - ((price[i] * discount) / 100));
                    newPrice[j] = price[i];
                }
            } catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException err) {
                logger.log(Level.WARNING, err.getMessage(), err);
                return newPrice;
            }
            logger.log(Level.INFO, "A new array of prices has been generated successfully.");
            return newPrice;
        }

    }

    public void showPrice(int[] price) {
        System.out.print("result:" + Arrays.toString(price));
    }

}

