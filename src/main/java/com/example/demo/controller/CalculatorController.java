package com.example.demo.controller;

import com.example.demo.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")//class level mapping of url to a controller class
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add
    //http://localhost:8080/api/v1/calculator/add?num111=6.6&num222=5.5
    @GetMapping("/add/{num3}")//method level mapping of url to a controller function
    public Double add( @RequestParam("num1") Double num1, @RequestParam("num2") Double num2,
                      @PathVariable("num3") Double num3) {

        return num1 + num2;
    }

    @GetMapping("/sub/{num111}/{num2}")//map the values of url to java variables by path variable method
    public Double subtract(@PathVariable("num111") Double num1, @PathVariable("num2") Double num2) {
        Double result = null;
        if (num1>num2) {
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }
        return result;

    }
    @PostMapping("/mul")
    public ResponseEntity<Double> mutiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result =null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}