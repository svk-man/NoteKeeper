package ru.junmidsen.notekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddNoteActivity extends AppCompatActivity {

    private EditText mEditTextTitle;
    private EditText mEditTextDescription;
    private RadioGroup mRadioGroupColor;
    private Button mButtonSaveNote;
    private int notePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        mEditTextTitle = (EditText) findViewById(R.id.edit_text_title);
        mEditTextDescription = (EditText) findViewById(R.id.edit_text_description);
        mRadioGroupColor = (RadioGroup) findViewById(R.id.radio_group_color);
        mButtonSaveNote = (Button) findViewById(R.id.button_save_note);

        Intent intent = getIntent();
        if (intent.hasExtra("title")) {
            String title = intent.getStringExtra("title");
            String description = intent.getStringExtra("description");
            int radioButtonId = intent.getIntExtra("color_id", 1);
            notePosition = intent.getIntExtra("position", -1);
            mEditTextTitle.setText(title);
            mEditTextDescription.setText(description);
            RadioButton radioButton = (RadioButton) mRadioGroupColor.getChildAt(notePosition);
            radioButton.setChecked(true);
        }

        mButtonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mEditTextTitle.getText().toString().trim();
                String description = mEditTextDescription.getText().toString().trim();
                int radioButtonId = mRadioGroupColor.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(radioButtonId);
                int colorId = Integer.parseInt(radioButton.getText().toString());
                Note note = new Note(title, description, colorId);
                if (notePosition == -1) {
                    MainActivity.notes.add(note);
                } else {
                    MainActivity.notes.set(notePosition, note);
                }

                Intent intent = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
