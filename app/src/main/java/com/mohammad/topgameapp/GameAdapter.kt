package com.mohammad.topgameapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(val gamesList:ArrayList<GameModel> )
    :RecyclerView.Adapter<GameAdapter.MyViewHolder>()
{
        inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            var gameImage:ImageView
            var gameText:TextView

            init {
                gameImage =itemView.findViewById(R.id.cardViewImg)
                gameText=itemView.findViewById(R.id.cardViewTXT)

                itemView.setOnClickListener(){
                    Toast.makeText(itemView.context,
                        "You Selected ${gamesList[adapterPosition]}",Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v=LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_layout,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gameImage.setImageResource(gamesList[position].imgCard)
        holder.gameText.setText(gamesList[position].textCard)
    }
}