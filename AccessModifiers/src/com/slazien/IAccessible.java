package com.slazien;

interface IAccessible { // package-private
    int SOME_CONSTANT = 100; // all vars in interface are public static final
    public void methodA(); // public
    void methodB(); // public, since all interface methods are public
    boolean methodC(); // public, same as above
}
