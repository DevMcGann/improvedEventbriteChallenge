package com.gsoft.improvedeventbritechallenge.ui.mainFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gsoft.improvedeventbritechallenge.R
import com.gsoft.improvedeventbritechallenge.data.model.Event
import com.gsoft.improvedeventbritechallenge.databinding.FragmentMainBinding
import com.gsoft.improvedeventbritechallenge.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: EventsViewModel by viewModels()
    private lateinit var binding : FragmentMainBinding
    private lateinit var  eventAdapter : EventsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        eventAdapter = EventsAdapter(emptyList())

        setView()
        observeViewModel()
    }

    private fun setView() {
        binding.rvEvents.apply {
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private fun observeViewModel() {
        viewModel.fetchEvents().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    handleLoadingState()
                }
                is Resource.Success -> {
                    handleSuccessState(result.data)
                }
                is Resource.Failure -> {
                    handleFailState(result.exception)
                }
            }
        })
    }

    private fun handleLoadingState(){
        binding.pbEvents.isVisible = true
        binding.imageView.isVisible = false
        binding.tvError.isVisible = false
    }

    private fun handleSuccessState(data: List<Event>){
        binding.pbEvents.isVisible = false
        binding.imageView.isVisible = false
        binding.tvError.isVisible = false
        eventAdapter = EventsAdapter(data)
        binding.rvEvents.adapter = eventAdapter
    }

    private fun handleFailState(e:Exception){
        binding.pbEvents.isVisible = false
        binding.imageView.isVisible = true
        binding.tvError.isVisible = true
        Log.d("Error", "$e")
    }
}