package com.example.noteskotlin.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.noteskotlin.APP
import com.example.noteskotlin.R
import com.example.noteskotlin.databinding.FragmentAddNoteBinding
import com.example.noteskotlin.model.NotesModel

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.buttonAddNote.setOnClickListener{
            val title = binding.editTextAddTitle.text.toString()
            val desc = binding.editTextAddDescription.text.toString()
            viewModel.insert(NotesModel(title = title, description = desc)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
        binding.buttonBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }

}