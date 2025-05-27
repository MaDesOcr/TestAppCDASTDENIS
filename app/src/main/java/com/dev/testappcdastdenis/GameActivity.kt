package com.dev.testappcdastdenis

import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.dev.testappcdastdenis.utiljava.Utilitaires

class GameActivity : FragmentActivity() {

    private var sequence = mutableListOf<Int>()
    var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val frameTopLeft : FrameLayout = findViewById(R.id.fragment_container_topleft)
        frameTopLeft.setOnClickListener(){
            bipColor(frameTopLeft, R.color.blue)
            compareSaisieSequence(0)
            println("on a clické sur topleft bleu")
        }
        val frameTopRight : FrameLayout = findViewById(R.id.fragment_container_topright)
        frameTopRight.setOnClickListener(){
            bipColor(frameTopRight, R.color.red)
            compareSaisieSequence(1)
            println("on a clické sur frameTopRight rouge")
        }
        val frameBottomLeft : FrameLayout = findViewById(R.id.fragment_container_bottomleft)
        frameBottomLeft.setOnClickListener(){
            bipColor(frameBottomLeft, R.color.yellow)
            compareSaisieSequence(2)
            println("on a clické sur frameBottomLeft jaune")
        }
        val frameBottonRight : FrameLayout = findViewById(R.id.fragment_container_bottomright)
        frameBottonRight.setOnClickListener(){
            bipColor(frameBottonRight, R.color.green)
            compareSaisieSequence(3)
            println("on a clické sur frameBottonRight vert")
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_topleft, FirstFragment())
            .replace(R.id.fragment_container_topright, FirstFragment())
            .replace(R.id.fragment_container_bottomleft, FirstFragment())
            .replace(R.id.fragment_container_bottomright, FirstFragment())
            .commit()


        //mettre en place l'alternance tourMachine/tourJoueur

        tourMachine()





    }

    fun tourMachine(){
        //choix aléatoire d'un frame
        //méthode de random 0-3
        val random = Utilitaires.generateRandom(4)
        sequence.add(random)

        for (value in sequence){
            bipColorFromInt(value)
        }

        //attente de reproduction par l'utilisateur
        //validation ou non de la séquence
        //recommence à partir de la séquence enregistrée ou à partir de zero

    }

    fun tourJoueur(){
        //saisie joueur
        //comparaison sequence

        //boolean tour du joueur actif

        compteur = 0
    }

    fun compareSaisieSequence(saisieUtil : Int){
        if(sequence.get(compteur)==saisieUtil){
            //on est content
            compteur++
        }
        else{
            //fin de partie
            compteur = 0
        }
    }

    private fun bipColorFromInt(value: Int) {
        when(value){
            0 -> bipColor(findViewById(R.id.fragment_container_topleft), R.color.blue)
            1 -> bipColor(findViewById(R.id.fragment_container_topright), R.color.red)
            2 -> bipColor(findViewById(R.id.fragment_container_bottomleft), R.color.yellow)
            3 -> bipColor(findViewById(R.id.fragment_container_bottomright), R.color.green)
        }
    }

    fun bipColor(frameToBip : FrameLayout, color : Int){
        frameToBip.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        frameToBip.postDelayed({
            frameToBip.setBackgroundColor(ContextCompat.getColor(this, color))
        }, 500)
    }

}