package com.yadevapp.activityobjectexchangetutorial.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.yadevapp.activityobjectexchangetutorial.R;
import com.yadevapp.activityobjectexchangetutorial.intentUtils.IntentConstant;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the views
        mTextView = (TextView) findViewById(R.id.activity_main_textview);
        mButton = (Button) findViewById(R.id.activity_main_button);
        //button listener
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(secondActivityIntent, IntentConstant.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IntentConstant.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra(IntentConstant.KEY_RESULT);
                mTextView.setText(result);
            } else {
                //no result
            }
        }
    }
}
