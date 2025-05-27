package com.dev.testappcdastdenis

import android.os.Bundle
import android.os.Handler
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.dev.testappcdastdenis.utiljava.Utilitaires

class GameActivity : FragmentActivity() {

    private var sequence = mutableListOf<Int>()
    var compteur = 0
    var tourJoueurOn = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val frameTopLeft : FrameLayout = findViewById(R.id.fragment_container_topleft)
        frameTopLeft.setOnClickListener(){
            if(tourJoueurOn) {
                bipColor(frameTopLeft, R.color.blue)
                compareSaisieSequence(0)
                checkFinTour()
            }
            println("on a clické sur topleft bleu")
        }
        val frameTopRight : FrameLayout = findViewById(R.id.fragment_container_topright)
        frameTopRight.setOnClickListener(){
            if(tourJoueurOn){
                bipColor(frameTopRight, R.color.red)
                compareSaisieSequence(1)
                checkFinTour()
            }
            println("on a clické sur frameTopRight rouge")
        }
        val frameBottomLeft : FrameLayout = findViewById(R.id.fragment_container_bottomleft)
        frameBottomLeft.setOnClickListener(){
            if(tourJoueurOn) {
                bipColor(frameBottomLeft, R.color.yellow)
                compareSaisieSequence(2)
                checkFinTour()
            }
            println("on a clické sur frameBottomLeft jaune")
        }
        val frameBottonRight : FrameLayout = findViewById(R.id.fragment_container_bottomright)
        frameBottonRight.setOnClickListener(){
            if(tourJoueurOn) {
                bipColor(frameBottonRight, R.color.green)
                compareSaisieSequence(3)
                checkFinTour()
            }
            println("on a clické sur frameBottonRight vert")
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_topleft, FirstFragment())
            .replace(R.id.fragment_container_topright, FirstFragment())
            .replace(R.id.fragment_container_bottomleft, FirstFragment())
            .replace(R.id.fragment_container_bottomright, FirstFragment())
            .commit()


        //mettre en place l'alternance tourMachine/tourJoueur

       // Thread.sleep(1000)
        tourMachine()
    }

    private fun checkFinTour() {
        if(sequence.size==compteur){
            tourJoueurOn=false
            tourMachine()
        }
        else {

        }
    }

    fun tourMachine(){
        compteur = 0
        //choix aléatoire d'un frame
        //méthode de random 0-3
        val random = Utilitaires.generateRandom(4)
        sequence.add(random)
      /*  sequence.add(2)
        sequence.add(3)
        sequence.add(1)
        sequence.add(2)
*/
        for (value in sequence){
            bipColorFromInt(value)
        }

        tourJoueurOn = true;
        //attente de reproduction par l'utilisateur
        //validation ou non de la séquence
        //recommence à partir de la séquence enregistrée ou à partir de zero
        println("fin tour machine")

    }

    fun tourJoueur(){
        //saisie joueur
        //comparaison sequence

        //boolean tour du joueur actif

        compteur = 0
        tourJoueurOn = false
        println("fin tour joueur")

    }

    fun compareSaisieSequence(saisieUtil : Int){
        if(sequence.get(compteur)==saisieUtil){
            compteur++
        }
        else{
            //fin de partie
            compteur = 0
        }
        println("compteur : $compteur")
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

        //Thread.sleep(500)
         frameToBip.postDelayed({
             frameToBip.setBackgroundColor(ContextCompat.getColor(this, color))
         }, 500)
    }

}