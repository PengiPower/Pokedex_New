package com.example.pengi.pokedex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Pengi on 3/10/2016.
 */
public class PokemonDbHelper  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pokedex.db";

    public PokedexDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
