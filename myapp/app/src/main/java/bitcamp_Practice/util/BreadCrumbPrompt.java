package bitcamp_Practice.util;


import bitcamp.util.Stack;

public class BreadCrumbPrompt extends Prompt {
  private Stack breadcrumbs = new Stack();

  public void appendBreadCrumb(String title) {
    breadcrumbs.push(title);
  }

  public void removeBreadCrumb() {
    breadcrumbs.pop();
  }

  public String inputMenu() {
    StringBuilder titleBuilder = new StringBuilder();
    for (int i = 0; i < breadcrumbs.size(); i++) {
      if (titleBuilder.length() > 0) {
        titleBuilder.append("/");
      }
      titleBuilder.append(breadcrumbs.get(i));
    }
    titleBuilder.append(">");
    return inputString(titleBuilder.toString());
  }
}
