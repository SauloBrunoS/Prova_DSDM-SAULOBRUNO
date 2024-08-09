package com.example.prova.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.prova.model.Tarefa;
import java.util.List;

@Dao
public interface TarefaDao {
    @Query("SELECT * FROM tarefa")
    List<Tarefa> getAll();

    @Insert
    long insert(Tarefa tarefa);

}