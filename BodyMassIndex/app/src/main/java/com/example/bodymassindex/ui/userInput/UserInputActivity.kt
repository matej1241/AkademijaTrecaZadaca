package com.example.bodymassindex.ui.userInput

import android.content.Intent
import android.text.TextUtils.isEmpty
import android.util.Log
import com.example.bodymassindex.ui.bodyMassResult.BodyMassResultActivity
import com.example.bodymassindex.R
import com.example.bodymassindex.business.BodyMassIndexCalculator
import com.example.bodymassindex.common.displayToast
import com.example.bodymassindex.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_user_input.*

class UserInputActivity : BaseActivity() {

    companion object{
        const val MAX_HEIGHT = 2.5
        const val MAX_WEIGHT = 350
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_user_input
    }

    override fun setUpUi() {
        calculateBmi.setOnClickListener { calculate() }
    }

    private fun calculate() {
        if(isInputEmpty()){
            displayToast(getString(R.string.invalidInput))
            return
        }
        val height = heightInput.text.toString().toFloat()
        val weight = weightInput.text.toString().toFloat()
        Log.d("tag", weight.toString())
        Log.d("tag", height.toString())
        if (height <= MAX_HEIGHT && weight <= MAX_WEIGHT){
            val result = BodyMassIndexCalculator().calculateBmi(height, weight)
            Log.d("tag", result.toString())
            val intent = Intent(applicationContext, BodyMassResultActivity::class.java)
            intent.putExtra(BodyMassResultActivity.INTENT_KEY, result)
            startActivity(intent)
        } else{
            displayToast(getString(R.string.invalidInput))
            return
        }
    }

    private fun isInputEmpty(): Boolean = isEmpty(heightInput.text) || isEmpty(weightInput.text)

}
