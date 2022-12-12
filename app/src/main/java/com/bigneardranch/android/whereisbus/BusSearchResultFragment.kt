package com.bigneardranch.android.whereisbus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchResultBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// 검색 결과 화면
private const val TAG = "BusSearchResult"

class BusSearchResultFragment : Fragment() {

    private var _binding: FragmentBusSearchResultBinding ?= null
    private val binding
        get() = checkNotNull(_binding){ "cannot" }

    private val busResultListViewModel: BusSearchResultViewModel by viewModels()

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusSearchResultBinding.inflate(inflater, container, false)
        binding.busSearchResultListRecyclerView.layoutManager = LinearLayoutManager(context)

        val buses = busResultListViewModel.buses
        val adapter = BusListAdapter(buses)
        binding.busSearchResultListRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        job = viewLifecycleOwner.lifecycleScope.launch{
            val buses = busResultListViewModel.loadBuses()
            binding.busSearchResultListRecyclerView.adapter = BusListAdapter(buses)
        }
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                val buses = busResultListViewModel.loadBuses()
                binding.busSearchResultListRecyclerView.adapter = BusListAdapter(buses)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}