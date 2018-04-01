package com.nikhil.bakeit.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class BakingContentProvider extends ContentProvider {

    // creating code for Uri's that will be used here.
    public static final int CODE_MAIN_TABLE = 100;

    public static final int CODE_INGREDIENT_TABLE = 200;

    public static final int CODE_STEPS_TABLE = 300;

    public static final UriMatcher sUriMatcher = buildUriMatcher();

    private BakingDbHelper mBakingOpenHelper;


    /**
     *
     * @return UriMatcher object containing code and pathMatching of the table through mapping.
     */
    public static UriMatcher buildUriMatcher() {

        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = BakingContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(authority,BakingContract.MAIN_TABLE_PATH,CODE_MAIN_TABLE);
        uriMatcher.addURI(authority,BakingContract.INGREDIENT_TABLE_PATH, CODE_INGREDIENT_TABLE);
        uriMatcher.addURI(authority,BakingContract.STEPS_TABLE_PATH, CODE_STEPS_TABLE);

        return uriMatcher;
    }


    @Override
    public boolean onCreate() {
        mBakingOpenHelper = new BakingDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor cursor;

        switch (sUriMatcher.match(uri)) {
            case CODE_MAIN_TABLE:
                cursor = mBakingOpenHelper.getReadableDatabase().query(
                        BakingContract.MainBakingEntry.MAIN_TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null);
                break;
            case CODE_INGREDIENT_TABLE:
                cursor = mBakingOpenHelper.getReadableDatabase().query(
                        BakingContract.IngredientTableEntry.INGREDIENT_TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null);
                break;
            case CODE_STEPS_TABLE:
                cursor = mBakingOpenHelper.getReadableDatabase().query(
                        BakingContract.StepsTableEntry.STEPS_TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null);
                break;
            default:
                throw new UnsupportedOperationException("unknown Uri " + uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {

        final SQLiteDatabase database = mBakingOpenHelper.getWritableDatabase();

        switch (sUriMatcher.match(uri)) {
            case CODE_MAIN_TABLE:
                database.beginTransaction();
                int insertedRow = 0;
                for (ContentValues contentValues : values) {

                }
                break;
            case CODE_INGREDIENT_TABLE:
                break;
            case CODE_STEPS_TABLE:
                break;
            default:
                throw new UnsupportedOperationException("unknown Uri" + uri);
        }

        return super.bulkInsert(uri, values);
    }
}
