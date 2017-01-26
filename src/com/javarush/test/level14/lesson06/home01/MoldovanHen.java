package com.javarush.test.level14.lesson06.home01;


class MoldovanHen extends Hen
{

    @Override
    int getCountOfEggsPerMonth()
    {
        return 30;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - Moldova. Я несу 30 яиц в месяц.";
    }
}
