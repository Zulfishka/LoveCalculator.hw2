package com.example.lovecalculatorhw2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculatorhw2.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getData()
    }

    private fun getData() = with(binding) {
        btnCalculate.setOnClickListener {
            viewModel.getLiveData(FnameET.text.toString(), SnameET.text.toString())
                .observe(this@FirstFragment, Observer {
                    Log.e("ololo", "onResponse: $it")
                    findNavController().navigate(R.id.SecondFragment, bundleOf(RESPONSE_BODY to it))
                })
        }
    }

    companion object {
        const val RESPONSE_BODY = "response_body.result"
    }
}