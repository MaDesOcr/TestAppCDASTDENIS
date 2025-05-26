package com.dev.testappcdastdenis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.dev.testappcdastdenis.ui.theme.TestAppCDASTDENISTheme
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_topleft, FirstFragment())
            .replace(R.id.fragment_container_topright, FirstFragment())
            .replace(R.id.fragment_container_bottomleft, FirstFragment())
            .replace(R.id.fragment_container_bottomright, FirstFragment())

            .commit()
    }
}