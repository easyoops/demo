package com.example.demo.common.utils;

import java.time.LocalDate;

/**
 * GO:
 * Created By JiWei.Chen 2019-01-02
 */
public class T implements Comparable<T> {
    private int name;
    private int age;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T(int name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "T{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
    /*    List<T> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            list.add(new T(i, random.nextInt(100)));
        }
        Collections.sort(list);
        list.forEach(t -> {
            System.out.println(t.toString());
        });*/
        LocalDate localDate = LocalDate.of(2018,9,1);
        System.out.println(localDate.getMonthValue());
    }

    @Override
    public int compareTo(T o) {
        int i = this.getAge() - o.getAge();
        System.out.println("this.getAge():" + this.getAge() + ",o.getAge():" + o.getAge() + ",cha:" + i);
        return -i;
    }
}
