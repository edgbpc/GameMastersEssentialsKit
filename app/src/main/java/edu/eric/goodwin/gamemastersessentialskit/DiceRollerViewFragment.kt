package edu.eric.goodwin.gamemastersessentialskit

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dice_roller.*
import kotlinx.android.synthetic.main.fragment_dice_roller.view.*

class DiceRollerViewFragment: Fragment() {

    var listener: ButtonListener? = null

    interface ButtonListener{
        fun rollButtonPressed()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dice_roller, container, false)

        view.rollButton.setOnClickListener {
            listener?.rollButtonPressed()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        diceRollerFragmentView.layoutManager = LinearLayoutManager(this.activity)
      //  diceRollerFragmentView.adapter = DiceRollerAdapter(dummyData)

    }

    inner class DiceRollerAdapter(val data: Array<Int>): RecyclerView.Adapter<DiceRollerAdapter.DiceRollerHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceRollerHolder {
            val inflater = LayoutInflater.from(activity)
            val itemView = inflater.inflate(R.layout.dice_list_layout, parent, false)

            return DiceRollerHolder(itemView)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: DiceRollerHolder, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        inner class DiceRollerHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            private var view: View = itemView
        }

    }
}