package edu.eric.goodwin.gamemastersessentialskit

import android.content.Context
import edu.eric.goodwin.gamemastersessentialskit.database.DBHelper
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsPersistence

class DiceRollerModel (context: Context){

    var persistence: DiceRollsPersistence

    init {
        val dbHelper = DBHelper(context.applicationContext)
        persistence = DiceRollsPersistence(dbHelper)

    }


}

