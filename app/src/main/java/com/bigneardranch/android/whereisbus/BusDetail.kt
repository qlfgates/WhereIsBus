package com.bigneardranch.android.whereisbus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchBinding


class BusDetailFragment : Fragment() {

    private lateinit var binding: FragmentBusSearchBinding
    private lateinit var bus: Bus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBusSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            busNumberInput.doOnTextChanged { text, _, _, _ ->
                bus = bus.copy(vehId = text.toString())
            }
        }
    }
}