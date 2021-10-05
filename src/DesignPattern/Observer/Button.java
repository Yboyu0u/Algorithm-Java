package DesignPattern.Observer;

public class Button {
    private String name;
    private IButtonListener buttonListener;

    public Button(String name) {
        this.name = name;
    }

    public void addListener(IButtonListener buttonListener){
        this.buttonListener = buttonListener;
    }

    public void click(String message){
        buttonListener.ClickEvent(message);
    }
}
