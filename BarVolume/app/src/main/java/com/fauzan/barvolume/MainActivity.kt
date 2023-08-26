package com.fauzan.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etLength : EditText
    private lateinit var etWidth : EditText
    private lateinit var etHeight : EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLength = findViewById(R.id.et_length)
        etWidth = findViewById(R.id.et_width)
        etHeight = findViewById(R.id.et_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_calculate) {
            val length = etLength.text.toString().trim()
            val width = etWidth.text.toString().trim()
            val height = etHeight.text.toString().trim()
            val result = length.toDouble() * width.toDouble() * height.toDouble()
            tvResult.text = result.toString()
        }
    }
}