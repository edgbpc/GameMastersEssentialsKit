package edu.eric.goodwin.gamemastersessentialskit.database

object DiceRollsSchema {
    const val  TABLE_NAME = "Dice Rolls"
    object Cols {
        const val iId = "iId"
        const val cDice = "cDice"
        const val iQty = "iQty"
        const val iResult = "iResult"
    }
}