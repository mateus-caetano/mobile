package com.mateus.todo.model

data class ToDo (
    val title: String,
    val description: String,
    val isSelected: Boolean = false
)

class ToDoBuilder {
    var title: String = ""
    var description: String = ""

    fun build() : ToDo = ToDo(title, description, false)
}

fun toDo(block: ToDoBuilder.() -> Unit) : ToDo = ToDoBuilder().apply(block).build()

fun mockData():MutableList<ToDo> = mutableListOf(
    toDo {
        title = "To do"
        description = "Algo a se fazer"
    },
    toDo {
        title = "To do"
        description = "Algo a se fazer"
    },
    toDo {
        title = "To do"
        description = "Algo a se fazer"
    },
    toDo {
        title = "To do"
        description = "Algo a se fazer"
    },
    toDo {
        title = "To do"
        description = "Algo a se fazer"
    }
)