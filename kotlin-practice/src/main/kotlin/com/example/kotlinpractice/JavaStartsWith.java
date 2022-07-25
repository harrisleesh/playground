package com.example.kotlinpractice;

public class JavaStartsWith {


    boolean startsWithA1(String str){
        if (str == null) {
            throw new IllegalArgumentException("null이 들어왔습니다.");
        }
        return str.startsWith("A");
    }

    Boolean startsWithA2(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("A");
    }

    boolean startsWithA3(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("A");
    }
}
