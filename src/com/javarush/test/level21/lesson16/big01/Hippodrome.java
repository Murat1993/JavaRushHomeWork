package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    private ArrayList<Horse> horses = new ArrayList<>();

    public void move()
    {

        for (Horse horse : horses)
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
    }

    public void run()
    {

        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    public Horse getWinner() {
        double maxDistance = 0;
        for (Horse horse : horses)
            if (horse.getDistance() > maxDistance)
                maxDistance = horse.getDistance();

        for (Horse horse : horses)
            if (horse.getDistance() == maxDistance)
                return horse;

        return null;
    }

    public void printWinner() {
        double maxDistance = 0;
        for (Horse horse : horses)
            if (horse.getDistance() > maxDistance)
                maxDistance = horse.getDistance();

        for (Horse horse : horses)
            if (horse.getDistance() == maxDistance)
                System.out.println("Winner is " + horse.getName() + "!");
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();

        Horse horse1 = new Horse("first", 3, 0);
        Horse horse2 = new Horse("second", 3, 0);
        Horse horse3 = new Horse("third", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}
