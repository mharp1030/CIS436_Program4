package com.harp.CIS436_Program4;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter
{
    private final String table;
    private final Context context;
    private SQLiteDatabase database;
    private DataHelper dataHelper;
    private Cursor cursor;
    private List<Movies> movies;


    public DataAdapter(Context context, String table)
    {
        this.context = context;
        this.table = table;
        dataHelper = new DataHelper(context);
    }

    public DataAdapter  createDatabase() throws SQLException
    {
        try
        {
            dataHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Toast.makeText(context, "Error: Unable To Create Database", Toast.LENGTH_SHORT).show();
        }
        return this;
    }

    public DataAdapter  open() throws SQLException
    {
        try
        {
            dataHelper.openDataBase();
            dataHelper.close();
            database = dataHelper.getReadableDatabase();
            initializeCursor();
        }
        catch (SQLException mSQLException)
        {
            Toast.makeText(context, "Error: Failed To Open Database", Toast.LENGTH_SHORT).show();
        }
        return this;
    }

    public void close()
    {
        dataHelper.close();
        cursor.close();
    }

    private void initializeCursor()
    {
        try
        {
            String query ="SELECT * FROM " + table;
            cursor = database.rawQuery(query, null);
            cursor.moveToFirst();
        }
        catch (SQLException sqle)
        {
            Toast.makeText(context, "Error: Failed To Load Database", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Movies> getData()
    {
        int picID;
        String pic;
        if (cursor!=null)
        {
            movies = new ArrayList<>();
            do
            {
                pic = cursor.getString(6);
                pic = pic.substring(11); // Changes "R.drawable.ironman" to "ironman"
                picID = context.getResources().getIdentifier(pic, "drawable", context.getPackageName());
                movies.add(new Movies(cursor.getString(1), cursor.getString(2), cursor.getString(3), picID));
            }while(cursor.moveToNext());
        }
        return movies;
    }
}