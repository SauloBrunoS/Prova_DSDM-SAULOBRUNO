package com.example.prova;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prova.Dao.TarefaDao;
import com.example.prova.Database.AppDatabase;
import com.example.prova.RecyclerView.Item;
import com.example.prova.RecyclerView.ItemArrayListAdapter;
import com.example.prova.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<Tarefa> tarefaList;
    ArrayList itemList;
    TarefaDao tarefaDao;
    RecyclerView rv_itens;
    ItemArrayListAdapter itemArrayListAdapter;
    Button btn_criar_tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_criar_tarefa = findViewById(R.id.btn_criar_tarefa);
        tarefaDao = initiateDatabase();
        populateFromDatabase();
        recyclerViewStuff();
        btn_criar_tarefa.setOnClickListener(this);
    }

    @NonNull
    private TarefaDao initiateDatabase() {
        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_tarefas")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        return appDatabase.tarefaDao();
    }

    private void populateFromDatabase() {
        tarefaList = tarefaDao.getAll();
        itemList = new ArrayList<>();

        for (Tarefa t: tarefaList) {
            Item item = new Item(t.getTitulo(), t.getDescricao());
            itemList.add(item);
        }
    }

    private void recyclerViewStuff() {
        rv_itens = findViewById(R.id.rv_itens);

        itemArrayListAdapter = new ItemArrayListAdapter(R.layout.item_layout, itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rv_itens.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                ((LinearLayoutManager) layoutManager).getOrientation());

        rv_itens.addItemDecoration(dividerItemDecoration);

        rv_itens.setAdapter(itemArrayListAdapter);

    }

    @Override
    public void onClick(View v) {
        if(v == btn_criar_tarefa) {
            Intent intent = new Intent(MainActivity.this, CriarTarefa.class);
            startActivity(intent);
        }
    }
}