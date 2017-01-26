package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human,
то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human murat = new Human();
        murat.name = "Murat";
        murat.sex = true;

        murat.father = new Human();
        murat.father.name = "Beken";
        murat.father.sex = true;
        murat.father.age = 50;

        murat.father.father = new Human();
        murat.father.father.name = "Riskul";
        murat.father.father.sex = true;
        murat.father.father.age = 75;

        murat.father.mother = new Human();
        murat.father.mother.name = "Asilkan";
        murat.father.mother.age = 70;
        murat.father.mother.sex = false;


        murat.mother = new Human();
        murat.mother.name = "Upa";
        murat.mother.age = 55;
        murat.mother.sex = false;

        murat.mother.father = new Human();
        murat.mother.father.name = "Someone";
        murat.mother.father.age = 100;
        murat.mother.father.sex = true;

        murat.mother.mother = new Human();
        murat.mother.mother.name = "And ...";
        murat.mother.mother.age = 100;
        murat.mother.mother.sex = false;

        Human oroz = new Human();
        oroz.name = "Oroz";
        oroz.sex = true;
        oroz.age = 9;

        oroz.father = new Human();
        oroz.father = murat.father;
        oroz.mother = new Human();
        oroz.mother = murat.mother;

        Human suymonkul = new Human();
        suymonkul.name = "Suymonkul";
        suymonkul.age = 15;
        suymonkul.sex = true;

        suymonkul.father = new Human();
        suymonkul.father = murat.father;
        suymonkul.mother = new Human();
        suymonkul.mother = murat.mother;

        System.out.println(murat.toString());
        System.out.println(murat.father.toString());
        System.out.println(murat.father.father.toString());
        System.out.println(murat.father.mother.toString());

        System.out.println(murat.mother.toString());
        System.out.println(murat.mother.mother.toString());
        System.out.println(murat.mother.father.toString());

        System.out.println(oroz.toString());
        System.out.println(oroz.father.father.toString());
        System.out.println(oroz.father.father.toString());

        System.out.println(suymonkul.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
