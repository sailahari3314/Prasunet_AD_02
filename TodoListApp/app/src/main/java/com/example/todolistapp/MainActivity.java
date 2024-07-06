
package com.example.todolistapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> tasks;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editTextTask);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TaskAdapter(tasks, this);
        recyclerView.setAdapter(adapter);
    }

    public void addTask(View view) {
        String task = editText.getText().toString();
        if (!task.isEmpty()) {
            tasks.add(task);
            editText.setText("");
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
