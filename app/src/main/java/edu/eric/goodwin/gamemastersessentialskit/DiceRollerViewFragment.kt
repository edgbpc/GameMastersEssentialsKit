package edu.eric.goodwin.gamemastersessentialskit

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_dice_roller.*
import kotlinx.android.synthetic.main.fragment_dice_roller.view.*


class DiceRollerViewFragment: Fragment() {



    var listener: ButtonListener? = null

    interface ButtonListener{
        fun rollButtonPressed()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var buttonClick = AlphaAnimation(1F, 0.1F)

        val view = inflater.inflate(R.layout.fragment_dice_roller, container, false)



        view.rollButton.setOnClickListener {
            it.startAnimation(buttonClick)
            listener?.rollButtonPressed()

        }

        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        diceRollerFragmentView.layoutManager = LinearLayoutManager(this.activity)
        diceRollerFragmentView.adapter = DiceRollerAdapter(DiceRollerModel(activity!!).persistence.getAllLists())

    }

    fun updateData(){
        diceRollerFragmentView.adapter = DiceRollerAdapter(DiceRollerModel(activity!!).persistence.getAllLists())
    }

    inner class DiceRollerAdapter(val data: List<DiceRolls>): RecyclerView.Adapter<DiceRollerAdapter.DiceRollerHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceRollerHolder {
            val inflater = LayoutInflater.from(activity)
            val itemView = inflater.inflate(R.layout.dice_list_layout, parent, false)

            return DiceRollerHolder(itemView)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: DiceRollerHolder, position: Int) {

            holder.d2Result.text = data.get(position).d2Result.toString()
            holder.d4Result.text = data.get(position).d4Result.toString()
            holder.d6Result.text = data.get(position).d6Result.toString()
            holder.d8Result.text = data.get(position).d8Result.toString()
            holder.d10Result.text = data.get(position).d10Result.toString()
            holder.d12Result.text = data.get(position).d12Result.toString()
            holder.d20Result.text = data.get(position).d20Result.toString()
            holder.d100Result.text = data.get(position).d100Result.toString()

        }

        inner class DiceRollerHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            private var view: View = itemView

            val d2Result: TextView = itemView.findViewById(R.id.d2Result)
            val d4Result: TextView = itemView.findViewById(R.id.d4Result)
            val d6Result: TextView = itemView.findViewById(R.id.d6Result)
            val d8Result: TextView = itemView.findViewById(R.id.d8Result)
            val d10Result: TextView = itemView.findViewById(R.id.d10Result)
            val d12Result: TextView = itemView.findViewById(R.id.d12Result)
            val d20Result: TextView = itemView.findViewById(R.id.d20Result)
            val d100Result: TextView = itemView.findViewById(R.id.d100Result)


        }

    }
}