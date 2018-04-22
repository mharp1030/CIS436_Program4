package com.harp.CIS436_Program4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper
{
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "movies.db";// Database name
    private SQLiteDatabase database;
    private final Context context;

    public DataHelper(Context context)
    {
        super(context, DB_NAME, null, 1);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        this.context = context;
    }

    public void createDataBase() throws IOException
    {
        //If the database does not exist, copy it from the assets.

        boolean doesExist = checkDataBase();
        if(!doesExist)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                //Copy the database from assets
                copyDataBase();
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException
    {
        InputStream in = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream out = new FileOutputStream(outFileName);
        byte[] buff = new byte[1024];
        int length;
        while ((length = in.read(buff))>0)
        {
            out.write(buff, 0, length);
        }
        out.flush();
        out.close();
        in.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String path = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        return database != null;
    }

    @Override
    public synchronized void close()
    {
        if(database != null)
            database.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}