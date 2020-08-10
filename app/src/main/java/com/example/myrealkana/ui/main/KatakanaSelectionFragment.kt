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
import com.example.myrealkana.databinding.KatakanaSelectionFragmentBinding

class KatakanaSelectionFragment : Fragment() {
    private lateinit var binding: KatakanaSelectionFragmentBinding
    private lateinit var viewModel: KatakanaSelectionViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args = KatakanaSelectionFragmentArgs.fromBundle(requireArguments())
        val kanaArray = arrayOf(
            args.vowelsChosenHira,
            args.kChosenHira,
            args.sChosenHira,
            args.tChosenHira,
            args.nChosenHira,
            args.hChosenHira,
            args.mChosenHira,
            args.yChosenHira,
            args.rChosenHira,
            args.wChosenHira,
            args.ChosenHira,
            args.gChosenHira,
            args.zChosenHira,
            args.dChosenHira,
            args.bChosenHira,
            args.pChosenHira,
            KanaCharRep("a", false),
            KanaCharRep("k", false),
            KanaCharRep("s", false),
            KanaCharRep("t", false),
            KanaCharRep("n", false),
            KanaCharRep("h", false),
            KanaCharRep("m", false),
            KanaCharRep("r", false),
            KanaCharRep("y", false),
            KanaCharRep("w", false),
            KanaCharRep("N", false),
            KanaCharRep("g", false),
            KanaCharRep("z", false),
            KanaCharRep("d", false),
            KanaCharRep("b", false),
            KanaCharRep("p", false)
        )
        fun allUnselected(): Boolean {
            for (item in kanaArray) {
                if (item.isSelected) return false
            }

            return true
        }

        binding = DataBindingUtil.inflate(inflater, R.layout.katakana_selection_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(KatakanaSelectionViewModel::class.java)
        binding.viewModel = viewModel

        val kanaButtonMap = hashMapOf(
            KanaCharRep("a", false) to binding.checkBoxVowelKata,
            KanaCharRep("k", false) to binding.checkBoxKKata,
            KanaCharRep("s", false) to binding.checkBoxSKata,
            KanaCharRep("t", false) to binding.checkBoxTKata,
            KanaCharRep("n", false) to binding.checkBoxNKata,
            KanaCharRep("h", false) to binding.checkBoxHKata,
            KanaCharRep("m", false) to binding.checkBoxMKata,
            KanaCharRep("r", false) to binding.checkBoxRKata,
            KanaCharRep("y", false) to binding.checkBoxYKata,
            KanaCharRep("w", false) to binding.checkBoxWKata,
            KanaCharRep("N", false) to binding.checkBoxNCharKata,
            KanaCharRep("g", false) to binding.checkBoxGKata,
            KanaCharRep("z", false) to binding.checkBoxZKata,
            KanaCharRep("d", false) to binding.checkBoxDKata,
            KanaCharRep("b", false) to binding.checkBoxBKata,
            KanaCharRep("p", false) to binding.checkBoxPKata
        )

        for ((key, value) in viewModel.kanaMap) {
            value.observe(viewLifecycleOwner, Observer {
                kanaArray[kanaArray.indexOf(key)].isSelected = it
            })
        }

        for ((key, value) in kanaButtonMap) {
            value.setOnClickListener { viewModel.onCharClicked(key) }
        }

        binding.buttonPrevious.setOnClickListener {
            this.findNavController().navigate(KatakanaSelectionFragmentDirections.actionKatakanaSelectionFragmentToHiraganaSelectionFragment())
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

        viewModel.navigateToScoreFactor.observe(viewLifecycleOwner, Observer {
            if (it!!) {
                if (allUnselected()) {
                    val toast = Toast.makeText(context, "Select a column.", Toast.LENGTH_SHORT)
                    val view = toast.view
                    view.setBackgroundColor(resources.getColor(R.color.primaryColor))
                    toast.show()

                } else {
                    val action = KatakanaSelectionFragmentDirections.actionKatakanaSelectionFragmentToStudyFragment(
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
                        kanaArray[15],
                        kanaArray[16],
                        kanaArray[17],
                        kanaArray[18],
                        kanaArray[19],
                        kanaArray[20],
                        kanaArray[21],
                        kanaArray[22],
                        kanaArray[23],
                        kanaArray[24],
                        kanaArray[25],
                        kanaArray[26],
                        kanaArray[27],
                        kanaArray[28],
                        kanaArray[29],
                        kanaArray[30],
                        kanaArray[31]
                    )

                    this.findNavController().navigate(action)
                    viewModel.onNavigationDone()

                }
            }
        })

        return binding.root
    }
}