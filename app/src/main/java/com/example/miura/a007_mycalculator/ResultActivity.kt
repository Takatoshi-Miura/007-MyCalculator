package com.example.miura.a007_mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //MainActivityからの値の受け取り
        val bundle: Bundle = intent.extras!!
        val numberOfLeft: Int = bundle.getInt("numberOfLeft")
        val numberOfRight: Int = bundle.getInt("numberOfRight")
        val markOfCalc: String? = bundle.getString("markOfCenter")

        //受け取った値を使用して計算
        val result : Int = when(markOfCalc){
            "+" -> numberOfLeft + numberOfRight
            "-" -> numberOfLeft - numberOfRight
            "×" -> numberOfLeft * numberOfRight
            "÷" ->  //0での除算はできないため、臨時で0を返す
                    if (numberOfRight == 0) {
                        0
                    } else {
                        numberOfLeft / numberOfRight
                    }
            else -> 0
        }

        //計算結果をテキストビューに表示
        //0での除算はできない旨を表示
        if (markOfCalc == "÷" && numberOfRight == 0) {
            textViewResult.text = "計算できません"
        } else {
            textViewResult.text = result.toString()
        }

        
        //「戻る」ボタンをタップで前画面に戻る
        buttonBack.setOnClickListener{
            finish()
        }
    }
}
