package com.shevchenkodev.doctorcat.datebase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shevchenkodev.doctorcat.model.ModelPet;
import com.shevchenkodev.doctorcat.model.ModelTask;

import java.util.ArrayList;
import java.util.List;


public class DBQueryManager {
    private SQLiteDatabase database;

    DBQueryManager(SQLiteDatabase database) {
        this.database = database;
    }


    public ModelTask getTask(long timeStamp) {
        ModelTask modelTask = null;
        Cursor cursor = database.query(DBHelper.TASKS_TABLE, null, DBHelper.SELECTION_TIME_STAMP,
                new String[]{Long.toString(timeStamp)}, null, null, null);

        if (cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
            long date = cursor.getLong(cursor.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
            int priority = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
            int status = cursor.getInt(cursor.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));

            modelTask = new ModelTask(title, date, priority, status, timeStamp);
        }
        cursor.close();

        return modelTask;

    }



    public List<ModelTask> getTasks(String selection, String[] selectionArgs, String orderBy) {
        List<ModelTask> tasks = new ArrayList<>();

        Cursor c = database.query(DBHelper.TASKS_TABLE, null, selection, selectionArgs, null, null, orderBy);

        if (c.moveToFirst()) {
            do {
                String title = c.getString(c.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
                long date = c.getLong(c.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
                int priority = c.getInt(c.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
                int status = c.getInt(c.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));
                long timeStamp = c.getLong(c.getColumnIndex(DBHelper.TASK_TIME_STAMP_COLUMN));

                ModelTask modelTask = new ModelTask(title, date, priority, status, timeStamp);
                tasks.add(modelTask);
            } while (c.moveToNext());
        }
        c.close();

        return tasks;
    }
    
    
 public List<ModelPet> getPets(String selection, String[] selectionArgs, String orderBy) {
        List<ModelPet> pets = new ArrayList<>();

        Cursor c = database.query(DBHelper.PET_TABLE, null, selection, selectionArgs, null, null, orderBy);

        if (c.moveToFirst()) {
            do {
                String name = c.getString(c.getColumnIndex(DBHelper.PAT_NAME_COLUMN));
                long date = c.getLong(c.getColumnIndex(DBHelper.PAT_AGE_COLUMN));
                int type = c.getInt(c.getColumnIndex(DBHelper.PAT_TYPE_COLUMN));
               

                ModelPet modelPet = new ModelPet(name, date, type);
                pets.add(modelPet);
            } while (c.moveToNext());
        }
        c.close();

        return pets;
    }


}
