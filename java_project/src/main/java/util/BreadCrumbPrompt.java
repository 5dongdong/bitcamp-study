package util;

import java.util.Stack;

public class BreadCrumbPrompt extends Prompt{

    private Stack breadCrumbs = new Stack();

    public void appendBreadCrumb(String title) {
        this.breadCrumbs.push(title);
    }

    public void removeBreadCrumb() {
        breadCrumbs.pop();
    }

    public String inputMenu() {
        StringBuilder titleBuilder = new StringBuilder();
        for(int i = 0; i < breadCrumbs.size(); i++) {
            if(titleBuilder.length() > 0) {
                titleBuilder.append("/");
            }
            titleBuilder.append(breadCrumbs.get(i));
        }
        titleBuilder.append(">");
        return inputString(titleBuilder.toString());
    }
}
