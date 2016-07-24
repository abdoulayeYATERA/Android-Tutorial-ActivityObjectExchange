package com.yadevapp.activityobjectexchangetutorial.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.yadevapp.activityobjectexchangetutorial.R;
import com.yadevapp.activityobjectexchangetutorial.element.Movie;
import com.yadevapp.activityobjectexchangetutorial.intentUtils.IntentConstant;

import java.util.ArrayList;

/**
 * Created by abdoulaye on 7/24/16.
 */
public class SecondActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    private TextView mMovieNameTextView;
    private TextView mMovieYearTextView;
    private TextView mMovieTypeTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //get views
        mMovieNameTextView = (TextView) findViewById(R.id.activity_second_movie_name_textview);
        mMovieYearTextView = (TextView) findViewById(R.id.activity_main_movie_year_edittext);
        mMovieTypeTextView = (TextView) findViewById(R.id.activity_second_movie_type_textview);
        
        Bundle extra = getIntent().getExtras();

        if (extra == null) {
            Toast.makeText(
                    this,
                    getResources().getString(R.string.empty_intent_toast_message),
                    Toast.LENGTH_LONG).show();
            return;
        }
        ArrayList<Movie> movieArrayList = (ArrayList<Movie>) extra.getSerializable(IntentConstant.KEY_MOVIE);
        Log.d(TAG, "movieArray received");
        
        if (movieArrayList == null || movieArrayList.size() < 1) {
            Toast.makeText(
                    this,
                    getResources().getString(R.string.no_movie_received_toast_message),
                    Toast.LENGTH_LONG).show();
            return;
        }
        //show movie informations
        Movie movieToShow = movieArrayList.get(0);
        mMovieNameTextView.setText("movie name : " + movieToShow.getmName());
        mMovieTypeTextView.setText("movie type : " + movieToShow.getmType());
        mMovieYearTextView.setText("movie year : " + String.valueOf(movieToShow.getmYear()));
    }
}
