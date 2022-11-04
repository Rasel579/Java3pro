package lesson1_generics;

import java.util.ArrayList;
import java.util.Collection;

public class Box<E extends Fruit> {
    private ArrayList <E> fruits = new ArrayList<>(this.getCapacity());
    private int capacity;
    Box(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(E fruits){
        if (this.fruits.size() < capacity && !this.fruits.contains(fruits)) {
            this.fruits.add(fruits);
        }
    }

    public void show(){
        System.out.println(this.fruits);
    }

    public float getWeight(){
        float weight = 0.0f;
        for (E fruit : fruits) {
            weight+= fruit.getWeight();
        }
        System.out.println(weight);
        return weight;
    }

    public boolean compare(Box<?> box){
      return Math.abs(this.getWeight() - box.getWeight()) < 0.001;
    };

    public ArrayList<E> getFruits() {
        return fruits;
    }

    public void remove (E fruit){
        this.fruits.remove(fruit);
    }

    public void getOut(Box<E> box){
        int size = box.getCapacity();
        for (E fruit : fruits) {
              if (size > 0) {
                  box.getFruits().add(fruit);
                  size--;
              }
            }
        for (E fruit : box.getFruits()) {
            this.remove(fruit);
            }
        }
    }
