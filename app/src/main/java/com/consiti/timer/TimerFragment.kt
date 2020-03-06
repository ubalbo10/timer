package com.consiti.timer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_timer.*

/**
 * A simple [Fragment] subclass.
 */
class TimerFragment : Fragment() {
  private lateinit var viewModel: TimerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewModel= ViewModelProvider(this).get(TimerViewModel::class.java)
        viewModel.timeLeft.observe(this, Observer { tiemporestante->
        textotiempo.text=tiemporestante.toString()
        })
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

}
