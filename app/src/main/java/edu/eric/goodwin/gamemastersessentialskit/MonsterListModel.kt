package edu.eric.goodwin.gamemastersessentialskit

import android.content.Context
import android.database.DatabaseUtils
import android.util.Log
import edu.eric.goodwin.gamemastersessentialskit.database.DBHelper
import edu.eric.goodwin.gamemastersessentialskit.database.MonsterListPersistence
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.longToast
import org.jetbrains.anko.support.v4.runOnUiThread
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import android.os.StrictMode
import android.database.sqlite.SQLiteDatabase





class MonsterListModel(context: Context) {

    var persistence: MonsterListPersistence
    var result: String = ""
    var json: JSONObject = JSONObject()
    var jsondown: JSONArray = JSONArray()

    var DATABASE_COMARE = "SELECT COUNT(*) from MonsterList WHERE ID > 0"



    init {

        val dbHelper = DBHelper(context.applicationContext)
        persistence = MonsterListPersistence(dbHelper)

        var record = persistence.getARecord()

         if (record.size == 0) {

            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            result = URL("http://dnd5eapi.co/api/monsters/").readText()

            json = JSONObject(result)

            jsondown = json.get("results") as JSONArray

            for (i in 0..(jsondown.length() - 1)) {
                val item = jsondown.getJSONObject(i)
                var name = item.get("name") as String
                var URL = item.get("url") as String
                Log.d("djdh", "dkdk + name")
                persistence.addRow(MonsterList(null, name as String?, URL as String?))

            }
        }
   }



}







