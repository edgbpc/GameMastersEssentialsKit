package edu.eric.goodwin.gamemastersessentialskit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.eric.goodwin.gamemastersessentialskit.DiceRollerViewFragment.ButtonListener
import kotlinx.android.synthetic.main.fragment_dice_roller.*

class MainActivity : AppCompatActivity(), ButtonListener {
    override fun rollButtonPressed() {
        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(0, d2EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(0, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(1, d4EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(1, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(2, d6EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(2, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(3, d8EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(3, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(4, d10EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(4, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(5, d12EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(5, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(6, d20EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(6, 0)
        }

        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(7, d100EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(7, 0)
        }

        diceRollingModel.calculateDiceRollsResults()

    }


    var diceRollerViewFragment: DiceRollerViewFragment? = null
    private lateinit var diceRollingModel: DiceRollerModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceRollingModel = DiceRollerModel(this)

        diceRollingModel.persistence.addRow(DiceRolls(null, 0, 0, 1, 3, 2, 12, 0, 0,
            1, 5, 2, 18, 1, 20, 1, 100))


        diceRollerViewFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? DiceRollerViewFragment
        if (diceRollerViewFragment == null){
            diceRollerViewFragment = DiceRollerViewFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, diceRollerViewFragment!!)
                .commit()
        }

        diceRollerViewFragment?.listener = this

    }



}
