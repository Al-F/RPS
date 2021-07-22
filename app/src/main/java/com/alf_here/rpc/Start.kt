package com.alf_here.rpc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

/**
 * Home fragment to kick off the game.
 * Use the [Start.newInstance] factory method to
 * create an instance of this fragment.
 */
class Start : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = getView()?.findViewById<Button>(R.id.start_game_button)
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_start2_to_game)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Start()
    }
}