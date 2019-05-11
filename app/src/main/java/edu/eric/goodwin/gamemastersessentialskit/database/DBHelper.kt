package edu.eric.goodwin.gamemastersessentialskit.database

import android.content.Context
import org.jetbrains.anko.db.*
import android.database.sqlite.SQLiteDatabase

class DBHelper(context: Context): ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(DiceRollsSchema.TABLE_NAME, true,
            DiceRollsSchema.Cols.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            DiceRollsSchema.Cols.d2Qty to INTEGER,
            DiceRollsSchema.Cols.d2Result to INTEGER,
            DiceRollsSchema.Cols.d4Qty to INTEGER,
            DiceRollsSchema.Cols.d4Result to INTEGER,
            DiceRollsSchema.Cols.d6Qty to INTEGER,
            DiceRollsSchema.Cols.d6Result to INTEGER,
            DiceRollsSchema.Cols.d8Qty to INTEGER,
            DiceRollsSchema.Cols.d8Result to INTEGER,
            DiceRollsSchema.Cols.d10Qty to INTEGER,
            DiceRollsSchema.Cols.d10Result to INTEGER,
            DiceRollsSchema.Cols.d12Qty to INTEGER,
            DiceRollsSchema.Cols.d12Result to INTEGER,
            DiceRollsSchema.Cols.d20Qty to INTEGER,
            DiceRollsSchema.Cols.d20Result to INTEGER,
            DiceRollsSchema.Cols.d100Qty to INTEGER,
            DiceRollsSchema.Cols.d100Result to INTEGER
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object {
        const val DB_NAME = "GMKit.sqLite"
        const val DB_VERSION = 1
    }
}
