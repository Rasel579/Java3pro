package lesson7;

import java.lang.reflect.InvocationTargetException;

public class Main {


    //Создать класс, который может выполнять «тесты».
    //В качестве тестов выступают классы с наборами методов,
    // снабженных аннотациями @Test. Класс, запускающий тесты,
    // должен иметь статический метод start(Class testClass),
    // которому в качестве аргумента передается объект типа Class.
    // Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite,
    // если он присутствует. Далее запускаются методы с аннотациями @Test,
    // а по завершении всех тестов – метод с аннотацией @AfterSuite.
    //К каждому тесту необходимо добавить приоритеты (int-числа от 1 до 10),
    // в соответствии с которыми будет выбираться порядок их выполнения.
    // Если приоритет одинаковый, то порядок не имеет значения.
    // Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
    // в единственном экземпляре. Если это не так –
    // необходимо бросить RuntimeException при запуске «тестирования».
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestClass.start(EqualTest.class);
    }
}
