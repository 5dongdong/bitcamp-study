package bitcamp.myapp.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadCrumbPrompt;

public class FooterListener implements ActionListener {

  @Override
  public void service(BreadCrumbPrompt prompt) {
    System.out.println("Copyright \u00a9 by 네클7기----------");
  }
}
