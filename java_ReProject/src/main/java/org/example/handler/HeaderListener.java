package org.example.handler;


import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;

public class HeaderListener implements ActionListener {

  @Override
  public void service(BreadCrumbPrompt prompt) {
    System.out.println("===========================================[비트캠프!]====");
  }
}
