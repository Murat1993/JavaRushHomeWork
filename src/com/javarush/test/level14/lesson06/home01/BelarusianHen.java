package com.javarush.test.level14.lesson06.home01;


class BelarusianHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 40;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - Belarus. Я несу 40 яиц в месяц.";
    }
}
