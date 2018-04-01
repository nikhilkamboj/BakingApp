package com.nikhil.bakeit;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nikhil.bakeit.constants.JsonConstants;
import com.nikhil.bakeit.database.BakingContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DbFillUp {

    static ContentValues[] mainContentValueList;

    static ArrayList<ContentValues> ingredientContentValueList = new ArrayList<>();

    static ArrayList<ContentValues> stepsContentValueList = new ArrayList<>();

    private static final String TAG = DbFillUp.class.getSimpleName();

    static JSONArray jsonArray;

    /**
     * writing all required methods to fill up the db such as volley and how to fill it up.
     */
    private static RequestQueue requestQueue;

    private static ContentResolver contentResolver;

    public static void fillDb(Context context) {
        requestQueue = Volley.newRequestQueue(context);

        contentResolver = context.getContentResolver();


        // getting JsonObject from the Url,
        /**
         * 4 parameters
         * 1. GET the type of request
         * 2. JsonUrl, from where we will get the json data
         * 3. a null is given
         * 4. a Response.Listener object that handles the jon response, which callbacks its
         * onResponse method for querying the Json received.
         * 5. an error handling object which calls onErrorResponse if any error occurs during the call
         *
         * in 3 and 4 we are creating our anonymous inner classes.
         */
        Log.i(TAG, "volley starting to fetch data");

        JsonArrayRequest objectRequest = new JsonArrayRequest(JsonObjectRequest.Method.GET, JsonConstants.getDataSiteUrl(), null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            jsonArray = response;

                            // length of main array
                            int arrayLength = response.length();

                            mainContentValueList = new ContentValues[arrayLength];

                            Log.i(TAG, jsonArray.length() + " length of the array");
                            JSONObject objectAtOne = response.getJSONObject(0);
                            String name = objectAtOne.getString("name");
                            Log.i(TAG, name);

                            for (int i = 0; i < arrayLength; i++) {

                                ContentValues cv = new ContentValues();

                                JSONObject indexedObject = response.getJSONObject(i);

                                int id = indexedObject.getInt(JsonConstants.getAttributeMainId());

                                String nameOfRecipe = indexedObject.getString(JsonConstants.getAttributeRecipeName());

                                int servings = indexedObject.getInt(JsonConstants.getAttributeServingName());

                                cv.put(BakingContract.MainBakingEntry.MAIN_ID, id);

                                cv.put(BakingContract.MainBakingEntry.NAME_OF_RECIPE, nameOfRecipe);

                                cv.put(BakingContract.MainBakingEntry.SERVING_OF_RECIPE,servings);

                                mainContentValueList[i] = cv;

                            }


                            for (int i = 0; i < arrayLength; i++) {

                                JSONObject indexedMainObject = response.getJSONObject(i);

                                JSONArray ingredientArray = indexedMainObject.getJSONArray
                                        (JsonConstants.getAttributeIngredientsArrayName());

                                for (int j = 0; j < ingredientArray.length(); j++) {

                                    ContentValues cv = new ContentValues();

                                    JSONObject ingredientIndexedObject = ingredientArray.getJSONObject(j);

                                    int quantity = ingredientIndexedObject.
                                            getInt(JsonConstants.getAttributeIngredientsArrayQuantity());

                                    String measure = ingredientIndexedObject.
                                            getString(JsonConstants.getAttributeIngredientsArrayMeasure());

                                    String ingredientContent = ingredientIndexedObject.
                                            getString(JsonConstants.getAttributeIngredientsArrayIngredient());

                                    cv.put(BakingContract.IngredientTableEntry.
                                            INGREDIENT_MAIN_ID, i+1);

                                    cv.put(BakingContract.IngredientTableEntry.
                                            QUANTITY_OF_INGREDIENT, quantity);

                                    cv.put(BakingContract.IngredientTableEntry.
                                            MEASURE_OF_INGREDIENT, measure);

                                    cv.put(BakingContract.IngredientTableEntry.
                                            ACTUAL_INGREDIENT_CONTENT, ingredientContent);

                                    ingredientContentValueList.add(cv);

                                }

                            }

                            for (int i = 0; i < arrayLength; i++) {
                                JSONObject indexedMainObject = response.getJSONObject(i);

                                JSONArray stepsArray = indexedMainObject.getJSONArray
                                        (JsonConstants.getAttributeStepsArrayName());

                                for (int j = 0; j < stepsArray.length(); j++) {
                                    ContentValues cv = new ContentValues();

                                    JSONObject stepsIndexedObject = stepsArray.getJSONObject(j);

                                    int videoId = stepsIndexedObject.getInt
                                            (JsonConstants.getAttributeMainId());

                                    String shortDesc = stepsIndexedObject.getString
                                            (JsonConstants.getAttributeStepsArrayVideoShortDesc());

                                    String mainDesc = stepsIndexedObject.getString
                                            (JsonConstants.getAttributeStepsArrayVideoMainDesc());

                                    String videoUrl = stepsIndexedObject.getString
                                            (JsonConstants.getAttributeStepsArrayVideoUrl());

                                    cv.put(BakingContract.StepsTableEntry.STEPS_MAIN_ID, i + 1);

                                    cv.put(BakingContract.StepsTableEntry.VIDEO_ID, videoId);

                                    cv.put(BakingContract.StepsTableEntry.SHORT_DESC, shortDesc);

                                    cv.put(BakingContract.StepsTableEntry.MAIN_DESC, mainDesc);

                                    cv.put(BakingContract.StepsTableEntry.VIDEO_URL, videoUrl);

                                    stepsContentValueList.add(cv);
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley" , "Error");
            }
        });

        Log.i(TAG, "Volley fetched data from api");

        // adding Json object request to the request queue
        requestQueue.add(objectRequest);

        Log.i(TAG, "added to the request queue");

    }

}
