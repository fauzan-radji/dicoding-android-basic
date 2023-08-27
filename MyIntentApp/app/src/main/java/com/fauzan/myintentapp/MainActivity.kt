package com.fauzan.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObjectActivity: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObjectActivity.setOnClickListener(this)
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
        }
    }
}