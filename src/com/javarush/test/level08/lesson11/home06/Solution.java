package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandFather1 = new Human();
        Human grandFather2 = new Human();
        Human grandMother1 = new Human();
        Human grandMother2 = new Human();

        Human child1 = new Human();
        child1.name = "Murat";
        child1.age = 22;
        child1.sex = true;


        Human child2 = new Human();
        child2.name = "Suymonkul";
        child2.age = 12;
        child2.sex = true;

        Human father = new Human();
        father.sex = true;
        father.name = "Beken";
        father.age = 45;
        father.children.add(child1);


        Human mother = new Human();



        Human child3 = new Human();

        father.children.add(child2);
        father.children.add(child3);

        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        grandFather1.children.add(father);
        grandFather1.children.add(mother);

        grandFather2.children.add(father);
        grandFather2.children.add(mother);

        grandMother1.children.add(father);
        grandMother1.children.add(mother);

        grandMother2.children.add(father);
        grandMother2.children.add(mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
