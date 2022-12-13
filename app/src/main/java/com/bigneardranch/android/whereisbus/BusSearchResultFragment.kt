package com.bigneardranch.android.whereisbus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigneardranch.android.whereisbus.api.BusApi
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchResultBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

// 검색 결과 화면
private const val TAG = "BUS_SEARCH_RESULT_FRAGMENT"

class BusSearchResultFragment : Fragment() {

    private var _binding: FragmentBusSearchResultBinding? = null
    private val binding
        get() = checkNotNull(_binding){ "Cannot access binding because it is null"}

    private val busSearchResultViewModel: BusSearchResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusSearchResultBinding.inflate(inflater, container, false)
        binding.busSearchResultListRecyclerView.layoutManager = GridLayoutManager(context, 3)
        return binding.root
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
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}