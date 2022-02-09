package com.android.biglifts.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.android.biglifts.models.ExerciseModel;

import java.util.List;

@Dao
public interface ExerciseDao {
    @Insert
    void prePopulateExerciseTable(ExerciseModel[] exerciseModels);

    @Insert
    void insertExercises(List<ExerciseModel> exerciseModels);

    @Update
    void updateExercise(ExerciseModel exerciseModel);

    @Delete
    void deleteExercises(List<ExerciseModel> exerciseModels);

    @Query("SELECT * FROM tblExercise ORDER BY exerciseName ASC")
    LiveData<List<ExerciseModel>> getAllExercisesOrderedAlphabetically();

    @Query("SELECT * FROM tblExercise WHERE id = :id")
    LiveData<ExerciseModel> getExerciseById(int id);
    // Flowable<ExerciseModel> loadExerciseById(int id);

    @Query("DELETE FROM tblExercise")
    void deleteAllExercises();
}
