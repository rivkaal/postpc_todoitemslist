package exercise.android.reemh.todo_items;

import java.io.Serializable;

public class TodoItem implements Serializable {
  String text;

  public TodoItem(String str)
  {
    text = str;
  }

  public TodoItem()
  {
  }
}


