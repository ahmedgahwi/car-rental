package com.example.car;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int D_V = 1;
    private static final String D_N = "ArtApp.db";

    private static final String T_N = "Suhaib";
    private static final String C_U = "user_name";
    private static final String C_P = "password";

    public DatabaseHelper(Context context)
    {

        super(context, D_N, null, D_V);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB)
    {
        String createTableQuery = "CREATE TABLE " + T_N + " (" +
                C_U + " TEXT PRIMARY KEY," +
                C_P + " TEXT)";
        myDB.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int O_V, int N_V)
    {
        String deleteTableQuery = "DROP TABLE IF EXISTS " + T_N;
        myDB.execSQL(deleteTableQuery);
        onCreate(myDB);
    }
    public boolean ad(String user_name, String PW)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(C_U, user_name);
        values.put(C_P, PW);
        long result = myDB.insert(T_N, null, values);
        return result != -1;
    }
    public boolean up(String user_name, String New_Password)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues suhaib = new ContentValues();
        suhaib.put(C_P, New_Password);
        String whereClause = C_U + " = ?";
        String[] whereArgs = {user_name};
        int result = myDB.update(T_N, suhaib, whereClause, whereArgs);
        return result > 0;
    }
    public boolean dD(String user_name)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        String whereClause = C_U + " = ?";
        String[] whereArgs = {user_name};
        int result = myDB.delete(T_N, whereClause, whereArgs);
        return result > 0;
    }

    public Cursor vd()
    {
        SQLiteDatabase myDB = this.getReadableDatabase();
        String query = "SELECT * FROM " + T_N;
        return myDB.rawQuery(query, null);
    }

    public boolean cd()
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        int result = myDB.delete(T_N, null, null);
        return result > 0;
    }
}
