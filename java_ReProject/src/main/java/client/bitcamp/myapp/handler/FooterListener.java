package client.bitcamp.myapp.handler;


import client.bitcamp.util.ActionListener;
import client.bitcamp.util.BreadcrumbPrompt;

public class FooterListener implements ActionListener {
  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("Copyright \u00a9 by 네클7기----------------------------");
  }
}
