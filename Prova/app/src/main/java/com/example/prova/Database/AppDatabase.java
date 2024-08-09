package com.example.prova.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.prova.Dao.TarefaDao;
import com.example.prova.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TarefaDao tarefaDao();
}