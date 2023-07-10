package org.example.handler;


import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;

public class HelloListener implements ActionListener {

  @Override
  public void service(BreadCrumbPrompt prompt) {
    String name = prompt.inputString("이름은?");
    System.out.printf("%s 님 반가워요!\n", name);
  }
}
