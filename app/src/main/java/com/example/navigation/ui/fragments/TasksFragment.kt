package com.example.navigation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigation.ObjectsList
import com.example.navigation.databinding.FragmentTasksBinding
import com.example.navigation.interfaces.OnItemDeleted
import com.example.navigation.adapter.TaskRecyclerAdapter

class TasksFragment : Fragment(), OnItemDeleted {

    private lateinit var binding: FragmentTasksBinding
    private val tasks: MutableList<String> = mutableListOf()
    private var saveText = ""
    private val recyclerAdapter: TaskRecyclerAdapter = TaskRecyclerAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    override fun onItemDeleted(position: Int) {
        tasks.removeAt(position)
        recyclerAdapter.notifyItemRemoved(position)
    }

    private fun initViews() {
        binding.buttonAdd.setOnClickListener {
            showAddDialog()
        }
        binding.recylcerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun showAddDialog() {
        val editText: EditText = EditText(requireContext())
        val dialog: AlertDialog = AlertDialog.Builder(requireContext()).apply {
            setTitle("Añadir tarea")
            setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            setPositiveButton("Agregar") { dialog, _ ->
                saveText = editText.text.toString()
                //En este punto necesito agregar a la lista de task un nuevo task con la info que acabo de generar del bello diálogo

            }
            setView(editText)
        }.create()
        dialog.show()
    }
}