package com.marcin.wac.tempmvvm.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marcin.wac.tempmvvm.databinding.RowJokeBinding
import com.marcin.wac.tempmvvm.model.modelClass.Joke

class JokesAdapter() : ListAdapter<Joke, JokesAdapter.JokeViewHolder>(DiffUserCallback){

    companion object DiffUserCallback : DiffUtil.ItemCallback<Joke>(){
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem.joke == newItem.joke
        }
    }

    class JokeViewHolder(private var binding: RowJokeBinding): RecyclerView.ViewHolder(binding.root){

        companion object{
            fun from(parent: ViewGroup) : JokeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowJokeBinding.inflate(layoutInflater, parent, false)
                return JokeViewHolder(binding)
            }
        }

        fun bind(joke: Joke){
            binding.joke = joke
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder.from(parent) }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = getItem(position)
        holder.bind(joke)
    }
}