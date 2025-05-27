package com.dev.testappcdastdenis

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

import android.widget.TextView
import java.io.File

class GameOverActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameover)

        var score = findViewById<TextView>(R.id.score)

        val fichier = File("./sampledata/score2.txt")
        fichier.writeText("")

        //lire le fichier
       // val file = File("./score.txt")
        //var fileRead = file.readLines().toString()
        //score.text = fileRead
        //mettre le contenu du fichier dans score

    }
}