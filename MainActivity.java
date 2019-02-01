///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.pokoidev.trivial.playerselection.NUMBER;

public class MainActivity extends Activity {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public

    public static TextView  question_title;
    public static TextView  current_player;
    public static Button    first_answer;
    public static Button    second_answer;
    public static Button    third_answer;
    public static ImageView action_star;
    public static ImageView arcade_star;
    public static ImageView horror_star;
    public static ImageView survival_star;
    public static ImageView moba_and_battle_royale_star;
    public static ImageView platforms_star;
    public static Context   main_context;
    public static final String PLAYER = "";
    public static QuestionsDB my_questions_DB;


    //······························································································
    //private


    Turn        my_turn_manager;
    XMLParser   my_parser;
    int         count_of_players;


    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public

    /**
     * Static reference to the end this activity
     */
    public static void EndActivity(String _string){


        Intent intent = new Intent(main_context, FinalActivity.class);

        intent.putExtra(PLAYER, _string);

        main_context.startActivity(intent);

    }

    //······························································································
    //private

    /**
     * When the activity starts
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = this.getIntent();
        count_of_players =  Integer.parseInt(intent.getStringExtra(NUMBER));

        my_questions_DB = new QuestionsDB();
        my_turn_manager = new Turn();
        my_parser       = new XMLParser();
        main_context    = this;

        Initialization();

        OnClickEvents();

        //ParseXML and add the questions to QuestionsDB
        my_questions_DB.all_questions = my_parser.parseXML(main_context);

        //Create players
        my_turn_manager.CreatePlayers(count_of_players);

        //Turn actions
        my_turn_manager.TurnActions();


    }

    /**
     * Initialization of layout views
     */
    void Initialization(){
        question_title              = findViewById(R.id.question_text)  ;
        first_answer                = findViewById(R.id.first_answer)   ;
        second_answer               = findViewById(R.id.second_answer)  ;
        third_answer                = findViewById(R.id.third_answer)   ;
        action_star                 = findViewById(R.id.first_category) ;
        arcade_star                 = findViewById(R.id.second_category);
        horror_star                 = findViewById(R.id.third_category) ;
        moba_and_battle_royale_star = findViewById(R.id.forth_category) ;
        survival_star               = findViewById(R.id.fifth_category) ;
        platforms_star              = findViewById(R.id.sixth_category) ;
        current_player              = findViewById(R.id.current_player) ;
    }

    /**
     * On click events of the game buttons
     */
    void OnClickEvents(){
        first_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_turn_manager.CheckResponse(1);
            }
        });

        second_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_turn_manager.CheckResponse(2);
            }
        });

        third_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_turn_manager.CheckResponse(3);
            }
        });

    }



    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

}
