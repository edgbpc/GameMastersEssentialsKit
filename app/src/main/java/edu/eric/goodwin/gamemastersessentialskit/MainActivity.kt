package edu.eric.goodwin.gamemastersessentialskit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat
import edu.eric.goodwin.gamemastersessentialskit.DiceRollerViewFragment.ButtonListener
import kotlinx.android.synthetic.main.fragment_dice_roller.*

class MainActivity : AppCompatActivity(), DiceRollerViewFragment.ButtonListener, MenuScreenViewFragment.ButtonListener {




    override fun diceRollerButtonPressed() {

        diceRollerViewFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? DiceRollerViewFragment
        if (diceRollerViewFragment == null){
            diceRollerViewFragment = DiceRollerViewFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, diceRollerViewFragment!!)
                .addToBackStack(null)
                .commit()
        }

        diceRollerViewFragment?.listener = this

    }


    override fun rollButtonPressed() {
        if (d2EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(0, d2EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(0, 0)
        }

        if (d4EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(1, d4EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(1, 0)
        }

        if (d6EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(2, d6EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(2, 0)
        }

        if (d8EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(3, d8EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(3, 0)
        }

        if (d10EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(4, d10EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(4, 0)
        }

        if (d12EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(5, d12EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(5, 0)
        }

        if (d20EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(6, d20EditTextBox.text.toString().toInt())

        } else {
            diceRollingModel.qtyArray.set(6, 0)
        }

        if (d100EditTextBox.text.toString() != "") {
            diceRollingModel.qtyArray.set(7, d100EditTextBox.text.toString().toInt())
        } else {
            diceRollingModel.qtyArray.set(7, 0)
        }

        diceRollingModel.calculateDiceRollsResults()

        diceRollingModel.d20Result = 1

        if (diceRollingModel.d20Result == 20 && diceRollingModel.qtyArray[6] == 1){
            createNotification(true)

        } else if ((diceRollingModel.d20Result == 1 && diceRollingModel.qtyArray[6] == 1)){
            createNotification(false)
        }

        d2ResultsView.text = "Total: " + diceRollingModel.d2Result.toString()
        d4ResultsView.text = "Total: " +  diceRollingModel.d4Result.toString()
        d6ResultsView.text = "Total: " +  diceRollingModel.d6Result.toString()
        d8ResultsView.text = "Total: " +  diceRollingModel.d8Result.toString()
        d10ResultsView.text = "Total: " +  diceRollingModel.d10Result.toString()
        d12ResultsView.text = "Total: " +  diceRollingModel.d12Result.toString()
        d20ResultsView.text = "Total: " +  diceRollingModel.d20Result.toString()
        d100ResultsView.text = "Total: " +  diceRollingModel.d100Result.toString()

        allResultsView.text = "Total: "  + diceRollingModel.totalResult.toString()

        diceRollingModel.persistence.addRow(
            DiceRolls(null, diceRollingModel.qtyArray[0], diceRollingModel.d2Result,
                diceRollingModel.qtyArray[1], diceRollingModel.d4Result,
                diceRollingModel.qtyArray[2], diceRollingModel.d6Result,
                diceRollingModel.qtyArray[3], diceRollingModel.d8Result,
                diceRollingModel.qtyArray[4], diceRollingModel.d10Result,
                diceRollingModel.qtyArray[5], diceRollingModel.d12Result,
                diceRollingModel.qtyArray[6], diceRollingModel.d20Result,
                diceRollingModel.qtyArray[7], diceRollingModel.d100Result
                        ))

        diceRollerViewFragment!!.updateData()
    }


    private var diceRollerViewFragment: DiceRollerViewFragment? = null
    private var menuScreenViewFragment: MenuScreenViewFragment? = null
    private lateinit var diceRollingModel: DiceRollerModel
    private val generator = NotificationGenerator()

    private fun createNotification(success: Boolean) {
        if (success) {
            val title: String = "Critical Success!"
            val body = "You've Rolled A Natural 20! Automatic Success!"
            val notification = generator.buildNotificationWith(this, title, body)
            val notificationIntent = Intent(this, MyNotificationPublisher::class.java)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, 1)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification)
            NotificationManagerCompat.from(this).apply { notify(1, notification) }


        } else {
            val title: String = "Critical FAILURE!"
            val body = "You've Rolled A Natural 1! Automatic FAILURE"
            val notification = generator.buildNotificationWith(this, title, body)
            val notificationIntent = Intent(this, MyNotificationPublisher::class.java)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, 1)
            notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification)
            NotificationManagerCompat.from(this).apply { notify(1, notification) }


        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generator.createNotificationChannel(this)

        diceRollingModel = DiceRollerModel(this)

        menuScreenViewFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as? MenuScreenViewFragment
        if (menuScreenViewFragment == null) {
            menuScreenViewFragment = MenuScreenViewFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, menuScreenViewFragment!!)
                .commit()
        }

        menuScreenViewFragment?.listener = this


    }

}
