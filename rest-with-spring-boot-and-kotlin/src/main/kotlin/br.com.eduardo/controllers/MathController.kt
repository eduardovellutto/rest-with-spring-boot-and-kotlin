package br.com.eduardo.controllers

import br.com.eduardo.Converters.NumberConverter
import br.com.eduardo.exceptions.UnsuportedMathOperationException
import br.com.eduardo.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsuportedMathOperationException("Please set a numeric value")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsuportedMathOperationException("Please set a numeric value")
        return if (NumberConverter.convertToDouble(numberOne) >= NumberConverter.convertToDouble(numberTwo)) {
            math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
        } else {
            math.subtraction(NumberConverter.convertToDouble(numberTwo), NumberConverter.convertToDouble(numberOne))
        }
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsuportedMathOperationException("Please set a numeric value")
        return math.multiplication(
            NumberConverter.convertToDouble(numberOne),
            NumberConverter.convertToDouble(numberTwo)
        )
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsuportedMathOperationException("Please set a numeric value")
        return if (NumberConverter.convertToDouble(numberOne) <= NumberConverter.convertToDouble(numberTwo)) {
            math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
        } else {
            math.division(NumberConverter.convertToDouble(numberTwo), NumberConverter.convertToDouble(numberOne))
        }
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsuportedMathOperationException("Please set a numeric value")
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/squareRoot/{numberOne}"])
    fun squareRoot(
        @PathVariable(value = "number") number: String?
    ): Double {
        if (!NumberConverter.isNumeric(number))
            throw UnsuportedMathOperationException("Please set a numeric value")
        return math.squareRoot(NumberConverter.convertToDouble(number))
    }


}