package bitcamp.myapp.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadCrumbPrompt;

public class HeaderListener implements ActionListener {

  @Override
  public void service(BreadCrumbPrompt prompt) {
    System.out.println("===========================================[비트캠프!]====");
  }
}
