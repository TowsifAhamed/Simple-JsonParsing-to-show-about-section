package com.example.simplejsonparsing;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.widget.Toast.LENGTH_SHORT;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String line = "";
    String singleParsed = "";
    String dataParsed = "";
    String name="",website="",mail="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/f36fk");//https://api.myjson.com/bins/bvfrk
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String sline="";
            while (sline!=null){
                sline = bufferedReader.readLine();
                line = line + sline;
            }
            for (int i=10;i<=27;i++) {
                name += line.charAt(i);
            }
            for (int i=40;i<=53;i++) {
                website += line.charAt(i);
            }
            for (int i=64;i<=81;i++) {
                mail += line.charAt(i);
            }
            JSONArray JA = new JSONArray(line);
            for(int i =0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "name:" + JO.get("name") + "\n"+
                        "website:" + JO.get("website") + "\n"+
                        "mail:" + JO.get("mail") + "\n";

                dataParsed = dataParsed + singleParsed +"\n" ;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        /*AboutActivity.mname.setText(this.dataParsed);*/
        AboutActivity.mname.setText(this.name);
        AboutActivity.mwebsite.setText(this.website);
        AboutActivity.mmail.setText(this.mail);
    }
}
