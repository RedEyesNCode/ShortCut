public class RetrofitShortCut {

    public static String getServerError(int responseCode, ResponseBody responseBody, Context context){
        String serverHandling =  "Error "+responseCode+" "+"Please try again.";

        switch (responseCode){
            case 401:
                //LogOutTheUser

                /*Toast.makeText(context, "Unauthorized Access : Invalid Token Error : 401", Toast.LENGTH_SHORT).show();*/
                serverHandling = "Session Timed Out.";
                break;
            case 400:
                //Bad Request Display The Message

                try {
                    if(responseBody!=null){
                        Gson gson = new GsonBuilder().create();
                        //MODIFY THIS CLASS ACCORDING
                        CommonStatusMessageResponse commonStatusMessageResponseOne = new CommonStatusMessageResponse();
                        commonStatusMessageResponseOne = gson.fromJson(responseBody.string(),CommonStatusMessageResponse.class);
                        Log.i("ERROR_BODY",commonStatusMessageResponseOne.getMessage());
                        serverHandling = commonStatusMessageResponseOne.getMessage();
                        return serverHandling;
                    }
                } catch (Exception e){

                    e.printStackTrace();
                }



        }
        return serverHandling;

    }

    //THIS METHOD IS USED TO CHECK THE RESPONSE FROM THE RETROFIT AND VAILDATE IT.
    // YOU CAN USE THIS BEFORE EVERY RETROFIT CALL.

    public static boolean isEverythingOKRetrofit(ResponseBody responseBody){
        if(responseBody.code()==200 && responseBody.message().contains("OK")){

            return true;
        }else {
            return false;
        }




    }
    //Check Response Body Keys -- Util Method Very Important
    public static boolean isResponseKeyPresent(String keyName, String json){
        return json.contains(keyName);
    }



}
