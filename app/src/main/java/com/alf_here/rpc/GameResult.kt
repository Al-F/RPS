package com.alf_here.rpc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class GameResult : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        view.findViewById<TextView>(R.id.game_result_message_textview).text = viewModel.message
        view.findViewById<ImageView>(R.id.enemy_weapon_imageview)
            .setImageResource(viewModel.enemyWeaponDrawable)
        view.findViewById<ImageView>(R.id.gamer_weapon_imageview)
            .setImageResource(viewModel.gamerWeaponDrawable)
        view.findViewById<ImageView>(R.id.replay_game).setOnClickListener {
            findNavController().navigate(R.id.action_gameResult_to_game)
        }
    }
}