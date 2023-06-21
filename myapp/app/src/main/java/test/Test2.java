package test;

import test.p1.A;

public class Test2 {

  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100; //접근불가
    // obj.v2 = 200; //접근불가
    // obj.v3 = 300; //접근불가
    obj.v4 = 400;
    obj.m1();
  }

}
