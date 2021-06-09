package com.mateus.jogodavelha

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")

    var isX: Boolean = true
    var tabPositions: Array<Chose> = arrayOf<Chose>(
        Chose.NO_CHOSE, Chose.NO_CHOSE, Chose.NO_CHOSE,
        Chose.NO_CHOSE, Chose.NO_CHOSE, Chose.NO_CHOSE,
        Chose.NO_CHOSE, Chose.NO_CHOSE, Chose.NO_CHOSE)

    enum class Chose {
        CHOSE_X, CHOSE_O, NO_CHOSE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickImageButton(view: View) {
        val image: ImageView = view as ImageView
        val text: TextView = findViewById<TextView>(R.id.textView)
        val strText: String = if(!isX) "Vez do jogador 1" else "Vez do joagador 2"
        text.setText(strText)
        image.setImageResource(if(isX) R.drawable.ic_x else R.drawable.ic_zero)
        image.setOnClickListener {  }
        tabPositions[(image.id % 10) - 1] = if(isX) Chose.CHOSE_X else Chose.CHOSE_O
        if(checkWinner()){
            Timer("restart", false).schedule(1500) {
                restart()
            }
        }
        isX = !isX;
    }

    fun restart() {
        tabPositions = arrayOf<Chose>(
            Chose.NO_CHOSE, Chose.NO_CHOSE, Chose.NO_CHOSE,
            Chose.NO_CHOSE, Chose.NO_CHOSE, Chose.NO_CHOSE,
            Chose.NO_CHOSE, Chose.NO_CHOSE, Chose.NO_CHOSE)

        clear(findViewById(R.id.imageView1))
        clear(findViewById(R.id.imageView2))
        clear(findViewById(R.id.imageView3))
        clear(findViewById(R.id.imageView4))
        clear(findViewById(R.id.imageView5))
        clear(findViewById(R.id.imageView6))
        clear(findViewById(R.id.imageView7))
        clear(findViewById(R.id.imageView8))
        clear(findViewById(R.id.imageView9))
    }

    fun clear(image: ImageView) {
        image.setImageResource(R.drawable.ic_empty)
        image.setOnClickListener { onClickImageButton(image) }
    }

    fun checkWinner(): Boolean {
        if (
            tabPositions[0] == tabPositions[4] &&
            tabPositions[0] == tabPositions[8] &&
            tabPositions[0] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[0] == tabPositions[1] &&
            tabPositions[0] == tabPositions[2] &&
            tabPositions[0] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[3] == tabPositions[4] &&
            tabPositions[3] == tabPositions[5] &&
            tabPositions[3] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[6] == tabPositions[7] &&
            tabPositions[6] == tabPositions[8] &&
            tabPositions[6] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[2] == tabPositions[4] &&
            tabPositions[2] == tabPositions[6] &&
            tabPositions[2] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[0] == tabPositions[3] &&
            tabPositions[0] == tabPositions[6] &&
            tabPositions[0] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[1] == tabPositions[4] &&
            tabPositions[1] == tabPositions[7] &&
            tabPositions[1] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[2] == tabPositions[5] &&
            tabPositions[2] == tabPositions[8] &&
            tabPositions[2] == Chose.CHOSE_X
        ) {
            Toast.makeText(this, "X win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[0] == tabPositions[4] &&
            tabPositions[0] == tabPositions[8] &&
            tabPositions[0] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[0] == tabPositions[1] &&
            tabPositions[0] == tabPositions[2] &&
            tabPositions[0] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[3] == tabPositions[4] &&
            tabPositions[3] == tabPositions[5] &&
            tabPositions[3] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[6] == tabPositions[7] &&
            tabPositions[6] == tabPositions[8] &&
            tabPositions[6] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[2] == tabPositions[4] &&
            tabPositions[2] == tabPositions[6] &&
            tabPositions[2] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[0] == tabPositions[3] &&
            tabPositions[0] == tabPositions[6] &&
            tabPositions[0] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[1] == tabPositions[4] &&
            tabPositions[1] == tabPositions[7] &&
            tabPositions[1] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        else if (
            tabPositions[2] == tabPositions[5] &&
            tabPositions[2] == tabPositions[8] &&
            tabPositions[2] == Chose.CHOSE_O
        ) {
            Toast.makeText(this, "O win", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}