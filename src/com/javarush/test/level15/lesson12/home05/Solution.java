package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так,
   чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    protected Solution(boolean b) {

    }
    protected Solution(short s) {

    }
    protected Solution(double s) {

    }

    private Solution(float f) {

    }
    private Solution(int i, float f) {

    }
    private Solution(int i, String s) {

    }

    public Solution() {

    }
    public Solution(int i) {

    }
    public Solution(String s) {

    }

    Solution(int i, int j) {

    }

    Solution(double d, double j) {

    }

    Solution(String s, int j) {

    }
}

