package com.esmaeeil_moradi.easy_learning_static;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //as we’re using the toolbar from the Support Library
        ActionBar actionBar = getSupportActionBar();
        //This enables the Up button. Even though we're using a toolbar for our app bar,
        actionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab1);
        final CharSequence text = "Your order has been updated";
        final int duration = Snackbar.LENGTH_LONG;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(OrderActivity.this, "Undone!!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                snackbar.show();
            }
        });
    }

}
