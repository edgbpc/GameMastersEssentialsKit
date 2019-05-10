package edu.eric.goodwin.gamemastersessentialskit.database

import android.content.Context
import org.jetbrains.anko.db.*
import android.database.sqlite.SQLiteDatabase

class DBHelper(context: Context): ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(DiceRollsSchema.TABLE_NAME, true,
            DiceRollsSchema.Cols.iId to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            DiceRollsSchema.Cols.cDice to TEXT,
            DiceRollsSchema.Cols.iQty to INTEGER,
            DiceRollsSchema.Cols.iResult to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        const val DB_NAME = "GMEssentialsKit.sqLite"
        const val DB_VERSION = 1
    }
}