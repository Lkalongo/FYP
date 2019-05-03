
package com.example.lorraine.fyp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FetchFilm
        //extends AsyncTask<String, Void, String>
{

}
   /* private EditText nFilmInput;
    private TextView nTitleText;
    private TextView nYearText;

    ListView listView;
    ArrayList<String> filmArrayList = new ArrayList<String>();

    private static final String LOG_TAG = FetchFilm.class.getSimpleName();

    public FetchFilm(TextView titleText, TextView yearText, EditText filmInput)
    {
        this.nFilmInput = filmInput;
        this.nTitleText = titleText;
        this.nYearText = yearText;
       // String data = "";
        //String filmJSONString = "";
    }

    //@param
    //@return

    @Override
    protected String doInBackground(String ...params)
    {
        //search string
        String queryString = params[0];


        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        //contains JSON response as string
       String filmJSONString = "";

        try
        {
            final String OMDB_BASE_URL = "http://www.omdbapi.com/?";
            final String QUERY_PARAM = "s";
            final String API_KEY = "822594fa";
            final String PARAM_API_KEY = "apikey";

            //building uri
            Uri builtUri = Uri.parse(OMDB_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(PARAM_API_KEY, API_KEY)
                    .build();

            Log.i(LOG_TAG, "build uri: " + builtUri);

            URL requestURL = new URL(builtUri.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //for converting inputstream to string
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while((line = reader.readLine())!=null)
            {
                builder.append(line + "\n");
            }
            if(builder.length() == 0)
            {
                return null;
            }
            filmJSONString = builder.toString();
            //getFilmDataFromJSON(filmJSONString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(urlConnection !=null)
            {
                urlConnection.disconnect();
            }
            if(reader !=null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        Log.i(LOG_TAG, "doInBackground: filmJSONString: " + filmJSONString);
        return filmJSONString;
    }

    protected void onPostExecute(String dataFetched)
    {
        //parse then display
        parseJSON(dataFetched);

  //parsing JSON
            try
            {
                //JSONObject filmJSON = new JSONObject(filmJSONString);
                JSONArray jArray =  new JSONArray(filmJSONString);
                for(int i = 0; i<jArray.length(); i++)
                {
                    //values collected
                    JSONObject jObject = jArray.getJSONObject(i);

                    String name = jObject.getString("name");

                }



            }
            catch (JSONException e)
            {
                e.printStackTrace();

            }*//*


    }

    private void parseJSON(String data)
    {
        try
        {
           JSONArray jsonMainNode = new JSONArray(data);

           int jsonArrLength = jsonMainNode.length();

           for(int i=0; i< jsonMainNode.length(); i++)
           {
               JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
               String postTitle = jsonChildNode.getString("post_title");
               filmArrayList.add(postTitle);
           }
           //get listview object from xml
           listView = (ListView) findViewBy(R.id.list);

            ArrayAdapter<String> adapter = ArrayAdapter<String>(FetchFilm.this, android.R.layout.simple_list 1, android.R.id.text1, tutorialList);

            listView.setAdapter(adapter);
        }
        catch (Exception e)
        {
            Log.i("app", "Error parsing data" + e.getMessage());
        }
    }




 //@params

    @Override
    protected void onPostExecute(String s)
    {

       // watching.data.setText(this.data);
        try
        {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            int i = 0;
            String title = null;
            String year = null;

            while(i<itemsArray.length() || (year == null && title == null))
            {
                JSONObject film = itemsArray.getJSONObject(i);
                JSONObject filmType = film.getJSONObject("filmType");

                try
                {
                    title = filmType.getString("title");
                    year = filmType.getString("year");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                //to move onto next item
                i++;
            }
            if(title !=null && year !=null)
            {
                nTitleText.setText(title);
                nYearText.setText(year);
                nFilmInput.setText("");
            }
            else
            {
                nTitleText.setText(R.string.no_results);
                nYearText.setText("");
            }
        }
        catch (Exception e)
        {
            nTitleText.setText(R.string.no_results);
            nYearText.setText("");
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

}*/

