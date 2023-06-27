package util.Menu;


import util.ActionListener;
import util.ArrayList;
import util.Prompt;

public class Menu {

    private String title;

    private ArrayList listeners = new ArrayList();


    public Menu(String title) {
        this.title = title;
    }

    public Menu(String title, ActionListener listener) {
        this(title);
        addActionListener(listener);
    }

    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }


    public void execute(Prompt prompt) {
        for(int i = 0; i < listeners.size(); i++) {
            ActionListener listener = (ActionListener)  listeners.get(i);
            listener.service(prompt);
        }
    }







}
