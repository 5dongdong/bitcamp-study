package client.bitcamp.myapp.handler;


import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;

public class HeaderListener implements ActionListener {
  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("=============================[비트캠프!]==");
  }
}
