# ShortCut

##Reducing Android Redundant Tasks Easily

This Repo has the Basic &amp; Advanced Utilities Used in Android Projects.

***This Repository is Currently Updating on the Move.***

**Image-ShortCut**

This Utility is used to Perform the Basic Operations in Android related to the 
File and The Uri System (Updating Currently)

**Utility-Name** : `/ImageShortCut`

**Used-in** : `E-commerce or Social Media Apps`

**Method 1** : ` public static File getFile(Context context, Uri uri) 
throws IOException`

**Method example**

`try{ File imageFile = getFile(Context,uri)
}catch(IOException e){
}`

##Validation-ShortCut

This Utility is used to Perform the Operations mainly related to the 
User Input and Output operations

**Utility-Name** : `/ValidationShortCut`

**Method 1 :** ` public static boolean checkIfNullOrEmpty(String value)`

This method is generally used to check if the String is Null or Empty and return
a boolean value according to it.

**Method 2 :** `  public static String checkIfNullTextView(String deniedReason)`

This Method can be directly used while setting the text to the TextView in android.

**Method 3 :** `public static boolean isValidEmail(String email)`

This Method checks if the Entered String is a Valid Email or Not , returns a boolean value accordingly.

**Method 4 :** ` public static boolean isValidZipcode(String zipcode)`

This Method checks if the given string is a valid Zipcode for the US or not and Returns a boolean value accordingly.


##Retrofit-ShortCut

This Utility is used to perform the basic and advanced Network Related Operations in Android

**Utility-Name :** `/RetrofitShortCut`

**Method 1:** `public static String getServerError(int responseCode, ResponseBody responseBody, Context context)`

This Method return the Message from the Error Body of the Retrofit when Code was not 200.

```json
{
"status": "fail",
"message": "No account found with that mobile number."
}
```
**NOTE** This Method Applies only to this particular set of errorBody Response received from the Backend
if you want to change you can change the CommonStatusResponseModel in the Utility Method.

**Method 2 :** `public static boolean isEverythingOKRetrofit(ResponseBody responseBody)`

This Method is generally used to Check if the retrofit response is OK (200) or Not.

**Method 3:** `public static boolean isResponseKeyPresent(String keyName, String json)`

This Method is Used to check if the a response Key is present in the Retrofit Response or not.

##Fragment-ShortCut

This Utility is used to perform all the Operations related to the Fragments like the Adding , Replacing the Fragment 
and more.

##KeyBoard-ShortCut

This Utility is used to perform tasks related to the android Keyboard , like hiding and Showing the
android soft keyboard.



