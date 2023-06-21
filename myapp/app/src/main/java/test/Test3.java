package test;

import test.p1.A;

public class Test3 extends A {

  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100; //접근 불가
    // obj.v2 = 200; //접근 불가
    // obj.v3 = 300; //접근 불가 <== 상속 받은 멤버가 아니다!
    obj.v4 = 400;
    // obj.m1(); // 접근 불가! <== 상속 받은 멤버가 아니다!

    m2(); // static 메소드

    Test3 obj2 = new Test3();
    obj2.m3(); // nonstatic 메소드
    // obj2.v1 = 100; // 접근 불가
    // obj2.v2 = 200; // 접근 불가
    obj2.v3 = 300; // 이친구는 Test3 obj2를 선언 ==> 상속받았음 그래서 위쪽 obj.v3와 다르게 가능하다
    obj2.v4 = 400; // public
    obj2.m1(); // 자식 클래스가 상속 받아서 사용하는 멤버!
  }

  static void m2() {

  }

  void m3() {

  }

}
