package com.ssp.studentapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperActivity extends SQLiteOpenHelper {


    public DatabaseHelperActivity(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "StudentDetails.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.
//        db.execSQL("CREATE TABLE STUDENT(EMAIL TEXT AUTO_INCRMENT,PASSWORD TEXT, AADHAR INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
