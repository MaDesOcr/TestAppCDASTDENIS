package com.dev.testappcdastdenis

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity

class GameActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val frameTopLeft : FrameLayout = findViewById(R.id.fragment_container_topleft)
        frameTopLeft.setOnClickListener(){
            println("on a clické sur topleft bleu")
        }
        val frameTopRight : FrameLayout = findViewById(R.id.fragment_container_topright)
        frameTopRight.setOnClickListener(){
            println("on a clické sur frameTopRight rouge")
        }
        val frameBottomLeft : FrameLayout = findViewById(R.id.fragment_container_bottomleft)
        frameBottomLeft.setOnClickListener(){
            println("on a clické sur frameBottomLeft jaune")
        }
        val frameBottonRight : FrameLayout = findViewById(R.id.fragment_container_bottomright)
        frameBottonRight.setOnClickListener(){
            println("on a clické sur frameBottonRight vert")
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_topleft, FirstFragment())
            .replace(R.id.fragment_container_topright, FirstFragment())
            .replace(R.id.fragment_container_bottomleft, FirstFragment())
            .replace(R.id.fragment_container_bottomright, FirstFragment())
            .commit()



    }




}