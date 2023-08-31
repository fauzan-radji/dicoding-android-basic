package com.fauzan.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if(result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil: $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObjectActivity: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObjectActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResultActivity: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResultActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(button: View?) {
        when(button?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 19)
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Fauzan Radji")
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_object -> {
                val moveIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                val person = Person(
                    name = "Fauzan Radji",
                    age = 19,
                    email = "fauzan@gmail.com",
                    city = "Gorontalo"
                )
                moveIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081234567890"
                val moveIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(moveIntent)
            }

            R.id.btn_move_for_result -> {
                val moveIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveIntent)
            }
        }
    }
}