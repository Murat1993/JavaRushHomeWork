package com.javarush.test.level14.lesson06.home01;


class RussianHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 10;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - Russia. Я несу 10 яиц в месяц.";
    }
}
