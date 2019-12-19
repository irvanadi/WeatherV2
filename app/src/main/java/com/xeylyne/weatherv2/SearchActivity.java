package com.xeylyne.weatherv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class SearchActivity extends AppCompatActivity {

    EditText edSearch;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        edSearch = findViewById(R.id.edSearch);
        constraintLayout = findViewById(R.id.constraintLayout);

        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckInput(edSearch.getText().toString());
            }
        });
    }

    private void CheckInput(String Search){

        if (!Search.isEmpty()){
            Intent intent = new Intent(SearchActivity.this, MainActivity.class);
            intent.putExtra("url", Search);
            startActivity(intent);
        } else {
            Snackbar.make(constraintLayout, "Please Input Your City/Country" , Snackbar.LENGTH_SHORT).show();
        }
    }
}
