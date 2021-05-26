package exercise.android.reemh.todo_items;

import java.io.Serializable;

public class TodoItem implements Serializable {
  String text;
  boolean inProgress = true;

  public TodoItem(String str)
  {
    text = str;
  }

  public TodoItem()
  {
  }
}


