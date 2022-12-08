package com.bigneardranch.android.whereisbus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.bigneardranch.android.whereisbus.databinding.FragmentBusLocationBinding
import com.bigneardranch.android.whereisbus.databinding.FragmentBusSearchBinding


class BusLocationFragment : Fragment() {

    private var _binding: FragmentBusLocationBinding ?= null
    private val binding
        get() = checkNotNull(_binding){ "cannot" }

    private lateinit var bus: Bus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bus = Bus(selectOrd = "101010",
            stopFlag = "1",
            selectId = "111",
            vehId = "1024",
            plainNo = "46구4566",
            routeId = "1212")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusLocationBinding.inflate(layoutInflater, container, false)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}