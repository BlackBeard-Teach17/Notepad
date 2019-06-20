package com.example.notepad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

 //   private ArrayAdapter<NoteInfo> mAdapterNotes;    related to list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteListActivity.this, NoteActivity.class));
            }
        });

        initializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mAdapterNotes.notifyDataSetChanged(); related to list view
    }

    private void initializeDisplayContent() {
  /*      final ListView listNotes = (ListView) findViewById(R.id.list_notes);//marked as final in order to reference it in our anonymous class

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mAdapterNotes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listNotes.setAdapter(mAdapterNotes);//used to populate the view with list notes

        //Handles when a user clicks on a list item and then packages it using putExtra and sent to note activity
        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Rather than clatter a class with numerous interfaces int's implementing, when can use an anonymous in place
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //The below intent is used to parse which activity we want to start
                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
//                NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(position);
                intent.putExtra(NoteActivity.NOTE_POSITION, position);
                startActivity(intent);
            }
        });*/

  final RecyclerView recyclerView = findViewById(R.id.list_notes);
  final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
  recyclerView.setLayoutManager(notesLayoutManager);
    }

}
