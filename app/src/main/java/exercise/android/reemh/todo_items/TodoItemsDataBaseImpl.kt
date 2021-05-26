package exercise.android.reemh.todo_items

// TODO: implement!
class TodoItemsDataBaseImpl : TodoItemsDataBase {

    override val currentItems: MutableList<TodoItem> = mutableListOf()
//        get() = TODO("Not yet implemented")

    override fun addNewInProgressItem(description: String?) {
        val todoItem = TodoItem(description)
        currentItems.add(todoItem)

    }

    override fun markItemDone(item: TodoItem?) {}
    override fun markItemInProgress(item: TodoItem?) {}
    override fun deleteItem(item: TodoItem?) {}
}