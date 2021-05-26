package exercise.android.reemh.todo_items

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoHolder(view: View): RecyclerView.ViewHolder(view) {
    val text: TextView = view.findViewById(R.id.textView)
}
class TodoAdapter : RecyclerView.Adapter<TodoHolder>() {
    private val _todos: MutableList<TodoItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val context = parent.context
        val view = LayoutInflater.from(context)
                .inflate(R.layout.row_todo_item, parent, false)
        return TodoHolder(view)
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        val todoItem = _todos[position]
        holder.text.setText(todoItem.text)
    }

    override fun getItemCount(): Int {
        return _todos.size
    }

    fun setTodos(todos : List<TodoItem>) {
        _todos.clear()
        _todos.addAll(todos)
        notifyDataSetChanged()
    }

}