package com.example.navigation

import com.example.navigation.models.NoteInfo
import com.example.navigation.models.TaskInfo

class ObjectsList {
    companion object {
        val tasksList: MutableList<TaskInfo> = mutableListOf()
        val notesList: MutableList<NoteInfo> = mutableListOf()

    }
}