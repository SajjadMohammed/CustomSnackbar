package com.sajjad.customsnackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowSnackBar(View view) {
        final Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE);
        snackbar.getView().setPadding(0, 0, 0, 0);
        // must remove default snackbar view
        ((ViewGroup) snackbar.getView()).removeAllViews();
        View customView = LayoutInflater.from(this).inflate(R.layout.custom_snackbar, null);
        // add your own view
        ((ViewGroup) snackbar.getView()).addView(customView);

        Button button = customView.findViewById(R.id.messageButton);
        final EditText snackbarText=customView.findViewById(R.id.titleText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), snackbarText.getText(), Toast.LENGTH_LONG).show();
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}
