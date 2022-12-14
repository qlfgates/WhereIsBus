package com.bigneardranch.android.whereisbus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchResultBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


// 검색 결과 화면
private const val TAG = "BUS_SEARCH_RESULT_FRAGMENT"

class BusSearchResultFragment : Fragment() {

    private var _binding: FragmentBusSearchResultBinding? = null
    private val binding
        get() = checkNotNull(_binding){ "Cannot access binding because it is null"}

    private val busSearchResultViewModel: BusSearchResultViewModel by viewModels()

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        Log.d(TAG, "dddd")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusSearchResultBinding.inflate(inflater, container, false)
        binding.busSearchResultListRecyclerView.layoutManager = LinearLayoutManager(context)
//
//        val buses = busSearchResultViewModel.busItems
//        val adapter = BusSearchResultListAdapter(buses)
//        binding.busSearchResultListRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
//        job = viewLifecycleOwner.lifecycleScope.launch {
//            val buses = busSearchResultViewModel.loadBuses()
//            binding.busSearchResultListRecyclerView.adapter = BusSearchResultListAdapter(buses)
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = BusSearchResultRepository().fetchBuses()
                Log.d(TAG, "Response received: $response")
            } catch (ex: Exception){
                Log.e(TAG, "Failed to fetch buses", ex)
            }
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                busSearchResultViewModel.busItems.collect{ buses ->
                    Log.d(TAG, "Response received: $buses")
//                    binding.busSearchResultListRecyclerView.adapter =
//                        BusSearchResultListAdapter(buses){ busId ->
//                            findNavController().navigate()
//                            )
//                        }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        job?.cancel()
    }
}