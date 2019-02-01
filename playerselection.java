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
import android.widget.ImageButton;
import android.widget.Toast;

public class playerselection extends Activity {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public

    public static final String NUMBER = "";

    //······························································································
    // private

    ImageButton one_player_button;
    ImageButton two_players_button;
    String number_of_players = "0";

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
        setContentView(R.layout.activity_playerselection);

        one_player_button = findViewById(R.id.one_player_button);
        two_players_button = findViewById(R.id.two_players_button);

        one_player_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_of_players = "1";
                ChangeActivity();

            }
        }
        );

        two_players_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_of_players = "2";
                ChangeActivity();
            }
        }
        );

    }

    /**
     * Method that changes the activity passing the number or players choosen by the user
     */
    void ChangeActivity(){

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(NUMBER, number_of_players);

        startActivity(intent);
        finish();

    }

    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
