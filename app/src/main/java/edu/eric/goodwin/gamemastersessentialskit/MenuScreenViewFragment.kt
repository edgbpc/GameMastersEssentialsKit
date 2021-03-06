package edu.eric.goodwin.gamemastersessentialskit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.menu_screen.view.*

class MenuScreenViewFragment: Fragment() {


    var listener: ButtonListener? = null

    interface ButtonListener{
        fun diceRollerButtonPressed()
        fun monsterListButtonPressed()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var buttonClick = AlphaAnimation(1F, 0.1F)

        val view = inflater.inflate(R.layout.menu_screen, container, false)



        view.diceRollerButton.setOnClickListener {
            it.startAnimation(buttonClick)
            listener?.diceRollerButtonPressed()

        }

        view.monsterListButton.setOnClickListener {
            it.startAnimation(buttonClick)
            listener?.monsterListButtonPressed()
        }

        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }
}