package app;

import app.tasks.*;


public class App {


    public static void main(String[] args) {

        Tasks tasks = new Tasks();
        System.out.println(tasks.isUnique("bd"));
    }

}


