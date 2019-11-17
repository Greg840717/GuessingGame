package com.example.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import java.nio.file.Files.find

class MainActivity : AppCompatActivity() {

    private lateinit var playerName :EditText
    private lateinit var status :TextView
    private lateinit var scissors :RadioButton
    private lateinit var stone :RadioButton
    private lateinit var paper:RadioButton
    private lateinit var start :Button
    private lateinit var player :TextView
    private lateinit var winner :TextView
    private lateinit var mine :TextView
    private lateinit var computer :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerName = findViewById(R.id.PlayerName)
        status = findViewById(R.id.Status)
        scissors = findViewById(R.id.Scissors)
        stone = findViewById(R.id.Stone)
        paper = findViewById(R.id.Paper)
        start = findViewById(R.id.Start)
        player = findViewById(R.id.Player)
        winner = findViewById(R.id.Winner)
        mine = findViewById(R.id.Mine)
        computer = findViewById(R.id.Computer)

        initialLayoutText()
    }

    fun initialLayoutText() {
        playerName.setHint(R.string.hint)
        status.setText(R.string.status)
        scissors.setText("剪刀")
        stone.setText("石頭")
        paper.setText("布")
        start.setText("開始")
        player.setText("名子")
        winner.setText("贏家")
        mine.setText("玩家出拳")
        computer.setText("電腦出拳")
    }
}
