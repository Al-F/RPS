package com.alf_here.rpc

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        view.findViewById<TextView>(R.id.gamer_score_textview).text =
            viewModel.gamerScore.toString()
        view.findViewById<TextView>(R.id.enemy_score_textview).text =
            viewModel.enemyScore.toString()
        view.findViewById<ImageButton>(R.id.rock_button)
            .setOnClickListener {
                findNavController().navigate(R.id.action_game_to_gameResult)
                viewModel.onWeaponChosen(Weapon.ROCK)
            }
        view.findViewById<ImageButton>(R.id.paper_button)
            .setOnClickListener {
                findNavController().navigate(R.id.action_game_to_gameResult)
                viewModel.onWeaponChosen(Weapon.PAPER)
            }
        view.findViewById<ImageButton>(R.id.scissors_button)
            .setOnClickListener {
                findNavController().navigate(R.id.action_game_to_gameResult)
                viewModel.onWeaponChosen(Weapon.SCISSORS)
            }
    }
}