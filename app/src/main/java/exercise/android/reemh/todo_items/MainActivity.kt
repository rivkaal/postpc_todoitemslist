package exercise.android.reemh.todo_items

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var dataBase: TodoItemsDataBase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (dataBase == null) {
            dataBase = TodoItemsDataBaseImpl()
        }

        // TODO: implement the specs as defined below
        //    (find all UI components, hook them up, connect everything you need)
        val button = findViewById<FloatingActionButton>(R.id.buttonCreateTodoItem)
        val editText = findViewById<EditText>(R.id.editTextInsertTask)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTodoItemsList)
        val todoAdapter = TodoAdapter()
        todoAdapter.setTodos(dataBase!!.currentItems)
        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        button.setOnClickListener { v: View? ->
            val text = editText.text.toString()
            if (text !== "") {
                dataBase!!.addNewInProgressItem(text)
                todoAdapter.setTodos(dataBase!!.currentItems)
            }
        }
    }
}