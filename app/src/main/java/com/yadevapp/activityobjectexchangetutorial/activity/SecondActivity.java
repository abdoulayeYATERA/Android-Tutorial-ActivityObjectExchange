package com.yadevapp.activityobjectexchangetutorial.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.yadevapp.activityobjectexchangetutorial.R;
import com.yadevapp.activityobjectexchangetutorial.intentUtils.IntentConstant;

public class SecondActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //get view
        mEditText = (EditText) findViewById(R.id.activity_second_edittext);
        mButton = (Button) findViewById(R.id.acitivity_second_result_button);
        //button listener
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                String result = mEditText.getText().toString();

                if (result.isEmpty()) {
                    setResult(RESULT_CANCELED);
                } else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(IntentConstant.KEY_RESULT, result);
                    setResult(RESULT_OK, resultIntent);
                }
                finish();
            }
        });
    }
}
