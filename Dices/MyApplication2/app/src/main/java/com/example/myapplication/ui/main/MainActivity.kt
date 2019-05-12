package com.example.myapplication.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.R
import com.example.myapplication.common.displayToast
import com.example.myapplication.model.Dice
import com.example.myapplication.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    companion object{
        val diceOne = Dice()
        val diceTwo = Dice()
        val diceThree = Dice()
        val diceFour = Dice()
        val diceFive = Dice()
        val diceSix = Dice()
        var diceValue: Int = 0
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }
    
    override fun setUpUi() {
        rollDice.setOnClickListener { roll() }
        resetDice.setOnClickListener { reset() }
        diceOneImg.setOnClickListener { setDiceFixed(diceOne)}
        diceTwoImg.setOnClickListener { setDiceFixed(diceTwo)}
        diceThreeImg.setOnClickListener { setDiceFixed(diceThree)}
        diceFourImg.setOnClickListener { setDiceFixed(diceFour)}
        diceFiveImg.setOnClickListener { setDiceFixed(diceFive)}
        diceSixImg.setOnClickListener { setDiceFixed(diceSix)}
    }

    private fun roll() {
        if (Dice.diceCounter > 0) {
            if (!diceOne.isFixed) {
                diceValue = diceOne.rollDice()
                setDiceImage(diceValue, diceOneImg)
            }
            if (!diceTwo.isFixed) {
                diceValue = diceTwo.rollDice()
                setDiceImage(diceValue, diceTwoImg)
            }
            if (!diceThree.isFixed) {
                diceValue = diceThree.rollDice()
                setDiceImage(diceValue, diceThreeImg)
            }
            if (!diceFour.isFixed) {
                diceValue = diceFour.rollDice()
                setDiceImage(diceValue, diceFourImg)
            }
            if (!diceFive.isFixed) {
                diceValue = diceFive.rollDice()
                setDiceImage(diceValue, diceFiveImg)
            }
            if (!diceSix.isFixed) {
                diceValue = diceSix.rollDice()
                setDiceImage(diceValue, diceSixImg)
            }
            Dice.diceCounter--
        }else displayToast(getString(R.string.rollError))
    }

    private fun reset() {
        Dice.diceCounter = 2
    }

    private fun setDiceFixed(dice: Dice) {
        dice.isFixed = !dice.isFixed
    }

    private fun setDiceImage(rolledNumber: Int, dice: ImageView) {
        when(rolledNumber){
            1 -> dice.setImageResource(R.drawable.dice_1)
            2 -> dice.setImageResource(R.drawable.dice_2)
            3 -> dice.setImageResource(R.drawable.dice_3)
            4 -> dice.setImageResource(R.drawable.dice_4)
            5 -> dice.setImageResource(R.drawable.dice_5)
            6 -> dice.setImageResource(R.drawable.dice_6)
        }
    }

}
