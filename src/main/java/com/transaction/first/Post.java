package com.transaction.first;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post {
    private static JSONObject json;

    public static JSONObject getJson() {
        return json;
    }

    public static void setJson(JSONObject json) {
        Post.json = json;
    }

    public static void POSTRequest(LoginDetails loginDetails) throws IOException {
        System.out.println(loginDetails);
        final String POST_PARAMS = "{" +
                "\"data\""+" : {"+
            "\"orgCode\""+":" +"\"HDFC_DEMO_MERCHANT\""+","+
                    "\"configId\""+":"+ "12"+","+
                    "\"version\""+":"+" 12"+
        "}"+","+
        "\"username\""+":"+ "\""+loginDetails.getUname()+"\""+","+
                "\"password\""+":"+ "\""+loginDetails.getPword()+"\""+
    "}";
        System.out.println(POST_PARAMS);
        URL obj = new URL( "https://dev8.ezetap.com/api/2.0/auth/login");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("userId", "a1bcdefgh");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        //System.out.println("POST Response Code :  " + responseCode);
        //System.out.println("POST Response Message : " + postConnection.getResponseMessage());

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            try {
                json = new JSONObject(response.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            String Ps="{\n" +
                    "    \"success\": false" +
                    "}";
            try {
                json = new JSONObject(Ps);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println("POST NOT WORKED");
        }
        //System.out.println(getJson().toString());
    }


}
