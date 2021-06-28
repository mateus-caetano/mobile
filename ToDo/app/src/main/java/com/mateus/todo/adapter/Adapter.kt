package com.mateus.todo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateus.todo.R
import com.mateus.todo.model.ToDo
import com.mateus.todo.model.mockData

class Adapter(private val toDos: MutableList<ToDo>) : RecyclerView.Adapter<Adapter.ToDoViewHolder>() {
    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val description: TextView

        init {
            title = itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val toDo = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ToDoViewHolder(toDo)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.title.text = mockData()[position].title
        holder.description.text = mockData()[position].description
    }

    override fun getItemCount() : Int = toDos.size
}