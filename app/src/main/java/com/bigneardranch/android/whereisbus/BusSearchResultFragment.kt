package com.bigneardranch.android.whereisbus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchResultBinding

// 검색 결과 화면
private const val TAG = "BusSearchResult"

class BusSearchResult : Fragment() {

    private var _binding: FragmentBusSearchResultBinding ?= null
    private val binding
        get() = checkNotNull(_binding){ "cannot" }

    private val busResultListViewModel: BusSearchResultViewModel by viewModels()

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
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}