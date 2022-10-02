package com.example.noteskotlin.screens.details

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.example.noteskotlin.APP
import com.example.noteskotlin.R
import com.example.noteskotlin.databinding.FragmentDetailsBinding
import com.example.noteskotlin.model.NotesModel

class DetailsFragment : Fragment() {


    lateinit var binding: FragmentDetailsBinding
    lateinit var note: NotesModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        note = arguments?.getSerializable("note") as NotesModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding.textViewTitleDetail.text = note.title
        binding.textViewDescriptionDetail.text = note.description

        binding.buttonBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
        binding.buttonDelete.setOnClickListener{
            viewModel.delete(note){}
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
    }

}