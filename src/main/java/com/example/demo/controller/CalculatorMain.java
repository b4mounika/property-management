package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorMain {
public static void main(String[] args) {
    CalculatorController cc = new CalculatorController();
 Double  result = cc.add(6.5,4.5,5.7);

    log.info("the result is {}",String.valueOf(result));

}

}
