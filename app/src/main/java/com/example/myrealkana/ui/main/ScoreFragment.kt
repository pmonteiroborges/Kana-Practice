package com.example.myrealkana.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myrealkana.R
import com.example.myrealkana.databinding.ScoreFragmentBinding

class ScoreFragment : Fragment() {
    private lateinit var binding: ScoreFragmentBinding
    private lateinit var viewModel: ScoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.score_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        binding.viewModel = viewModel

        val args = ScoreFragmentArgs.fromBundle(requireArguments())
        val score = args.score
        val total = args.total
        val percentage = "%.2f".format((score.toDouble() / total) * 100)

        binding.score.text = "$score/$total ($percentage%)"

        binding.buttonChooseNew.setOnClickListener {
            this.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToHiraganaSelectionFragment())
        }

        binding.buttonStudyAgain.setOnClickListener {
            this.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToStudyFragment(args.vowelsChosenHira, args.kChosenHira, args.sChosenHira,
                args.tChosenHira, args.nChosenHira, args.hChosenHira, args.mChosenHira, args.yChosenHira, args.rChosenHira, args.wChosenHira, args.ChosenHira,
                args.gChosenHira, args.zChosenHira, args.dChosenHira, args.bChosenHira, args.pChosenHira, args.vowelsChosenKata, args.kChosenKata, args.sChosenKata,
                args.tChosenKata, args.nChosenKata, args.hChosenKata, args.mChosenKata, args.yChosenKata, args.rChosenKata, args.wChosenKata, args.ChosenKata,
                args.gChosenKata, args.zChosenKata, args.dChosenKata, args.bChosenKata, args.pChosenKata))
        }

        return binding.root
    }
}