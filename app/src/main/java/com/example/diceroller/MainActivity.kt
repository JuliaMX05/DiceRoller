package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
        }

        rollDice()
        rollDice2()
    }

    //Бросьте кости и обновите экран с результатом.
    private fun rollDice() {
        //Создайте новый объект Dice с 6 гранями и бросьте кости
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Найдите ImageView в макете
        val daceImage: ImageView = findViewById(R.id.imageView)

        // Определите, какой идентификатор ресурса для рисования следует использовать на основе броска кубика
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Обновление ImageView с правильным идентификатором ресурса drawable
        daceImage.setImageResource(drawableResource)
        daceImage.contentDescription = diceRoll.toString();
    }

    private fun rollDice2() {
        //Создайте новый объект Dice с 6 гранями и бросьте кости
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Найдите ImageView в макете
        val daceImage: ImageView = findViewById(R.id.imageView2)

        // Определите, какой идентификатор ресурса для рисования следует использовать на основе броска кубика
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Обновление ImageView с правильным идентификатором ресурса drawable
        daceImage.setImageResource(drawableResource)
        daceImage.contentDescription = diceRoll.toString();
    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}