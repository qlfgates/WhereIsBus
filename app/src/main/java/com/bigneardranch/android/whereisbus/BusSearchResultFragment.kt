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
import com.bigneardranch.android.whereisbus.data.Bus
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
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusSearchResultBinding.inflate(inflater, container, false)
        binding.busSearchResultListRecyclerView.layoutManager = LinearLayoutManager(context)
        Log.d(TAG, "onCreateView")

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                busSearchResultViewModel.busItems.collect{ busItems ->
                    binding.busSearchResultListRecyclerView.adapter = BusSearchResultListAdapter(busItems){
                        busItems -> findNavController().navigate(
                        BusSearchResultFragmentDirections.actionBusSearchResultFragmentToBusDetailFragment())
                    }
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