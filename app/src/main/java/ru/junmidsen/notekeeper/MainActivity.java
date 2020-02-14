package ru.junmidsen.notekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notesRecyclerView;
    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesRecyclerView = findViewById(R.id.notes);
        notes.add(new Note("1 задача", "Высокий уровень вовлечения представителей целевой аудитории является четким доказательством простого факта: новая модель организационной деятельности обеспечивает широкому кругу (специалистов) участие в формировании поставленных обществом задач. А ещё представители современных социальных резервов призывают нас к новым свершениям, которые, в свою очередь, должны быть подвергнуты целой серии независимых исследований. Также как новая модель организационной деятельности напрямую зависит от форм воздействия. Высокий уровень вовлечения представителей целевой аудитории является четким доказательством простого факта: консультация с широким активом влечет за собой процесс внедрения и модернизации позиций, занимаемых участниками в отношении поставленных задач.", 1));
        notes.add(new Note("2 задача", "Как уже неоднократно упомянуто, действия представителей оппозиции формируют глобальную экономическую сеть и при этом - ограничены исключительно образом мышления. Не следует, однако, забывать, что синтетическое тестирование не оставляет шанса для первоочередных требований.", 2));
        notes.add(new Note("3 задача", "Равным образом, современная методология разработки представляет собой интересный эксперимент проверки новых предложений.",3));
        NotesAdapter adapter = new NotesAdapter(notes);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setAdapter(adapter);
    }
}
