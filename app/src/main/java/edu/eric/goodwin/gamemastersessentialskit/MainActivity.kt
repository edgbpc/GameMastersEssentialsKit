package edu.eric.goodwin.gamemastersessentialskit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    var diceRollerViewFragment: DiceRollerViewFragment? = null
    lateinit var diceRollingModel: DiceRollerModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceRollingModel = DiceRollerModel(this)


        diceRollerViewFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? DiceRollerViewFragment
        if (diceRollerViewFragment == null){
            diceRollerViewFragment = DiceRollerViewFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, diceRollerViewFragment!!)
                .commit()
        }

    }



}
