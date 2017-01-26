package com.javarush.test.level14.lesson06.home01;


class UkrainianHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 20;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - Ukraine. Я несу 20 яиц в месяц.";
    }

}
