package com.example.demo.controller;

public class CalculatorMain {
public static void main(String[] args) {
    CalculatorController cc = new CalculatorController();
    Double result = cc.add(6.5,4.5,5.7);
    System.out.println(result);
}

}
