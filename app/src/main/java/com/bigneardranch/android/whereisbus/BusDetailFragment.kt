package com.bigneardranch.android.whereisbus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.bigneardranch.android.whereisbus.databinding.FragmentBusDetailBinding
import kotlinx.coroutines.launch

private const val TAG = "BusDetailFragment"

class BusDetailFragment : Fragment() {

    private var _binding: FragmentBusDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val busSearchResultViewModel: BusSearchResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentBusDetailBinding.inflate(inflater, container, false)
        binding.locationRecyclerView.layoutManager = GridLayoutManager(context, 3)
        Log.d(TAG, "DetailFragment onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                busSearchResultViewModel.busItems.collect { buses ->
                    binding.locationRecyclerView.adapter = BusDetailAdapter(buses)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}