package com.issc29.examples;

import junit.framework.TestCase;

/**
 * Created by issc29 on 5/15/17.
 */
public class TextDecoratorTest extends TestCase {
    public void testGetText() throws Exception {
        TextDecorator str = new TextDecorator("Hello World");
        assertEquals(str.getText(), "Hello World");
    }

    public void testDoubleString() throws Exception {
        TextDecorator str = new TextDecorator("Hello World");
        assertEquals(str.doubleString(), "Hello WorldHello World");
    }

    public void testPipe() throws Exception {
        TextDecorator str = new TextDecorator("Hello World");
        assertEquals(str.pipe(), "|H|e|l|l|o| |W|o|r|l|d|");
    }

    public void testUpperCase() throws Exception {
        TextDecorator str = new TextDecorator("Hello World");
        assertEquals(str.upperCase(), "HELLO WORLD");
    }

}