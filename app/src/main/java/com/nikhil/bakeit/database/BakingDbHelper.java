package com.nikhil.bakeit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BakingDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "baking.db";

    public static final int DATABASE_VERSION = 1;


    public BakingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /**
         * main baking table creation command
         */
        final String SQL_CREATE_MAIN_TABLE =
                "CREATE TABLE " + BakingContract.MainBakingEntry.MAIN_TABLE_NAME + " ( " +
                        BakingContract.MainBakingEntry.MAIN_ID             + " INTEGER UNIQUE NOT NULL, " +
                        BakingContract.MainBakingEntry.NAME_OF_RECIPE      + " TEXT NOT NULL, "           +
                        BakingContract.MainBakingEntry.SERVING_OF_RECIPE   + " INTEGER DEFAULT 0 );";

        /**
         * Ingredient table create command
         */
        final String SQL_CREATE_INGREDIENT_TABLE =
                "CREATE TABLE " + BakingContract.IngredientTableEntry.INGREDIENT_TABLE_NAME + " ( " +
                        BakingContract.IngredientTableEntry.INGREDIENT_MAIN_ID        + " INTEGER NOT NULL, "  +
                        BakingContract.IngredientTableEntry.QUANTITY_OF_INGREDIENT    + " INTEGER NOT NULL, "  +
                        BakingContract.IngredientTableEntry.MEASURE_OF_INGREDIENT     + " TEXT NOT NULL, "     +
                        BakingContract.IngredientTableEntry.ACTUAL_INGREDIENT_CONTENT + " TEXT NOT NULL );";

        /**
         * Steps table create command
         */
        final String SQL_CREATE_STEPS_TABLE =
                "CREATE TABLE " + BakingContract.StepsTableEntry.STEPS_TABLE_NAME + " ( " +
                        BakingContract.StepsTableEntry.STEPS_MAIN_ID       + " INTEGER NOT NULL, " +
                        BakingContract.StepsTableEntry.VIDEO_ID            + " INTEGER NOT NULL, " +
                        BakingContract.StepsTableEntry.SHORT_DESC          + " TEXT NOT NULL, "    +
                        BakingContract.StepsTableEntry.MAIN_DESC           + " TEXT NOT NULL, "    +
                        BakingContract.StepsTableEntry.VIDEO_URL           + " TEXT NOT NULL );" ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
