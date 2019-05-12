package com.example.bodymassindex.ui.bodyMassResult

import android.widget.ImageView
import com.example.bodymassindex.R
import com.example.bodymassindex.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_body_mass_result.*

class BodyMassResultActivity : BaseActivity() {

    companion object{
        const val INTENT_KEY = "result"
        const val DEFAULT_VALUE = 0.0f
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_body_mass_result
    }

    override fun setUpUi() {
        val intentResult = intent.getFloatExtra(INTENT_KEY, DEFAULT_VALUE)
        when{
            intentResult < 18.5 -> {
                bmiPicture.setImageResource(R.drawable.underweight)
                bmiResult.text = getString(R.string.underWeightTitle)
                bmiDescription.text = getString(R.string.underWeightDescription)
            }
            intentResult > 18.5 && intentResult < 25.0 -> {
                bmiPicture.setImageResource(R.drawable.healthy)
                bmiResult.text = getString(R.string.healthyWeightTitle)
                bmiDescription.text = getString(R.string.healthyWeightDescription)
            }
            intentResult > 25.0 && intentResult < 30.0 -> {
                bmiPicture.setImageResource(R.drawable.overweight)
                bmiResult.text = getString(R.string.overWeightTitle)
                bmiDescription.text = getString(R.string.overWeightDescription)
            }
            intentResult > 30.0 -> {
                bmiPicture.setImageResource(R.drawable.obese)
                bmiResult.text = getString(R.string.obeseTitle)
                bmiDescription.text = getString(R.string.obeseDescription)
            }
        }
    }

}
