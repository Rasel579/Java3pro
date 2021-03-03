package lesson7;

public class EqualTest {
    @BeforeSuite
    public  Sum  generate(){
        return new Sum(2,3);
    }



    @Test (priority = 0)
    public void testSum(){
        System.out.println(EqualTest.equals(5, generate().summa()));
    }

    @Test(priority = 4)
    public void testDiff(){
        System.out.println(EqualTest.equals(0, generate().diff()));
    }
    @Test(priority = 3)
    public  void testSub(){
        System.out.println(EqualTest.equals(6,generate().sub()));
    }


    public static boolean equals(Object expected, Object actual ){
        if (expected.equals(actual)){
            return true;
        } else return false;
    }
}