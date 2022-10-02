package com.example.noteskotlin.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.noteskotlin.APP
import com.example.noteskotlin.R
import com.example.noteskotlin.adapter.NoteAdapter
import com.example.noteskotlin.databinding.FragmentStartBinding
import com.example.noteskotlin.model.NotesModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.recyclerViewNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter

        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNote ->
            adapter.setList(listNote.asReversed())
        }

        binding.buttonAdd.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    companion object{
        fun clickNote(note: NotesModel){
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP.navController.navigate(R.id.action_startFragment_to_detailsFragment, bundle)
        }
    }



}