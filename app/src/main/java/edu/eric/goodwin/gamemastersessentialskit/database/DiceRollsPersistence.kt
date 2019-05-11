package edu.eric.goodwin.gamemastersessentialskit.database

import android.database.sqlite.SQLiteConstraintException
import edu.eric.goodwin.gamemastersessentialskit.DiceRolls
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.ID
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d100Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d100Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d10Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d10Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d12Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d12Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d20Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d20Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d2Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d2Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d4Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d4Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d6Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d6Result
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d8Qty
import edu.eric.goodwin.gamemastersessentialskit.database.DiceRollsSchema.Cols.d8Result
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SqlOrderDirection
import org.jetbrains.anko.db.insertOrThrow
import org.jetbrains.anko.db.select

class DiceRollsPersistence(private val dbHelper: DBHelper ) {

    fun getAllLists(): List<DiceRolls>{
        return dbHelper.use {
            select(DiceRollsSchema.TABLE_NAME)
            .orderBy(ID, SqlOrderDirection.DESC)
            .limit(10)
            .parseList(object: MapRowParser<DiceRolls>{
            override fun parseRow(columns: Map<String, Any?>): DiceRolls {
                val ID = columns.get(DiceRollsSchema.Cols.ID) as Number
                val d2Qty = columns.get(DiceRollsSchema.Cols.d2Qty) as Number
                val d2Result = columns.get(DiceRollsSchema.Cols.d2Result) as Number
                val d4Qty = columns.get(DiceRollsSchema.Cols.d4Qty) as Number
                val d4Result = columns.get(DiceRollsSchema.Cols.d4Result) as Number
                val d6Qty = columns.get(DiceRollsSchema.Cols.d6Qty) as Number
                val d6Result = columns.get(DiceRollsSchema.Cols.d6Result) as Number
                val d8Qty = columns.get(DiceRollsSchema.Cols.d8Qty) as Number
                val d8Result = columns.get(DiceRollsSchema.Cols.d8Result) as Number
                val d10Qty = columns.get(DiceRollsSchema.Cols.d10Qty) as Number
                val d10Result = columns.get(DiceRollsSchema.Cols.d10Result) as Number
                val d12Qty = columns.get(DiceRollsSchema.Cols.d12Qty) as Number
                val d12Result = columns.get(DiceRollsSchema.Cols.d12Result) as Number
                val d20Qty = columns.get(DiceRollsSchema.Cols.d20Qty) as Number
                val d20Result = columns.get(DiceRollsSchema.Cols.d20Result) as Number
                val d100Qty = columns.get(DiceRollsSchema.Cols.d100Qty) as Number
                val d100Result = columns.get(DiceRollsSchema.Cols.d100Qty) as Number
                return DiceRolls(ID.toInt(), d2Qty.toInt(), d2Result.toInt(), d4Qty.toInt(), d4Result.toInt(),
                    d6Qty.toInt(), d6Result.toInt(), d8Qty.toInt(), d8Result.toInt(), d10Qty.toInt(), d10Result.toInt(),
                    d12Qty.toInt(), d12Result.toInt(), d20Qty.toInt(), d20Result.toInt(), d100Qty.toInt(), d100Result.toInt())

            }
        })

        }
    }

    fun addRow(list: DiceRolls): List<DiceRolls>?{
        return dbHelper.use {
            try {
                insertOrThrow(
                    DiceRollsSchema.TABLE_NAME,
                    DiceRollsSchema.Cols.d2Qty to list.d2Qty, DiceRollsSchema.Cols.d2Result to list.d2Result,
                    DiceRollsSchema.Cols.d4Qty to list.d4Qty, DiceRollsSchema.Cols.d4Result to list.d4Result,
                    DiceRollsSchema.Cols.d6Qty to list.d6Qty, DiceRollsSchema.Cols.d6Result to list.d6Result,
                    DiceRollsSchema.Cols.d8Qty to list.d8Qty, DiceRollsSchema.Cols.d8Result to list.d8Result,
                    DiceRollsSchema.Cols.d10Qty to list.d10Qty, DiceRollsSchema.Cols.d10Result to list.d10Result,
                    DiceRollsSchema.Cols.d12Qty to list.d12Qty, DiceRollsSchema.Cols.d12Result to list.d12Result,
                    DiceRollsSchema.Cols.d20Qty to list.d20Qty, DiceRollsSchema.Cols.d20Result to list.d20Result,
                    DiceRollsSchema.Cols.d100Qty to list.d100Qty, DiceRollsSchema.Cols.d100Result to list.d100Result


                )
                itemListFor()
            } catch (e: SQLiteConstraintException) {
                null
            }
        }
    }

    fun itemListFor(): List<DiceRolls>? {
        return dbHelper.use {
            select(DiceRollsSchema.TABLE_NAME)
                .parseList(object : MapRowParser<DiceRolls> {
                    override fun parseRow(columns: Map<String, Any?>): DiceRolls {
                        return DiceRolls(null, null, null, null, null, null,
                            null,null, null, null, null, null,
                            null, null, null, null, null)
                    }
                }
                )
        }
    }

}