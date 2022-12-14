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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchBinding
import com.opencsv.CSVReader
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.InputStreamReader

private const val TAG = "BusSearchFragment"

class BusSearchFragment : Fragment() {

    private val busListViewModel: BusListViewModel by viewModels()
    private var job: Job? = null

    private var _binding: FragmentBusSearchBinding? = null
    private val binding
        get() = checkNotNull(_binding){ "Cannot access binding because it is null" }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBusSearchBinding.inflate(inflater, container, false)
        binding.recentRecyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                busListViewModel.routes.collect{ routes ->
                    binding.recentRecyclerView.adapter =
                        BusListAdapter(routes) { routeId ->
                            findNavController().navigate(
                                BusSearchFragmentDirections.actionBusSearchToBusSearchResult()
                            )
                        }
                }
            }
        }

    }
}