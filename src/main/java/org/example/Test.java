package org.example;

import org.example.annotations.Save;

import java.util.Objects;

public class Test {
    @Save
    private int a;
    @Save
    private boolean b;
    private char c;
    private long d;
    @Save
    private double e;

    public Test(int a, boolean b, char c, long d, double e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public Test() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public long getD() {
        return d;
    }

    public void setD(long d) {
        this.d = d;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return a == test.a && b == test.b && c == test.c && d == test.d && Double.compare(test.e, e) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, e);
    }
}
