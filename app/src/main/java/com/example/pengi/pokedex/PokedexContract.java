package com.example.pengi.pokedex;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.BaseColumns;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pengi on 3/10/2016.
 */
public class PokedexContract {

    public static final String TABLE_NAME = "pokemon";
    private final SQLiteOpenHelper dbHelper;
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String BLOB_TYPE = " BLOB";
    private static final String COMMA_SEP = ",";

    public abstract class PokeBallsEntry implements BaseColumns {
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_IMG = "img";
        public static final String COLUMN_NAME_HEIGHT = "height";
        public static final String COLUMN_NAME_NAME = "name";
    }

    public PokedexContract(SQLiteOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

}
