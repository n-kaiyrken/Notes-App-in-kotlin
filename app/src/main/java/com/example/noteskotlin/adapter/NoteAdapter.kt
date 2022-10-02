package com.example.noteskotlin.adapter

import android.annotation.SuppressLint
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteskotlin.R
import com.example.noteskotlin.databinding.ItemLayoutBinding
import com.example.noteskotlin.model.NotesModel
import com.example.noteskotlin.screens.start.StartFragment
import kotlinx.android.synthetic.main.fragment_add_note.view.*
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NotesModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = listNote[position].title
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NotesModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)
}