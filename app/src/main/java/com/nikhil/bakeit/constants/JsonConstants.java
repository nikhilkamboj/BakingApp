package com.nikhil.bakeit.constants;

/**
 * java class to handle all the constant related to my incoming Json file
 */
public class JsonConstants {

 /*************************************************** START OF JSON FILE ATTRIBUTES ****************************************************************************/
    private static final String ATTRIBUTE_MAIN_ID = "id";

    private static final String ATTRIBUTE_RECIPE_NAME = "name";

    private static final String ATTRIBUTE_INGREDIENTS_ARRAY_NAME = "ingredients";

    private static final String ATTRIBUTE_STEPS_ARRAY_NAME = "steps";

    private static final String ATTRIBUTE_SERVING_NAME = "servings";

    private static final String ATTRIBUTE_IMAGE_NAME = "image";

    private static final String ATTRIBUTE_INGREDIENTS_ARRAY_QUANTITY = "quantity";

    private static final String ATTRIBUTE_INGREDIENTS_ARRAY_MEASURE = "measure";

    private static final String ATTRIBUTE_INGREDIENTS_ARRAY_INGREDIENT = "ingredient";

    private static final String ATTRIBUTE_STEPS_ARRAY_VIDEO_ID = "id";

    private static final String ATTRIBUTE_STEPS_ARRAY_VIDEO_SHORT_DESC = "shortDescription";

    private static final String ATTRIBUTE_STEPS_ARRAY_VIDEO_MAIN_DESC  = "description";

    private static final String ATTRIBUTE_STEPS_ARRAY_VIDEO_URL = "videoURL";

    private static final String ATTRIBUTE_STEPS_ARRAY_VIDEO_THUMBNAIL_URL = "thumbnailURL";

    private static final String DATA_SITE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

 /*************************************************** END OF JSON FILE ATTRIBUTES *****************************************************************************/




 /*************************************************************START OF GETTERS*************************************************************/
    public static String getAttributeMainId() {
        return ATTRIBUTE_MAIN_ID;
    }

    public static String getAttributeRecipeName() {
        return ATTRIBUTE_RECIPE_NAME;
    }

    public static String getAttributeIngredientsArrayName() {
        return ATTRIBUTE_INGREDIENTS_ARRAY_NAME;
    }

    public static String getAttributeStepsArrayName() {
        return ATTRIBUTE_STEPS_ARRAY_NAME;
    }

    public static String getAttributeServingName() {
        return ATTRIBUTE_SERVING_NAME;
    }

    public static String getAttributeImageName() {
        return ATTRIBUTE_IMAGE_NAME;
    }

    public static String getAttributeIngredientsArrayQuantity() {
        return ATTRIBUTE_INGREDIENTS_ARRAY_QUANTITY;
    }

    public static String getAttributeIngredientsArrayMeasure() {
        return ATTRIBUTE_INGREDIENTS_ARRAY_MEASURE;
    }

    public static String getAttributeIngredientsArrayIngredient() {
        return ATTRIBUTE_INGREDIENTS_ARRAY_INGREDIENT;
    }

    public static String getAttributeStepsArrayVideoId() {
        return ATTRIBUTE_STEPS_ARRAY_VIDEO_ID;
    }

    public static String getAttributeStepsArrayVideoShortDesc() {
        return ATTRIBUTE_STEPS_ARRAY_VIDEO_SHORT_DESC;
    }

    public static String getAttributeStepsArrayVideoMainDesc() {
        return ATTRIBUTE_STEPS_ARRAY_VIDEO_MAIN_DESC;
    }

    public static String getAttributeStepsArrayVideoUrl() {
        return ATTRIBUTE_STEPS_ARRAY_VIDEO_URL;
    }

    public static String getAttributeStepsArrayVideoThumbnailUrl() {
        return ATTRIBUTE_STEPS_ARRAY_VIDEO_THUMBNAIL_URL;
    }

    public static String getDataSiteUrl() {
        return DATA_SITE_URL;
    }

    /******************************************************************************************************************************************************/

}
