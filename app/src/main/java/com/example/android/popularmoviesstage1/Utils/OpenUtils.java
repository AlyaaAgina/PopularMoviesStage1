package com.example.android.popularmoviesstage1.Utils;

import com.example.android.popularmoviesstage1.MovieData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Organization.TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.OVERVIEW;
import static com.example.android.popularmoviesstage1.Data.Contract.POSTER_PATH;
import static com.example.android.popularmoviesstage1.Data.Contract.RELEASE_DATE;
import static com.example.android.popularmoviesstage1.Data.Contract.RESULTS;
import static com.example.android.popularmoviesstage1.Data.Contract.VOTE_AVERAGE;

public class OpenUtils {

    public static ArrayList<MovieData> getMovies(String moviesJsonStr)
            throws JSONException {
        MovieData movies;
        ArrayList<MovieData> moviesArrayList = new ArrayList<>();
        /* String array to hold each elements String */
        JSONObject movieJson = new JSONObject(moviesJsonStr);
        //get all data inside JSONObject forecastJson
        JSONArray moviesArrayResults = movieJson.getJSONArray(RESULTS);
        //get all position of array-->  parsedMoviesData that come from JSONArray-->  moviesArrayResults
        for (int i = 0; i < moviesArrayResults.length(); i++) {
            /* These are the values that will be collected */
            movies = new MovieData();
            //long voteCount;
            long voteAverage;
            String original_title;
            String posterPath;
            String overview;
            String releaseDate;

            /* Get the JSON object representing the results */
            JSONObject objResult = moviesArrayResults.getJSONObject(i);
            /* Get the JSON object representing the--> ...vote_average... from -->JSONObject(results)*/
            voteAverage = objResult.optLong(VOTE_AVERAGE);
            /* Get the JSON object representing the -->...title... from--> JSONObject(results)*/
            original_title = objResult.optString(TITLE);
            /* Get the JSON object representing the -->...poster_path... from -->JSONObject(results)*/
            posterPath = objResult.optString(POSTER_PATH);
            /* Get the JSON object representing the -->....overview.... from--> JSONObject(results)*/
            overview = objResult.optString(OVERVIEW);
            /* Get the JSON object representing the -->....release_date.... from--> JSONObject(results)*/
            releaseDate = objResult.optString(RELEASE_DATE);
            movies.setVotAverage(voteAverage);
            movies.setOriginal_title(original_title);
            movies.setPoster_image(posterPath);
            movies.setOverview(overview);
            movies.setReleaseDate(releaseDate);

            moviesArrayList.add(movies);

        }

        return moviesArrayList;
    }
}
