package com.yadevapp.activityobjectexchangetutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.yadevapp.activityobjectexchangetutorial.element.Movie;
import com.yadevapp.activityobjectexchangetutorial.R;
import com.yadevapp.activityobjectexchangetutorial.intentUtils.IntentConstant;

import java.util.ArrayList;

/**
 * in this activity the user create a movie and send it to the secondActivity
 */
public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    
    private Button mSendMovieButton;
    private EditText mNewMovieNameEditText;
    private EditText mNewMovieYearEditText;
    private EditText mNewMovieTypeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the views
        mNewMovieNameEditText = (EditText) findViewById(R.id.activity_main_movie_name_edittext);
        mNewMovieYearEditText = (EditText) findViewById(R.id.activity_main_movie_year_edittext);
        mNewMovieTypeEditText = (EditText) findViewById(R.id.activity_main_movie_type_edittext);
        mSendMovieButton = (Button) findViewById(R.id.activity_main_add_movie_button);

        //set listener to button
        mSendMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create Movie instance from edit texts
                //we create and send 100 copies of the movie to test the efficiency of this
                //data transfer method
                ArrayList<Movie> movieToSendArray = new ArrayList<Movie>();
                String movieToSendName = mNewMovieNameEditText.getText().toString();
                String movieToSendType = mNewMovieTypeEditText.getText().toString();
                int movieToSendYear = Integer.valueOf(mNewMovieYearEditText.getText().toString());

                if (movieToSendName != null && !movieToSendName.isEmpty()
                        && movieToSendType != null && !movieToSendType.isEmpty()
                        && movieToSendYear > 0) {
                    //the form is correctly completed
                    for (int i = 0; i < 100; i++) {
                        Movie movieToSend = new Movie();
                        movieToSend.setmName(movieToSendName);
                        movieToSend.setmType(movieToSendType);
                        movieToSend.setmYear(movieToSendYear);
                        movieToSendArray.add(movieToSend);
                    }
                    //send movieArray to second activity
                    //log the current time
                    Log.d(TAG, "send movieArray start");
                    Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                    secondActivityIntent.putParcelableArrayListExtra(IntentConstant.KEY_MOVIE, movieToSendArray);
                    startActivity(secondActivityIntent);
                } else {
                    //the form is not correctly completed
                    Toast.makeText(MainActivity.this,
                            getResources().getString(R.string.wrong_form_toast_message),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
