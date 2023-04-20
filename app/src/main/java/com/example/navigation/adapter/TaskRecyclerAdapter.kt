package com.example.navigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.navigation.ObjectsList
import com.example.navigation.R
import com.example.navigation.interfaces.OnItemDeleted
import com.example.navigation.models.TaskInfo

class TaskRecyclerAdapter(
    private val onItemDeleted: OnItemDeleted
) :
    Adapter<TaskRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewContent.text = ObjectsList.tasksList[position].content

        viewHolder.deleteButton.setOnClickListener {
            onItemDeleted.onItemDeleted(position)
        }
    }

    override fun getItemCount(): Int = ObjectsList.tasksList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewContent: TextView
        val deleteButton: ImageButton

        init {
            textViewContent = itemView.findViewById(R.id.textView_content)
            deleteButton = itemView.findViewById(R.id.imageButton_delete)
        }
    }
}