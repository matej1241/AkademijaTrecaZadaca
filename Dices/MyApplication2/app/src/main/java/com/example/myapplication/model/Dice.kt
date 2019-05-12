package com.example.myapplication.model

class Dice {

    companion object{
        var diceCounter = 2
    }

    var isFixed: Boolean = false

    fun rollDice():Int {
        return (1..6).shuffled().first()
    }
}

