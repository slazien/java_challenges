package com.slazien;

public class Main {

    public static void main(String[] args) {
        String varFour = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        System.out.println("varThree is not accessible here " + innerClass.varThree);
//        System.out.println("scopeInstance var1 is " + scopeInstance.getVarOne());
//        System.out.println(varFour);
//
//        scopeInstance.timesTwo();
//        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        innerClass.timesTwo();
    }
}
