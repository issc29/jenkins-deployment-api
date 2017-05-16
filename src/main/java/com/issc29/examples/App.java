package com.issc29.examples;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TextDecorator a = new TextDecorator("Hello World");
        System.out.println(a.doubleString());
        System.out.println(a.pipe());
        System.out.println(a.getText());
        System.out.println(a.upperCase());
    }
}
