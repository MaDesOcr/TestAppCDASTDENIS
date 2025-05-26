package com.dev.testappcdastdenis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class SecondFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val textView = view.findViewById<TextView>(R.id.text_display)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        viewModel.userText.observe(viewLifecycleOwner) { text ->
            textView.text = text
        }

        return view
    }
}
