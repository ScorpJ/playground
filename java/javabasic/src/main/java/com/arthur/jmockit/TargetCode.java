package com.arthur.jmockit;

public class TargetCode {

    public Dependency getDependency() {
        return dependency;
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    private Dependency dependency;



    public int doSomeThing(){
        return dependency.doSomeThing();
    }

}
