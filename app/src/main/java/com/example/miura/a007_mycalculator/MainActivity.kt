package com.example.miura.a007_mycalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //OnClickメゾットの生成
        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        buttonTasu.setOnClickListener(this)
        buttonHiku.setOnClickListener(this)
        buttonKakeru.setOnClickListener(this)
        buttonWaru.setOnClickListener(this)

        //「=」ボタンを押した時の処理
        buttonResult.setOnClickListener {
            val numberOfLeft: Int = textViewLeft.text.toString().toInt()
            val numberOfRight: Int = textViewRight.text.toString().toInt()
            val markOfCenter: String? = textViewCenter.text.toString()

            textViewLeft.text = ""
            textViewRight.text = ""
            textViewCenter.text = ""

            //画面推移＆値の受け渡し
            val intent = Intent(this@MainActivity,ResultActivity::class.java)
            intent.putExtra("numberOfLeft",numberOfLeft)
            intent.putExtra("numberOfRight",numberOfRight)
            intent.putExtra("markOfCenter",markOfCenter)
            startActivity(intent)
        }
    }

    //ボタンをタップした時の処理
    override fun onClick(v: View?) {

        val button: Button = v as Button

        when (v?.id) {
            R.id.buttonClear
            -> {
                    textViewLeft.text = ""
                    textViewRight.text = ""
                    textViewCenter.text = ""
                }

            R.id.buttonMinus
            -> if (textViewCenter.text.toString() == "") {
                    if (textViewLeft.text.toString() == "") {
                        textViewLeft.text = button.text
                    }
                } else {
                    if (textViewRight.text.toString() == "") {
                        textViewRight.text = button.text
                    }
                }

            R.id.buttonTasu
            -> if (textViewLeft.text.toString() != "") {
                    textViewCenter.text = "+"
                }

            R.id.buttonHiku
            -> if (textViewLeft.text.toString() != "") {
                    textViewCenter.text = "-"
                }

            R.id.buttonKakeru
            -> if (textViewLeft.text.toString() != "") {
                    textViewCenter.text = "×"
                }

            R.id.buttonWaru
            -> if (textViewLeft.text.toString() != "") {
                    textViewCenter.text = "÷"
                }

            R.id.button0
            ->  //テキストビュー(中央)に入力が無く、テキストビュー(左)に０やマイナス以外の入力がある場合
                if (textViewCenter.text.toString() == "") {
                    if (textViewLeft.text.toString() != "0" && textViewLeft.text.toString() != "-") {
                        textViewLeft.append(button.text)
                    }
                } else {
                    //テキストビュー(中央)に入力が有り、テキストビュー(右)に０やマイナス以外の入力がある場合
                    if (textViewRight.text.toString() != "0" && textViewRight.text.toString() != "-") {
                        textViewRight.append(button.text)
                    }
                }

            //その他のボタンの処理
            else
            -> if (textViewCenter.text.toString() == "") {
                    if (textViewLeft.text.toString() == "0") {
                        textViewLeft.text = button.text
                    } else {
                        textViewLeft.append(button.text)
                    }
                } else {
                    if (textViewRight.text.toString() == "0") {
                        textViewRight.text = button.text
                    } else {
                        textViewRight.append(button.text)
                    }
                }

        }
    }


}
