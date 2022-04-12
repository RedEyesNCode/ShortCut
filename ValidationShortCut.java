import java.util.regex.Pattern;

public class ValidationShortCut {

    //THIS UTILITY CONTAINS THE VALIDATIONS REQUIRED FOR PERFORMING PROPER USER INPUT VALIDATIONS.



//NULL-POINTER-STRING METHOD USED WHEN SETTING TEXT TO THE TEXT VIEW.
    public static boolean checkIfNullOrEmpty(String value){
        return value != null && !value.equalsIgnoreCase("");


    }
    //ANOTHER NULL_POINTER_STRING_METHOD
    public static boolean isNullEmpty(String str) {

        // check if string is null
        if (str == null) {
            return true;
        } else return str.isEmpty();
    }
    //THIS METHOD RETURNS A STRING YOU CAN USE IT DIRECTLY IN THE TEXT VIEW OF ANDROID
    // IT WILL SET AN EMPTY TEXT IF THE STRING GIVEN IS NULL OR EMPTY.

    public static String checkIfNullTextView(String deniedReason) {
        String returnValue="";
        return isNullEmpty(deniedReason) ? (returnValue = "") : (returnValue = deniedReason);
    }

    //Converting an String Array Elements to a Complete String.
    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    //BELOW IS THE ZIPCODE VALIDATION FOR THE US.
    public static boolean isValidZipcode(String zipcode){
        String US = "^\\d{5}(?:[-\\s]\\d{4})?$";
        Pattern pattern = Pattern.compile(US);
        if(zipcode==null){
            return false;
        }
        return pattern.matcher(zipcode).matches();

    }


}
