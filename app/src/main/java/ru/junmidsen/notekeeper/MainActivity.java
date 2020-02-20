package ru.junmidsen.notekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notesRecyclerView;
    public static final ArrayList<Note> notes = new ArrayList<>();
    private FloatingActionButton mButtonAddNote;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesRecyclerView = findViewById(R.id.notes);
        if (notes.isEmpty()) {
            notes.add(new Note("1 задача", "Высокий уровень вовлечения представителей целевой аудитории является четким доказательством простого факта: новая модель организационной деятельности обеспечивает широкому кругу (специалистов) участие в формировании поставленных обществом задач. А ещё представители современных социальных резервов призывают нас к новым свершениям, которые, в свою очередь, должны быть подвергнуты целой серии независимых исследований. Также как новая модель организационной деятельности напрямую зависит от форм воздействия. Высокий уровень вовлечения представителей целевой аудитории является четким доказательством простого факта: консультация с широким активом влечет за собой процесс внедрения и модернизации позиций, занимаемых участниками в отношении поставленных задач.", 1));
            notes.add(new Note("2 задача", "Как уже неоднократно упомянуто, действия представителей оппозиции формируют глобальную экономическую сеть и при этом - ограничены исключительно образом мышления. Не следует, однако, забывать, что синтетическое тестирование не оставляет шанса для первоочередных требований.", 2));
            notes.add(new Note("3 задача", "Равным образом, современная методология разработки представляет собой интересный эксперимент проверки новых предложений.", 3));
        }
        adapter = new NotesAdapter(notes);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setAdapter(adapter);
        adapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Note note = notes.get(position);
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                intent.putExtra("title", note.getTitle());
                intent.putExtra("description", note.getDescription());
                intent.putExtra("color_id", note.getColorId());
                intent.putExtra("position", position);
                startActivity(intent);
            }

            @Override
            public void onNoteLongClick(int position) {
                remove(position);
                Toast.makeText(MainActivity.this,
                                R.string.toast_remove_note,
                                Toast.LENGTH_SHORT).show();
            }
        });

        mButtonAddNote = (FloatingActionButton) findViewById(R.id.button_add_note);
        mButtonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void remove(int position) {
        notes.remove(position);
        adapter.notifyDataSetChanged();
    }
}
