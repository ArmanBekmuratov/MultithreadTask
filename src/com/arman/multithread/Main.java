package com.arman.multithread;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread a = new Thread(() -> call(foo::first, "first"));
        Thread b = new Thread(() -> call(foo::second, "second"));
        Thread c = new Thread(() -> call(foo::third, "third"));

        a.start();
        c.start();
        b.start();
    }

    private static void call(FooMethod fooMethod, String text) {
        try {
            fooMethod.call(()-> System.out.print(text));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
