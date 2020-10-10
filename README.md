# TEST_1_2
test task 1 and 2 by Anton Smerdin
***
### Задача 1. 

>Есть кусочек кода. Его создатель хотел получить следующий вывод в консоль:

>*7*
>*Developer*

>Почему данная реализация не обеспечивает желаемого? Доработайте код.

```java
public static void main(String[] args) {
 User tester = new User(7,“Developer”);
 System.out.println(tester.getId());
 System.out.println(tester.getVacancy());
 }
 class User {
 private long id;
 private Vacancy vacancy;
 String getVacancy() {
 return vacancy.getVacancy();
 }
 long getId() {
 return id;
 }
 }
 class Vacancy {
 String getVacancy() {
 return "engineer";
 }
 }
```

### Задача 2.
>Написать полную реализацию
```java
/**
 * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции
offset
 * на количество позиций readLength. Новые цены округляем “вниз”,
 * до меньшего целого числа.
 * @param price - исходные цены.
 * @param discount - % скидки, от 1 до 99.
 * @param offset - номер позиции, с которой нужно применить скидку.
 * @param readLength - количество позиций, к которым нужно применить скидку.
 * @return - массив новых цен.
 */
public @Nullable int[] decryptData(@NonNull int[] price,
@IntRange(from = 1) int discount,
@IntRange(from = 0) int offset,
@IntRange(from = 1) int readLength) {
//TODO реализовать метод
}
```
>Пример
Входные данные
price = [5,100,20,66,16]
discount = 50
offset = 1
readLength = 3

>Ожидаемый результат работы
[50,10,33]
