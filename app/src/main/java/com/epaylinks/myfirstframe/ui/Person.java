package com.epaylinks.myfirstframe.ui;

/**
 * Created by Administrator on 2016/11/11.
 */

public class Person {
    private String name;
    private int age;
    private String[] coures=new String[3];

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        for (int i = 0; i < 3; i++) {
            coures[i]="课程："+i;
        }
        setCoures(coures);
    }

    public String[] getCoures() {
        return coures;
    }

    public void setCoures(String[] coures) {
        this.coures = coures;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
