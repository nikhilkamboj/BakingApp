package com.nikhil.bakeit.database;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * class providing schema of the database
 */
public class BakingContract {

    /**
     *content authority, same as app's package name, hence guaranteed to be unique at google play store.
     * helps content provider find the db
     * and different associated tables. authority works just like the domain name and its website i.e app itself.
     */
    public static final String CONTENT_AUTHORITY = "com.nikhil.bakeit";

    /**
     * base content uri helps the app find the content provider for further db connections
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    /**
     * al the three down below are the table path name, that will get parsed with BASE_CONTENT_URI
     * to create path to the respected tables.
     */

    public static final String MAIN_TABLE_PATH = "main";

    public static final String INGREDIENT_TABLE_PATH = "ingredient";

    public static final String STEPS_TABLE_PATH = "steps";

    /**
     * inner class representing the main table
     */

    public static final class MainBakingEntry implements BaseColumns {
        /**
         * CONTENT_URI is here to the path associated with the particular table, unique for each table.
         */
        public static final Uri MAIN_CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(MAIN_TABLE_PATH).build();

        public static final String MAIN_TABLE_NAME = "main";

        /**
         * now we give the column names, which will be mapped to the original table column that is
         * getting created.
         */

        // main id for the column mId.
        public static final String MAIN_ID = "mid";

        // name of the recipe column
        public static final String NAME_OF_RECIPE = "name";

        // serving column
        public static final String SERVING_OF_RECIPE = "servings";

//        public static final String IMAGES_OF_RECIPE = "images";
    }

    public static final class IngredientTableEntry implements BaseColumns {
        /**
         * CONTENT_URI is here to the path associated with the particular table, unique for each table.
         */
        public static final Uri INGREDIENT_CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(INGREDIENT_TABLE_PATH).build();

        public static final String INGREDIENT_TABLE_NAME = "ingredient";

        /**
         * column mapping
         */

        // main id mId. here id is the main table id, which leads to 1-many formation of db.
        public static final String INGREDIENT_MAIN_ID = "mid";

        // quantity column
        public static final String QUANTITY_OF_INGREDIENT = "quantity";

        // measure column
        public static final String MEASURE_OF_INGREDIENT = "measure";

        // actual ingredient column
        public static final String ACTUAL_INGREDIENT_CONTENT = "ingredient_content";

    }

    public static final class StepsTableEntry implements BaseColumns {
        /**
         * CONTENT_URI is here to the path associated with the particular table, unique for each table.
         */
        public static final Uri STEPS_CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(STEPS_TABLE_PATH).build();

        public static final String STEPS_TABLE_NAME = "steps";

        /**
         * column mapping
         */

        // main id mId. here id is the main table id, which leads to 1-many formation of db.
        public static final String STEPS_MAIN_ID = "mid";

        // video Id column
        public static final String VIDEO_ID = "vid";

        // short description column
        public static final String SHORT_DESC = "short_desc";

        // main description column
        public static final String MAIN_DESC = "main_desc";

        // video url column
        public static final String VIDEO_URL = "video_url";

    }

}
