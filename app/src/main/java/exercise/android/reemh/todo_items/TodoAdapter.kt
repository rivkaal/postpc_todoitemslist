package exercise.android.reemh.todo_items

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoHolder(view: View): RecyclerView.ViewHolder(view) {
    val text: TextView = view.findViewById(R.id.textView)
    val checkBox: CheckBox = view.findViewById(R.id.checkBox)
}
class TodoAdapter(context: MainActivity) : RecyclerView.Adapter<TodoHolder>() {
//    private val _todos: MutableList<TodoItem> = ArrayList()
    private val _context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        val context = parent.context
        val view = LayoutInflater.from(context)
                .inflate(R.layout.row_todo_item, parent, false)
        return TodoHolder(view)
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        val todoItem = _context.dataBase!!.currentItems[position]
        holder.text.setText(todoItem.text)
        holder.checkBox.isChecked = !todoItem.inProgress
        holder.checkBox.setOnClickListener {
            if (todoItem.inProgress)
            {
                _context.dataBase!!.markItemDone(todoItem)
            } else {
                _context.dataBase!!.markItemInProgress(todoItem)
            }
            notifyDataSetChanged()
        }
        holder.text.setOnLongClickListener {
            _context.dataBase!!.deleteItem(todoItem)
            notifyDataSetChanged()
            true
        }
    }

    override fun getItemCount(): Int {
        return _context.dataBase!!.currentItems.size
    }


}