package com.marcin.wac.tempmvvm.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.marcin.wac.tempmvvm.viewModel.DetailJokeViewModel
import com.marcin.wac.tempmvvm.viewModel.DetailJokeViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class DetailJokeFragment: Fragment(), KodeinAware {
    override val kodein by kodein()

    private lateinit var viewModel: DetailJokeViewModel
    private val factory: DetailJokeViewModelFactory by instance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, factory).get(DetailJokeViewModel::class.java)
        val binding = DataBindingUtil.inflate<>()
        return binding.root
    }
}