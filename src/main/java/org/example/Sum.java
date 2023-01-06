package org.example;

import org.example.annotations.PareOfTwoInt;

public class Sum {
    @PareOfTwoInt(param1 = 6, param2 = 2)
    public void sumTwoInt(int a, int b){
        System.out.println("a + b = " + (a+b));
    }
}
