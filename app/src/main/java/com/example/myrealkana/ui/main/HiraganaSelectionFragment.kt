package com.example.myrealkana.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myrealkana.R
import com.example.myrealkana.databinding.HiraganaSelectionFragmentBinding

class HiraganaSelectionFragment : Fragment() {
    private lateinit var binding: HiraganaSelectionFragmentBinding
    private lateinit var viewModel: HiraganaSelectionViewModel
    private val kanaArray = arrayOf(
        KanaCharRep("a", true),
        KanaCharRep("k", true),
        KanaCharRep("s", true),
        KanaCharRep("t", true),
        KanaCharRep("n", true),
        KanaCharRep("h", true),
        KanaCharRep("m", true),
        KanaCharRep("r", true),
        KanaCharRep("y", true),
        KanaCharRep("w", true),
        KanaCharRep("N", true),
        KanaCharRep("g", true),
        KanaCharRep("z", true),
        KanaCharRep("d", true),
        KanaCharRep("b", true),
        KanaCharRep("p", true)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.hiragana_selection_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HiraganaSelectionViewModel::class.java)
        binding.viewModel = viewModel

        val kanaButtonMap = hashMapOf(
            KanaCharRep("a", true) to binding.checkBoxVowel,
            KanaCharRep("k", true) to binding.checkBoxK,
            KanaCharRep("s", true) to binding.checkBoxS,
            KanaCharRep("t", true) to binding.checkBoxT,
            KanaCharRep("n", true) to binding.checkBoxN,
            KanaCharRep("h", true) to binding.checkBoxH,
            KanaCharRep("m", true) to binding.checkBoxM,
            KanaCharRep("r", true) to binding.checkBoxR,
            KanaCharRep("y", true) to binding.checkBoxY,
            KanaCharRep("w", true) to binding.checkBoxW,
            KanaCharRep("N", true) to binding.checkBoxNChar,
            KanaCharRep("g", true) to binding.checkBoxG,
            KanaCharRep("z", true) to binding.checkBoxZ,
            KanaCharRep("d", true) to binding.checkBoxD,
            KanaCharRep("b", true) to binding.checkBoxB,
            KanaCharRep("p", true) to binding.checkBoxP
        )

        for ((key, value) in viewModel.kanaMap) {
            value.observe(viewLifecycleOwner, Observer {
                kanaArray[kanaArray.indexOf(key)].isSelected = it
            })
        }

        for ((key, value) in kanaButtonMap) {
            value.setOnClickListener { viewModel.onCharClicked(key) }
        }

        binding.buttonSelectAll.setOnClickListener {
            viewModel.onSelectAllClicked()
            for ((_, value) in kanaButtonMap) {
                value.isChecked = true
            }

            binding.buttonSelectAll.visibility = View.INVISIBLE
            binding.buttonClearAll.visibility = View.VISIBLE
        }

        binding.buttonClearAll.setOnClickListener {
            viewModel.onClearAllClicked()
            for ((_, value) in kanaButtonMap) {
                value.isChecked = false
            }

            binding.buttonSelectAll.visibility = View.VISIBLE
            binding.buttonClearAll.visibility = View.INVISIBLE
        }

        viewModel.navigateToKatakanaFrag.observe(viewLifecycleOwner, Observer {
            if (it!!) {
                val action = HiraganaSelectionFragmentDirections.actionHiraganaSelectionFragmentToKatakanaSelectionFragment(
                    kanaArray[0],
                    kanaArray[1],
                    kanaArray[2],
                    kanaArray[3],
                    kanaArray[4],
                    kanaArray[5],
                    kanaArray[6],
                    kanaArray[7],
                    kanaArray[8],
                    kanaArray[9],
                    kanaArray[10],
                    kanaArray[11],
                    kanaArray[12],
                    kanaArray[13],
                    kanaArray[14],
                    kanaArray[15]
                )

                this.findNavController().navigate(action)
                viewModel.onNavigationDone()
            }
        })

        return binding.root
    }
}