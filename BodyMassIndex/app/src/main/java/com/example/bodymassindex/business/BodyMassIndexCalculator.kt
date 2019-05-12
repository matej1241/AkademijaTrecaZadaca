package com.example.bodymassindex.business

class BodyMassIndexCalculator {
    fun calculateBmi(height: Float, weight: Float):Float{
        return weight/(height*height)
    }
}