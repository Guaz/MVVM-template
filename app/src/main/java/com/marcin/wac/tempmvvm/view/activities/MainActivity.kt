package com.marcin.wac.tempmvvm.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.marcin.wac.tempmvvm.R
import com.marcin.wac.tempmvvm.databinding.ActivityMainBinding
import com.marcin.wac.tempmvvm.listener.JokeListener
import com.marcin.wac.tempmvvm.model.modelClass.JokeResponse
import com.marcin.wac.tempmvvm.view.adapters.JokesAdapter
import com.marcin.wac.tempmvvm.viewModel.MainViewModel
import com.marcin.wac.tempmvvm.viewModel.MainViewModelFactory
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), JokeListener, KodeinAware {

    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel
        viewModel.jokeListener = this

        binding.mainJokesRV.adapter = JokesAdapter()
    }

    override fun onStarted() {

    }

    override fun onSuccess(jokeResponse: JokeResponse?) {

    }

    override fun onFailure(message: String) {

    }
}
