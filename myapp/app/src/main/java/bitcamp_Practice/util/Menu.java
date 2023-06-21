package bitcamp_Practice.util;

public class Menu {

  private String title;
  private ArrayList listeners = new ArrayList();

  public Menu(String title) {
    this.title = title;
  }

  public Menu(String title, ActionListener listner) {
    this(title);
    this.addActionbListner(listner);
  }

  public void addActionbListner(ActionListener listener) {
    listeners.add(listener);
  }

  public void removeActionListener(ActionListener listener) {
    listeners.remove(listener);
  }

  public String getTitle() {
    return title;
  }

  public void execute(BreadCrumbPrompt prompt) {
    for (int i = 0; i < listeners.size(); i++) {
      ActionListener listener = (ActionListener) listeners.get(i);
      listener.service(prompt);
    }
  }
}
