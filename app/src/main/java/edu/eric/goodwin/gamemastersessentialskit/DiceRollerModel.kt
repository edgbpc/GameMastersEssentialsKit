package edu.eric.goodwin.gamemastersessentialskit

import android.content.Context
import android.util.Log
import edu.eric.goodwin.gamemastersessentialskit.database.DBHelper
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsPersistence

class DiceRollerModel (context: Context){

    var persistence: DiceRollsPersistence

    init {
        val dbHelper = DBHelper(context.applicationContext)
        persistence = DiceRollsPersistence(dbHelper)

        Log.d("persistence", "message")

    }

    var qtyArray = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0, 0)

    var d2Result = 1
    var d4Result = 0
    var d6Result = 0
    var d8Result = 0
    var d10Result = 0
    var d12Result = 0
    var d20Result = 0
    var d100Result = 0

    var totalResult = 0

    val d2 = 2
    val d4 = 4
    val d6 = 6
    val d8 = 8
    val d10 = 10
    val d12 = 12
    val d20 = 20
    val d100 = 100

    fun randomRoll(dice: Int, qty: Int): Int {
        var total = 0

        for (i in 1..qty) {
            total += (1..dice).random()
            Log.d("dice roller", "dice roll - " + total)
        }
        return total
    }

    fun calculateDiceRollsResults(){
        d2Result = randomRoll(2, qtyArray[0])
        d4Result = randomRoll(4, qtyArray[1])
        d6Result = randomRoll(6, qtyArray[2])
        d8Result = randomRoll(8, qtyArray[3])
        d10Result = randomRoll(10, qtyArray[4])
        d12Result = randomRoll(12, qtyArray[5])
        d20Result = randomRoll(20, qtyArray[6])
        d100Result = randomRoll(100, qtyArray[7])

        totalResult = d2Result + d4Result + d6Result + d8Result + d10Result + d12Result + d20Result + d100Result

    }

    constructor(listData: DiceRolls, context: Context): this(context){

    }


}

