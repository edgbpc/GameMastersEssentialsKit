package edu.eric.goodwin.gamemastersessentialskit.database

import android.database.sqlite.SQLiteConstraintException
import edu.eric.goodwin.gamemastersessentialskit.MonsterList
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SqlOrderDirection
import org.jetbrains.anko.db.insertOrThrow
import org.jetbrains.anko.db.select

class MonsterListPersistence(private val dbHelper: DBHelper) {

    fun getARecord(): List<MonsterList> {
        return dbHelper.use {
            select(MonsterListSchema.TABLE_NAME)
                .orderBy(MonsterListSchema.Cols.ID, SqlOrderDirection.DESC)
                .limit(1)
                .parseList(object : MapRowParser<MonsterList> {
                    override fun parseRow(columns: Map<String, Any?>): MonsterList {
                        val ID = columns.get(MonsterListSchema.Cols.ID) as Number
                        val Name = columns.get(MonsterListSchema.Cols.NAME) as String
                        val URL = columns.get(MonsterListSchema.Cols.URL) as String
                        return MonsterList(ID.toInt(), Name, URL)
                    }
                })
        }
    }


    fun getAllLists(): List<MonsterList> {
        return dbHelper.use {
            select(MonsterListSchema.TABLE_NAME)
                .orderBy(MonsterListSchema.Cols.ID, SqlOrderDirection.ASC)
                .parseList(object : MapRowParser<MonsterList> {
                    override fun parseRow(columns: Map<String, Any?>): MonsterList {
                        val ID = columns.get(MonsterListSchema.Cols.ID) as Number
                        val Name = columns.get(MonsterListSchema.Cols.NAME) as String
                        val URL = columns.get(MonsterListSchema.Cols.URL) as String
                        return MonsterList(ID.toInt(), Name, URL)
                    }
                })
        }
    }

    fun addRow(list: MonsterList): List<MonsterList>?{
        return dbHelper.use {
            try {
                insertOrThrow(
                    MonsterListSchema.TABLE_NAME,
                    MonsterListSchema.Cols.NAME to list.Name, MonsterListSchema.Cols.URL to list.URL
                )
                itemListFor()
            } catch (e: SQLiteConstraintException){
                null
            }
        }
    }

    fun itemListFor(): List<MonsterList>? {
        return dbHelper.use{
            select(MonsterListSchema.TABLE_NAME)
                .parseList(object: MapRowParser<MonsterList>{
                    override fun parseRow(columns: Map<String, Any?>): MonsterList {
                        return MonsterList(null, null, null)
                    }
                }
                )
        }
    }
}