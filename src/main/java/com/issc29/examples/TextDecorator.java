package com.issc29.examples;

public class TextDecorator {
    private String text;

    public TextDecorator(String text) {
        this.text = text;
    }

    public TextDecorator() {
        this("");
    }

    public String getText() {
        return text;
    }

    public void setText() {
        this.text = text;
    }

    public String doubleString(){
        return text + text;
    }

    public String pipe(){
        String[] parts = text.split("");
        text.replace("","|");

        return text.replace("","|");
    }

    public String upperCase(){
        return text.toUpperCase();
    }


}
