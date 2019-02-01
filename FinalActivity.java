///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.pokoidev.trivial.MainActivity.PLAYER;

public class FinalActivity extends Activity {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public




    //······························································································
    // private

    Button restart_button;
    Button exit_button;
    TextView winner_text;

    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public




    //······························································································
    // private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        restart_button = findViewById(R.id.restart);
        exit_button    = findViewById(R.id.exit);
        winner_text    = findViewById(R.id.winner_text);

        Intent intent = this.getIntent();
        winner_text.setText(intent.getStringExtra(PLAYER));

        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent _intent = new Intent(FinalActivity.this, playerselection.class);
                startActivity(_intent);
                finish();
            }
        });

        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }


    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////




}
