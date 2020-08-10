package com.example.myrealkana.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrealkana.R
import java.lang.RuntimeException

class StudyViewModel(private val args: StudyFragmentArgs) : ViewModel() {
    private var _currentKana = MutableLiveData<KanaChar>()
    val currentLetter: LiveData<KanaChar>
        get() = _currentKana

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private var _total = MutableLiveData<Int>()
    val total: LiveData<Int>
        get() = _total

    private var _navigateToScoreFragment = MutableLiveData<Boolean>()
    val navigateToScoreFragment: LiveData<Boolean>
        get() = _navigateToScoreFragment

    private var _showRedX = MutableLiveData<Boolean>()
    val showRedX: LiveData<Boolean>
        get() = _showRedX

    private var _answerWrong = MutableLiveData<Boolean>()
    val answerWrong: LiveData<Boolean>
        get() = _answerWrong

    private var _listKana = MutableLiveData<MutableList<KanaChar>>()
    val listKana: LiveData<MutableList<KanaChar>>
        get() = _listKana

    init {
        initializeAndRandomizeList()
        _currentKana.value = _listKana.value!![0]
        _score.value = 0
        _total.value = 0
        _showRedX.value = false
        _answerWrong.value = false
        _navigateToScoreFragment.value = false
    }

    private fun initializeAndRandomizeList() {
        val kanaMap = hashMapOf(
            KanaCharRep("a", true) to
                    mutableListOf(KanaChar(listOf("a"), true), KanaChar(listOf("i"), true), KanaChar(listOf("u"), true), KanaChar(listOf("e"), true), KanaChar(listOf("o"), true)),

            KanaCharRep("k", true) to
                    mutableListOf(KanaChar(listOf("ka"), true), KanaChar(listOf("ki"), true), KanaChar(listOf("ku"), true), KanaChar(listOf("ke"), true), KanaChar(listOf("ko"), true)),

            KanaCharRep("s", true) to
                    mutableListOf(KanaChar(listOf("sa"), true), KanaChar(listOf("shi"), true), KanaChar(listOf("su"), true), KanaChar(listOf("se"), true), KanaChar(listOf("so"), true)),

            KanaCharRep("t", true) to
                    mutableListOf(KanaChar(listOf("ta"), true), KanaChar(listOf("chi"), true), KanaChar(listOf("tsu"), true), KanaChar(listOf("te"), true), KanaChar(listOf("to"), true)),

            KanaCharRep("n", true) to
                    mutableListOf(KanaChar(listOf("na"), true), KanaChar(listOf("ni"), true), KanaChar(listOf("nu"), true), KanaChar(listOf("ne"), true), KanaChar(listOf("no"), true)),

            KanaCharRep("h", true) to
                    mutableListOf(KanaChar(listOf("ha"), true), KanaChar(listOf("hi"), true), KanaChar(listOf("fu", "hu"), true), KanaChar(listOf("he"), true), KanaChar(listOf("ho"), true)),

            KanaCharRep("m", true) to
                    mutableListOf(KanaChar(listOf("ma"), true), KanaChar(listOf("mi"), true), KanaChar(listOf("mu"), true), KanaChar(listOf("me"), true), KanaChar(listOf("mo"), true)),

            KanaCharRep("r", true) to
                    mutableListOf(KanaChar(listOf("ra"), true), KanaChar(listOf("ri"), true), KanaChar(listOf("ru"), true), KanaChar(listOf("re"), true), KanaChar(listOf("ro"), true)),

            KanaCharRep("y", true) to
                    mutableListOf(KanaChar(listOf("ya"), true), KanaChar(listOf("yu"), true), KanaChar(listOf("yo"), true)),

            KanaCharRep("w", true) to
                    mutableListOf(KanaChar(listOf("wa"), true), KanaChar(listOf("wo", "o"), true)),

            KanaCharRep("N", true) to
                    mutableListOf(KanaChar(listOf("n"), true)),

            KanaCharRep("g", true) to
                    mutableListOf(KanaChar(listOf("ga"), true), KanaChar(listOf("gi"), true), KanaChar(listOf("gu"), true), KanaChar(listOf("ge"), true), KanaChar(listOf("go"), true)),

            KanaCharRep("z", true) to
                    mutableListOf(KanaChar(listOf("za"), true), KanaChar(listOf("ji"), true), KanaChar(listOf("zu"), true), KanaChar(listOf("ze"), true), KanaChar(listOf("zo"), true)),

            KanaCharRep("d", true) to
                    mutableListOf(KanaChar(listOf("da"), true), KanaChar(listOf("dzu", "du", "zu"), true), KanaChar(listOf("de"), true), KanaChar(listOf("do"), true)),

            KanaCharRep("b", true) to
                    mutableListOf(KanaChar(listOf("ba"), true), KanaChar(listOf("bi"), true), KanaChar(listOf("bu"), true), KanaChar(listOf("be"), true), KanaChar(listOf("bo"), true)),

            KanaCharRep("p", true) to
                    mutableListOf(KanaChar(listOf("pa"), true), KanaChar(listOf("pi"), true), KanaChar(listOf("pu"), true), KanaChar(listOf("pe"), true), KanaChar(listOf("po"), true)),


            KanaCharRep("a", false) to
                    mutableListOf(KanaChar(listOf("a"), false), KanaChar(listOf("i"), false), KanaChar(listOf("u"), false), KanaChar(listOf("e"), false), KanaChar(listOf("o"), false)),

            KanaCharRep("k", false) to
                    mutableListOf(KanaChar(listOf("ka"), false), KanaChar(listOf("ki"), false), KanaChar(listOf("ku"), false), KanaChar(listOf("ke"), false), KanaChar(listOf("ko"), false)),

            KanaCharRep("s", false) to
                    mutableListOf(KanaChar(listOf("sa"), false), KanaChar(listOf("shi"), false), KanaChar(listOf("su"), false), KanaChar(listOf("se"), false), KanaChar(listOf("so"), false)),

            KanaCharRep("t", false) to
                    mutableListOf(KanaChar(listOf("ta"), false), KanaChar(listOf("chi"), false), KanaChar(listOf("tsu"), false), KanaChar(listOf("te"), false), KanaChar(listOf("to"), false)),

            KanaCharRep("n", false) to
                    mutableListOf(KanaChar(listOf("na"), false), KanaChar(listOf("ni"), false), KanaChar(listOf("nu"), false), KanaChar(listOf("ne"), false), KanaChar(listOf("no"), false)),

            KanaCharRep("h", false) to
                    mutableListOf(KanaChar(listOf("ha"), false), KanaChar(listOf("hi"), false), KanaChar(listOf("fu", "hu"), false), KanaChar(listOf("he"), false), KanaChar(listOf("ho"), false)),

            KanaCharRep("m", false) to
                    mutableListOf(KanaChar(listOf("ma"), false), KanaChar(listOf("mi"), false), KanaChar(listOf("mu"), false), KanaChar(listOf("me"), false), KanaChar(listOf("mo"), false)),

            KanaCharRep("r", false) to
                    mutableListOf(KanaChar(listOf("ra"), false), KanaChar(listOf("ri"), false), KanaChar(listOf("ru"), false), KanaChar(listOf("re"), false), KanaChar(listOf("ro"), false)),

            KanaCharRep("y", false) to
                    mutableListOf(KanaChar(listOf("ya"), false), KanaChar(listOf("yu"), false), KanaChar(listOf("yo"), false)),

            KanaCharRep("w", false) to
                    mutableListOf(KanaChar(listOf("wa"), false), KanaChar(listOf("wo", "o"), false)),

            KanaCharRep("N", false) to
                    mutableListOf(KanaChar(listOf("n"), false)),

            KanaCharRep("g", false) to
                    mutableListOf(KanaChar(listOf("ga"), false), KanaChar(listOf("gi"), false), KanaChar(listOf("gu"), false), KanaChar(listOf("ge"), false), KanaChar(listOf("go"), false)),

            KanaCharRep("z", false) to
                    mutableListOf(KanaChar(listOf("za"), false), KanaChar(listOf("ji"), false), KanaChar(listOf("zu"), false), KanaChar(listOf("ze"), false), KanaChar(listOf("zo"), false)),

            KanaCharRep("d", false) to
                    mutableListOf(KanaChar(listOf("da"), false), KanaChar(listOf("dzu", "du", "zu"), false), KanaChar(listOf("de"), false), KanaChar(listOf("do"), false)),

            KanaCharRep("b", false) to
                    mutableListOf(KanaChar(listOf("ba"), false), KanaChar(listOf("bi"), false), KanaChar(listOf("bu"), false), KanaChar(listOf("be"), false), KanaChar(listOf("bo"), false)),

            KanaCharRep("p", false) to
                    mutableListOf(KanaChar(listOf("pa"), false), KanaChar(listOf("pi"), false), KanaChar(listOf("pu"), false), KanaChar(listOf("pe"), false), KanaChar(listOf("po"), false))
        )

        val repList = listOf(args.vowelsChosenHira, args.kChosenHira, args.sChosenHira, args.tChosenHira,
            args.nChosenHira, args.hChosenHira, args.mChosenHira, args.yChosenHira, args.rChosenHira, args.wChosenHira,
            args.ChosenHira, args.gChosenHira, args.zChosenHira, args.dChosenHira, args.bChosenHira, args.pChosenHira,

            args.vowelsChosenKata, args.kChosenKata, args.sChosenKata, args.tChosenKata,
            args.nChosenKata, args.hChosenKata, args.mChosenKata, args.yChosenKata, args.rChosenKata, args.wChosenKata,
            args.ChosenKata, args.gChosenKata, args.zChosenKata, args.dChosenKata, args.bChosenKata, args.pChosenKata)

        val toReturn: MutableList<KanaChar> = mutableListOf()
        for (charRep in repList) {
            if (charRep.isSelected) {
                val charLst = kanaMap[charRep]!!
                for (char in charLst) toReturn.add(char)
            }
        }

        _listKana.value = toReturn
        _listKana.value!!.shuffle()
    }

    fun displayLetter(): Int {
        return when (_currentKana.value) {
            KanaChar(listOf("a"), true) -> R.drawable.ic_a_hiragana
            KanaChar(listOf("i"), true) -> R.drawable.ic_i_hiragana
            KanaChar(listOf("u"), true) -> R.drawable.ic_u_hiragana
            KanaChar(listOf("e"), true) -> R.drawable.ic_e_hiragana
            KanaChar(listOf("o"), true) -> R.drawable.ic_o_hiragana
            KanaChar(listOf("ka"), true) -> R.drawable.ic_ka_hiragana
            KanaChar(listOf("ki"), true) -> R.drawable.ic_ki_hiragana
            KanaChar(listOf("ku"), true) -> R.drawable.ic_ku_hiragana
            KanaChar(listOf("ke"), true) -> R.drawable.ic_ke_hiragana
            KanaChar(listOf("ko"), true) -> R.drawable.ic_ko_hiragana
            KanaChar(listOf("sa"), true) -> R.drawable.ic_sa_hiragana
            KanaChar(listOf("shi"), true) -> R.drawable.ic_shi_hiragana
            KanaChar(listOf("su"), true) -> R.drawable.ic_su_hiragana
            KanaChar(listOf("se"), true) -> R.drawable.ic_se_hiragana
            KanaChar(listOf("so"), true) -> R.drawable.ic_so_hiragana
            KanaChar(listOf("ta"), true) -> R.drawable.ic_ta_hiragana
            KanaChar(listOf("chi"), true) -> R.drawable.ic_chi_hiragana
            KanaChar(listOf("tsu"), true) -> R.drawable.ic_tsu_hiragana
            KanaChar(listOf("te"), true) -> R.drawable.ic_te_hiragana
            KanaChar(listOf("to"), true) -> R.drawable.ic_to_hiragana
            KanaChar(listOf("na"), true) -> R.drawable.ic_na_hiragana
            KanaChar(listOf("ni"), true) -> R.drawable.ic_ni_hiragana
            KanaChar(listOf("nu"), true) -> R.drawable.ic_nu_hiragana
            KanaChar(listOf("ne"), true) -> R.drawable.ic_ne_hiragana
            KanaChar(listOf("no"), true) -> R.drawable.ic_no_hiragana
            KanaChar(listOf("ha"), true) -> R.drawable.ic_ha_hiragana
            KanaChar(listOf("hi"), true) -> R.drawable.ic_hi_hiragana
            KanaChar(listOf("fu", "hu"), true) -> R.drawable.ic_fu_hiragana
            KanaChar(listOf("he"), true) -> R.drawable.ic_he_hiragana
            KanaChar(listOf("ho"), true) -> R.drawable.ic_ho_hiragana
            KanaChar(listOf("ma"), true) -> R.drawable.ic_ma_hiragana
            KanaChar(listOf("mi"), true) -> R.drawable.ic_mi_hiragana
            KanaChar(listOf("mu"), true) -> R.drawable.ic_mu_hiragana
            KanaChar(listOf("me"), true) -> R.drawable.ic_me_hiragana
            KanaChar(listOf("mo"), true) -> R.drawable.ic_mo_hiragana
            KanaChar(listOf("ya"), true) -> R.drawable.ic_ya_hiragana
            KanaChar(listOf("yu"), true) -> R.drawable.ic_yu_hiragana
            KanaChar(listOf("yo"), true) -> R.drawable.ic_yo_hiragana
            KanaChar(listOf("ra"), true) -> R.drawable.ic_ra_hiragana
            KanaChar(listOf("ri"), true) -> R.drawable.ic_ri_hiragana
            KanaChar(listOf("ru"), true) -> R.drawable.ic_ru_hiragana
            KanaChar(listOf("re"), true) -> R.drawable.ic_re_hiragana
            KanaChar(listOf("ro"), true) -> R.drawable.ic_ro_hiragana
            KanaChar(listOf("wa"), true) -> R.drawable.ic_wa_hiragana
            KanaChar(listOf("wo", "o"), true) -> R.drawable.ic_wo_hiragana
            KanaChar(listOf("n"), true) -> R.drawable.ic_n_hiragana
            KanaChar(listOf("ga"), true) -> R.drawable.ic_ga_hiragana
            KanaChar(listOf("gi"), true) -> R.drawable.ic_gi_hiragana
            KanaChar(listOf("gu"), true) -> R.drawable.ic_gu_hiragana
            KanaChar(listOf("ge"), true) -> R.drawable.ic_ge_hiragana
            KanaChar(listOf("go"), true) -> R.drawable.ic_go_hiragana
            KanaChar(listOf("za"), true) -> R.drawable.ic_za_hiragana
            KanaChar(listOf("ji"), true) -> R.drawable.ic_ji_hiragana
            KanaChar(listOf("zu"), true) -> R.drawable.ic_zu_hiragana
            KanaChar(listOf("ze"), true) -> R.drawable.ic_ze_hiragana
            KanaChar(listOf("zo"), true) -> R.drawable.ic_zo_hiragana
            KanaChar(listOf("da"), true) -> R.drawable.ic_da_hiragana
            KanaChar(listOf("dzu", "du", "zu"), true) -> R.drawable.ic_dzu_hiragana
            KanaChar(listOf("de"), true) -> R.drawable.ic_de_hiragana
            KanaChar(listOf("do"), true) -> R.drawable.ic_do_hiragana
            KanaChar(listOf("ba"), true) -> R.drawable.ic_ba_hiragana
            KanaChar(listOf("bi"), true) -> R.drawable.ic_bi_hiragana
            KanaChar(listOf("bu"), true) -> R.drawable.ic_bu_hiragana
            KanaChar(listOf("be"), true) -> R.drawable.ic_be_hiragana
            KanaChar(listOf("bo"), true) -> R.drawable.ic_bo_hiragana
            KanaChar(listOf("pa"), true) -> R.drawable.ic_pa_hiragana
            KanaChar(listOf("pi"), true) -> R.drawable.ic_pi_hiragana
            KanaChar(listOf("pu"), true) -> R.drawable.ic_pu_hiragana
            KanaChar(listOf("pe"), true) -> R.drawable.ic_pe_hiragana
            KanaChar(listOf("po"), true) -> R.drawable.ic_po_hiragana

            KanaChar(listOf("a"), false) -> R.drawable.ic_a_katakana
            KanaChar(listOf("i"), false) -> R.drawable.ic_i_katakana
            KanaChar(listOf("u"), false) -> R.drawable.ic_u_katakana
            KanaChar(listOf("e"), false) -> R.drawable.ic_e_katakana
            KanaChar(listOf("o"), false) -> R.drawable.ic_o_katakana
            KanaChar(listOf("ka"), false) -> R.drawable.ic_ka_katakana
            KanaChar(listOf("ki"), false) -> R.drawable.ic_ki_katakana
            KanaChar(listOf("ku"), false) -> R.drawable.ic_ku_katakana
            KanaChar(listOf("ke"), false) -> R.drawable.ic_ke_katakana
            KanaChar(listOf("ko"), false) -> R.drawable.ic_ko_katakana
            KanaChar(listOf("sa"), false) -> R.drawable.ic_sa_katakana
            KanaChar(listOf("shi"), false) -> R.drawable.ic_shi_katakana
            KanaChar(listOf("su"), false) -> R.drawable.ic_su_katakana
            KanaChar(listOf("se"), false) -> R.drawable.ic_se_katakana
            KanaChar(listOf("so"), false) -> R.drawable.ic_so_katakana
            KanaChar(listOf("ta"), false) -> R.drawable.ic_ta_katakana
            KanaChar(listOf("chi"), false) -> R.drawable.ic_chi_katakana
            KanaChar(listOf("tsu"), false) -> R.drawable.ic_tsu_katakana
            KanaChar(listOf("te"), false) -> R.drawable.ic_te_katakana
            KanaChar(listOf("to"), false) -> R.drawable.ic_to_katakana
            KanaChar(listOf("na"), false) -> R.drawable.ic_na_katakana
            KanaChar(listOf("ni"), false) -> R.drawable.ic_ni_katakana
            KanaChar(listOf("nu"), false) -> R.drawable.ic_nu_katakana
            KanaChar(listOf("ne"), false) -> R.drawable.ic_ne_katakana
            KanaChar(listOf("no"), false) -> R.drawable.ic_no_katakana
            KanaChar(listOf("ha"), false) -> R.drawable.ic_ha_katakana
            KanaChar(listOf("hi"), false) -> R.drawable.ic_hi_katakana
            KanaChar(listOf("fu", "hu"), false) -> R.drawable.ic_fu_katakana
            KanaChar(listOf("he"), false) -> R.drawable.ic_he_katakana
            KanaChar(listOf("ho"), false) -> R.drawable.ic_ho_katakana
            KanaChar(listOf("ma"), false) -> R.drawable.ic_ma_katakana
            KanaChar(listOf("mi"), false) -> R.drawable.ic_mi_katakana
            KanaChar(listOf("mu"), false) -> R.drawable.ic_mu_katakana
            KanaChar(listOf("me"), false) -> R.drawable.ic_me_katakana
            KanaChar(listOf("mo"), false) -> R.drawable.ic_mo_katakana
            KanaChar(listOf("ya"), false) -> R.drawable.ic_ya_katakana
            KanaChar(listOf("yu"), false) -> R.drawable.ic_yu_katakana
            KanaChar(listOf("yo"), false) -> R.drawable.ic_yo_katakana
            KanaChar(listOf("ra"), false) -> R.drawable.ic_ra_katakana
            KanaChar(listOf("ri"), false) -> R.drawable.ic_ri_katakana
            KanaChar(listOf("ru"), false) -> R.drawable.ic_ru_katakana
            KanaChar(listOf("re"), false) -> R.drawable.ic_re_katakana
            KanaChar(listOf("ro"), false) -> R.drawable.ic_ro_katakana
            KanaChar(listOf("wa"), false) -> R.drawable.ic_wa_katakana
            KanaChar(listOf("wo", "o"), false) -> R.drawable.ic_wo_katakana
            KanaChar(listOf("n"), false) -> R.drawable.ic_n_katakana
            KanaChar(listOf("ga"), false) -> R.drawable.ic_ga_katakana
            KanaChar(listOf("gi"), false) -> R.drawable.ic_gi_katakana
            KanaChar(listOf("gu"), false) -> R.drawable.ic_gu_katakana
            KanaChar(listOf("ge"), false) -> R.drawable.ic_ge_katakana
            KanaChar(listOf("go"), false) -> R.drawable.ic_go_katakana
            KanaChar(listOf("za"), false) -> R.drawable.ic_za_katakana
            KanaChar(listOf("ji"), false) -> R.drawable.ic_ji_katakana
            KanaChar(listOf("zu"), false) -> R.drawable.ic_zu_katakana
            KanaChar(listOf("ze"), false) -> R.drawable.ic_ze_katakana
            KanaChar(listOf("zo"), false) -> R.drawable.ic_zo_katakana
            KanaChar(listOf("da"), false) -> R.drawable.ic_da_katakana
            KanaChar(listOf("dzu", "du", "zu"), false) -> R.drawable.ic_dzu_katakana
            KanaChar(listOf("de"), false) -> R.drawable.ic_de_katakana
            KanaChar(listOf("do"), false) -> R.drawable.ic_do_katakana
            KanaChar(listOf("ba"), false) -> R.drawable.ic_ba_katakana
            KanaChar(listOf("bi"), false) -> R.drawable.ic_bi_katakana
            KanaChar(listOf("bu"), false) -> R.drawable.ic_bu_katakana
            KanaChar(listOf("be"), false) -> R.drawable.ic_be_katakana
            KanaChar(listOf("bo"), false) -> R.drawable.ic_bo_katakana
            KanaChar(listOf("pa"), false) -> R.drawable.ic_pa_katakana
            KanaChar(listOf("pi"), false) -> R.drawable.ic_pi_katakana
            KanaChar(listOf("pu"), false) -> R.drawable.ic_pu_katakana
            KanaChar(listOf("pe"), false) -> R.drawable.ic_pe_katakana
            KanaChar(listOf("po"), false) -> R.drawable.ic_po_katakana
            else -> throw RuntimeException("Letter not found.")
        }
    }

    fun onAnswerButtonClicked(answer: String) {
        if (_currentKana.value!!.readings.contains(answer)) {
            if (!_answerWrong.value!!) {
                _score.value = _score.value!!.plus(1)
            }

            _listKana.value!!.removeAt(0)
            _total.value = _total.value!!.plus(1)
            _showRedX.value = false
            _answerWrong.value = false

            if (_listKana.value!!.isEmpty()) {
                _navigateToScoreFragment.value = true
            } else {
                val next = _listKana.value!![0]
                _currentKana.value = next
            }
        } else {
            _showRedX.value = true
            _answerWrong.value = true
        }

    }

    fun onNavigationDone() {
        _navigateToScoreFragment.value = false
    }
}