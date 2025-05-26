package com.dev.testappcdastdenis

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class GameActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_topleft, FirstFragment())
            .replace(R.id.fragment_container_topright, FirstFragment())
            .replace(R.id.fragment_container_bottomleft, FirstFragment())
            .replace(R.id.fragment_container_bottomright, FirstFragment())

            .commit()
    }
}