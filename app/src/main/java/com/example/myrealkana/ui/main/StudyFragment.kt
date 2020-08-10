package com.example.myrealkana.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBinderMapper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myrealkana.R
import com.example.myrealkana.databinding.StudyFragmentBinding

class StudyFragment : Fragment() {
    private lateinit var binding: StudyFragmentBinding
    private lateinit var viewModel: StudyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.study_fragment, container, false)
        val viewModelFactory = StudyViewModelFactory(StudyFragmentArgs.fromBundle(requireArguments()))
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StudyViewModel::class.java)
        binding.viewModel = viewModel

        binding.buttonAnswer.setOnClickListener {
            viewModel.onAnswerButtonClicked(binding.inputText.text.toString())

            if (!viewModel.answerWrong.value!!) {
                binding.inputText.text.clear()
            }
        }

        viewModel.currentLetter.observe(viewLifecycleOwner, Observer {
            binding.displayImage.setImageResource(viewModel.displayLetter())
        })

        viewModel.score.observe(viewLifecycleOwner, Observer {
            binding.score.text = it.toString()
        })

        viewModel.total.observe(viewLifecycleOwner, Observer {
            binding.total.text = it.toString()
        })

        viewModel.showRedX.observe(viewLifecycleOwner, Observer {
            if (it!!) {
                binding.inputText.setText(viewModel.currentLetter.value!!.readings[0])
                binding.redX.visibility = View.VISIBLE
            } else {
                binding.redX.visibility = View.INVISIBLE
            }
        })

        viewModel.navigateToScoreFragment.observe(viewLifecycleOwner, Observer {
            if (it!!) {
                val score = viewModel.score.value!!
                val total = viewModel.total.value!!
                val args = StudyFragmentArgs.fromBundle(requireArguments())
                val action = StudyFragmentDirections.actionStudyFragmentToScoreFragment(score, total, args.vowelsChosenHira, args.kChosenHira, args.sChosenHira,
                args.tChosenHira, args.nChosenHira, args.hChosenHira, args.mChosenHira, args.yChosenHira, args.rChosenHira, args.wChosenHira, args.ChosenHira,
                args.gChosenHira, args.zChosenHira, args.dChosenHira, args.bChosenHira, args.pChosenHira, args.vowelsChosenKata, args.kChosenKata, args.sChosenKata,
                    args.tChosenKata, args.nChosenKata, args.hChosenKata, args.mChosenKata, args.yChosenKata, args.rChosenKata, args.wChosenKata, args.ChosenKata,
                    args.gChosenKata, args.zChosenKata, args.dChosenKata, args.bChosenKata, args.pChosenKata)
                this.findNavController().navigate(action)
                viewModel.onNavigationDone()
            }
        })

        return binding.root
    }


}