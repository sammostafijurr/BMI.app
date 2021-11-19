package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bmi_button.setOnClickListener {
            if (w_text_edit.text.isNotEmpty() && h_text_edit.text.isNotEmpty()) {
               calcultedbmi()
            } else{
                Toast.makeText(this, "enter the needed field", Toast.LENGTH_SHORT).show()
            }
        }
    }
private fun calcultedbmi(){

    val weight = w_text_edit.text.toString().toFloat()
    val height = h_text_edit.text.toString().toFloat()
    val myBMI = weight / (height * height)
    show_ans.text = myBMI.toString()
        if (myBMI < 18.5) {
            image_view.setImageResource(R.drawable.underweight)
        } else if (myBMI >= 5 && myBMI < 24.9) {
            image_view.setImageResource(R.drawable.healthy)
        } else if (myBMI >= 24.9 && myBMI < 29.9) {
            image_view.setImageResource(R.drawable.overweight)
        } else if (myBMI >= 29.9) {
            image_view.setImageResource(R.drawable.obesity)
        }
}
}
