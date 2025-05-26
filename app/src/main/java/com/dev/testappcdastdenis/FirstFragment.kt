package com.dev.testappcdastdenis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class FirstFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val editText = view.findViewById<EditText>(R.id.edit_text_input)
        val button = view.findViewById<Button>(R.id.btn_next)

        button.setOnClickListener {
            val input = editText.text.toString()
            viewModel.setUserText(input)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
