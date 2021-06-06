package com.example.view;

import androidx.appcompat.app.AppCompatActivity;

import com.example.view.R;
import com.example.view.Note;
import com.example.view.NoteImpl;
import com.example.view.NoteInterfaces;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Date;

public class    AddActivity extends AppCompatActivity {

    ImageButton button;
    EditText edtTitle;
    EditText edtCategory;
    EditText edtDesc;
    Button addButton;
    Button delButton;

    private NoteInterfaces noteInterfaces;

    com.example.view.Note note = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        note = (com.example.view.Note) getIntent().getSerializableExtra("Note");
        button = findViewById(R.id.back);
        edtTitle = findViewById(R.id.title);
        edtCategory = findViewById(R.id.category);
        edtDesc = findViewById(R.id.desc);
        addButton = findViewById(R.id.buttonadd);
        delButton = findViewById(R.id.buttondel);
        noteInterfaces = new com.example.view.NoteImpl(this);

        button.setOnClickListener(v -> {
            finish();
        });

        if (note == null ){
            delButton.setVisibility(View.GONE);

            addButton.setOnClickListener(v -> {
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm",d.getTime());
                com.example.view.Note n = new com.example.view.Note(
                        d.getTime()+ "",
                        edtTitle.getText().toString(),
                        edtCategory.getText().toString(),
                        edtDesc.getText().toString(),
                        date+ ""
                );

                noteInterfaces.create(n);
                finish();
            });
        }else {
            edtTitle.setText(note.getTitle());
            edtCategory.setText(note.getCategory());
            edtDesc.setText(note.getDesc());

            delButton.setVisibility(View.VISIBLE);
            addButton.setText("EDIT");

            addButton.setOnClickListener(v -> {
                Date d = new Date();
                CharSequence date = DateFormat.format("EEEE, d MMM yyyy HH:mm",d.getTime());

                note.setTitle(edtTitle.getText().toString());
                note.setCategory(edtCategory.getText().toString());
                note.setDesc(edtDesc.getText().toString());
                note.setDate(date+"");
                noteInterfaces.update(note);
                finish();
            });

            delButton.setOnClickListener(v -> {
                noteInterfaces.delete(note.getId());
                finish();
            });
        }




    }
}
// 05-06-2021
// 10118331
// Devidli Setiawan
// IF-8