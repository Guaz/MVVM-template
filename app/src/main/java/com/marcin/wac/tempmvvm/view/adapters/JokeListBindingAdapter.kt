package com.marcin.wac.tempmvvm.view.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marcin.wac.tempmvvm.model.modelClass.Joke

@BindingAdapter("list")
fun bindJokeRecyclerView(recyclerView: RecyclerView, data: List<Joke>?){
    data?.let {
        val adapter = recyclerView.adapter as JokesAdapter
        adapter.submitList(data)
    }
}

@BindingAdapter("listOf")
fun bindJokeListOfCategories(textView: TextView, categories: List<String>?){
    categories?.let {
        textView.text = ""
        it.forEach { n ->
            textView.text = "${textView.text as String}$n "
        }
    }
}