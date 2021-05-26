package exercise.android.reemh.todo_items

// TODO: implement!
class TodoItemsDataBaseImpl : TodoItemsDataBase {

    override val currentItems: ArrayList<TodoItem> = arrayListOf()
//        get() = TODO("Not yet implemented")

    override fun addNewInProgressItem(description: String?) {
        val todoItem = TodoItem(description)
        currentItems.add(0, todoItem)
    }

    override fun markItemDone(item: TodoItem?) {
        item?.inProgress = false
        currentItems.remove(item)
        if (item != null) {
            currentItems.add(item)
        }
    }
    override fun markItemInProgress(item: TodoItem?) {
        item?.inProgress = true
        currentItems.remove(item)
        if (item != null) {
            currentItems.add(0, item)
        }
    }
    override fun deleteItem(item: TodoItem?) {
        currentItems.remove(item)
    }
}