package com.shevchenkodev.doctorcat.datebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.shevchenkodev.doctorcat.model.ModelPet;
import com.shevchenkodev.doctorcat.model.ModelTask;

/**
 * Created by Администратор on 20.09.2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "reminder_database";

    public static final String TASKS_TABLE = "tasks_table";
    public static final String PET_TABLE = "pet_table";

    public static final String TASK_TITLE_COLUMN = "task_title";
    public static final String TASK_DATE_COLUMN = "task_date";
    public static final String TASK_PRIORITY_COLUMN = "task_priority";
    public static final String TASK_STATUS_COLUMN = "task_status";
    public static final String SELECTION_LIKE_TITLE = TASK_TITLE_COLUMN + " LIKE ?";


    public static final String TASK_TIME_STAMP_COLUMN = "task_time_stamp";

    public static final String PAT_NAME_COLUMN = "pet_name";
    public static final String PAT_AGE_COLUMN = "pet_age";
    public static final String PAT_TYPE_COLUMN = "pet_type";

    private static final String TASKS_TABLE_CREATE_SCRIPT = "CREATE TABLE "
            + TASKS_TABLE + " (" + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK_TITLE_COLUMN + " TEXT NOT NULL, "
            + TASK_DATE_COLUMN + " LONG, " + TASK_PRIORITY_COLUMN + " INTEGER, "
            + TASK_STATUS_COLUMN + " INTEGER, " + TASK_TIME_STAMP_COLUMN + " LONG);";
            
     private static final String PET_TABLE_CREATE_SCRIPT = "CREATE TABLE "
            + PET_TABLE + " (" + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PAT_NAME_COLUMN + " TEXT NOT NULL, "
            + PAT_AGE_COLUMN + " LONG, " + PAT_TYPE_COLUMN + " INTEGER);";


    public static final String SELECTION_STATUS = DBHelper.TASK_STATUS_COLUMN + " = ?";

    public static final String SELECTION_TIME_STAMP = TASK_TIME_STAMP_COLUMN + " = ?";

    public static final String SELECTION_PET = PAT_NAME_COLUMN + " = ?";

    private DBQueryManager queryManager;
    private DBUpdateManager updateManager;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        queryManager = new DBQueryManager(getReadableDatabase());
        updateManager = new DBUpdateManager(getWritableDatabase());

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TASKS_TABLE_CREATE_SCRIPT);
        //new
          db.execSQL(PET_TABLE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TASKS_TABLE);
        onCreate(db);

    }

    public void saveTask(ModelTask task) {
        ContentValues newValues = new ContentValues();

        newValues.put(TASK_TITLE_COLUMN, task.getTitle());
        newValues.put(TASK_DATE_COLUMN, task.getDate());
        newValues.put(TASK_STATUS_COLUMN, task.getStatus());
        newValues.put(TASK_PRIORITY_COLUMN, task.getPriority());
        newValues.put(TASK_TIME_STAMP_COLUMN, task.getTimeStamp());

        getWritableDatabase().insert(TASKS_TABLE, null, newValues);
    }

    public DBQueryManager query() {
        return queryManager;
    }

    public DBUpdateManager update() {
        return updateManager;
    }


    public void removeTask(long timeStamp) {
        getWritableDatabase().delete(TASKS_TABLE, SELECTION_TIME_STAMP, new String[]{Long.toString(timeStamp)});
    }
//
public void removePet(String petName) {
    getWritableDatabase().delete(PET_TABLE, SELECTION_PET, new String[]{petName});
}

public void savePet(ModelPet pet) {
        ContentValues newValues1 = new ContentValues();

    newValues1.put(PAT_NAME_COLUMN, pet.getPetName());
    newValues1.put(PAT_AGE_COLUMN, pet.getPetBDay());
    newValues1.put(PAT_TYPE_COLUMN, pet.getPetType());
      

        getWritableDatabase().insert(PET_TABLE, null, newValues1);
    }
//

}
