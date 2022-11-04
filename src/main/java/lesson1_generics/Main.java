package lesson1_generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    private static <T> void replace(T[] arr, int i, int j) {
        T temp =  arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }

    private static <T> ArrayList<T> convertToArrayList(T [] arr1) {
         ArrayList<T> arr = new ArrayList<T>(Arrays.asList(arr1));
         return arr;
    }

    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        Number[] arr1 = new Number[]{1.0f ,2.0f, 4.0f, 5.0f};
        for (Object integer : arr1) {
            System.out.print(integer + " ");
        }
        replace(arr1, 2, 3);
        System.out.println();
        for (Object integer : arr1) {
            System.out.print(integer + " ");
        }
        //2. Написать метод, который преобразует массив в ArrayList;
         ArrayList arrayList = convertToArrayList(arr1);
          System.out.println(arrayList + " " + arrayList.getClass());

        //3. Большая задача:
        //Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
        //Класс Box, в который можно складывать фрукты. Коробки условно
        // сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        //Для хранения фруктов внутри коробки можно использовать ArrayList;
        //Сделать метод getWeight(), который высчитывает вес коробки,
        // зная количество фруктов и вес одного фрукта
        // (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
        //Внутри класса Коробка сделать метод compare,
        // который позволяет сравнить текущую коробку с той, которую подадут
        // в compare в качестве параметра, true – если она равны по весу,
        // false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        //Написать метод, который позволяет пересыпать фрукты из текущей
        // коробки в другую (помним про сортировку фруктов: нельзя яблоки
        // высыпать в коробку с апельсинами). Соответственно, в текущей коробке фруктов
        // не остается, а в другую перекидываются объекты, которые были в этой коробке;
        //Не забываем про метод добавления фрукта в коробку.

        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Orange orange = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Apple> boxApple = new Box<>(5);
        Box<Apple> newBoxApple = new Box<>(3);
        Box<Orange> newBoxOrange = new Box<>(3);
        Box<Orange> orangeBox = new Box<>(5);
        boxApple.add(apple);
        boxApple.add(apple1);
        boxApple.add(apple2);
        boxApple.add(apple3);
        boxApple.add(apple4);
        orangeBox.add(orange);
        orangeBox.add(orange1);
        orangeBox.add(orange2);
        boxApple.show();
        orangeBox.show();
        boxApple.getWeight();
        orangeBox.getWeight();
        System.out.println(boxApple.compare(orangeBox));
        boxApple.getOut(newBoxApple);
        boxApple.show();
        newBoxApple.show();

    }

}
