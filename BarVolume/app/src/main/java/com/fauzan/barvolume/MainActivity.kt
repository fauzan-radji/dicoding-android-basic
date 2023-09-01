package com.fauzan.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.fauzan.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_calculate) {
            val length = binding.etLength.text.toString().trim()
            val width = binding.etWidth.text.toString().trim()
            val height = binding.etHeight.text.toString().trim()
            val result = length.toDouble() * width.toDouble() * height.toDouble()
            binding.tvResult.text = result.toString()
        }
    }
}