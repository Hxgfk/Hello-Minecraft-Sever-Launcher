package com.hxgfk.main;

import com.hxgfk.util.interfaces.Running;

public class Init {
    private final Running main;

    public Init(Running main){
        this.main = main;
    }

    public void init(){
        new Checker(this.main, new Creator());
    }
}
