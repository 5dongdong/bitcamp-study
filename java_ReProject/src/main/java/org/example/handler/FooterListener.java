package org.example.handler;


import org.example.util.ActionListener;
import org.example.util.BreadCrumbPrompt;

public class FooterListener implements ActionListener {

  @Override
  public void service(BreadCrumbPrompt prompt) {
    System.out.println("Copyright \u00a9 by 네클7기----------");
  }
}
