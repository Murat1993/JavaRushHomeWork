package com.javarush.test.level06.lesson11.bonus02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String GrandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(GrandFatherName);

        String GrandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(GrandMotherName);

        String FatherName = reader.readLine();
        Cat catFather = new Cat(FatherName, catGrandFather, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);



        System.out.println(catGrandFather.toString());
        System.out.println(catGrandMother.toString());

        System.out.println(catFather.toString());
        System.out.println(catMother.toString());

        System.out.println(catSon.toString());
        System.out.println(catDaughter.toString());
    }

    public static class Cat
    {
        private String name;
        private Cat father;
        private Cat mother;



        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parent, Cat parent2)
        {
            this.name = name;
            this.father = parent;
            this.mother = parent2;
        }

        @Override
        public String toString()
        {
            if ((mother == null) && (father == null))
                return  "Cat name is " + name + ", no mother, no father";
            else if ((mother != null) && (father == null))
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else if ((mother == null) && (father != null))
                return "Cat name is " + name + ", no mother, father is " + father.name;
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;

        }
    }

}