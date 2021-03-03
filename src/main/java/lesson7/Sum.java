package lesson7;

public class Sum {
    public Integer a;
    public Integer b;
    Sum(Integer a , Integer b){
        this.a = a;
        this.b = b;
    }

    public Integer summa(){
        return a + b;
    }

    public Integer diff(){
        return a - b;
    }

    public Integer sub(){
        return a*b;
    }

}
