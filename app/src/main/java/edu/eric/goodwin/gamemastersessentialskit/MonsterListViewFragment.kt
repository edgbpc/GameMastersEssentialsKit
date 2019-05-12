package edu.eric.goodwin.gamemastersessentialskit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_monster_list.*
import kotlinx.android.synthetic.main.fragment_monster_list.view.*
import org.jetbrains.anko.doAsync
import org.json.JSONArray
import java.net.URL
import org.json.JSONObject


class MonsterListViewFragment: Fragment() {
    var result = "Test"
    var jsonArray = JSONArray()

    var listener: ButtonListener? = null

    interface ButtonListener{
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var buttonClick = AlphaAnimation(1F, 0.1F)

        val view = inflater.inflate(R.layout.fragment_monster_list, container, false)


        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        monsterListFragmentView.layoutManager = LinearLayoutManager(this.activity)
        monsterListFragmentView.adapter = MonsterListAdapter(MonsterListModel(activity!!).persistence.getAllLists())









    }
    fun updateData(){
    }

    inner class MonsterListAdapter(val data: List<MonsterList>): RecyclerView.Adapter<MonsterListAdapter.MonsterListHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterListHolder {
            val inflater = LayoutInflater.from(activity)
            val itemView = inflater.inflate(R.layout.monster_list_layout, parent, false)

            return MonsterListHolder(itemView)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: MonsterListHolder, position: Int) {

            holder.monsterName.text = data.get(position).Name


        }

        inner class MonsterListHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            private var view: View = itemView
            val monsterName: TextView = itemView.findViewById(R.id.monsterName)




        }

    }
}