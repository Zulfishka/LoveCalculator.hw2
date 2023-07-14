package com.example.lovecalculatorhw2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculatorhw2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getResult()
    }

    private fun getResult() = with(binding) {
        val result = arguments?.getSerializable(FirstFragment.RESPONSE_BODY) as LoveModel
        result.let {
            this.fnameTv.setText(it.firstName)
            this.snameTv.setText(it.secondName)
            this.percentageTv.setText(it.percentage)
            this.resultTv.setText(it.result)
        }
    }
}