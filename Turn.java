///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;

public class Turn {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public

    /**
     * A global access to an instance of this class
     */
    public static Turn instance;



    //······························································································
    //private

    /**
     * The array list of players in the game
     */
    ArrayList<Player> players = new ArrayList<>();

    int               turn;

    Question          current_question;

    Player            current_player;

    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public

    /**
     * Builder Turn class method
     */
    public Turn(){

        if(instance == null){
            instance = this;
        }

    }

    /**
     * Create the amount of players
     * @param amount
     */
    public void CreatePlayers(int amount){

        //Reset the array list of players
        players.clear();

        for(int iterator = 0; iterator < amount; iterator++){
            players.add(new Player(iterator));
        }
    }

    /**
     * The actions on each turn
     */
    public void TurnActions(){

            //Gets the player of this turn
            current_player = players.get(turn);

            //Set the current player text
            MainActivity.current_player.setText("Jugador " + Integer.toString(turn+1));

            //Prints the stars
            PrintStarts();

            //Rolls the dice and gets a random question
            current_question = QuestionsDB.instance.GenerateQuestion();

            //Updates the activity components
            MainActivity.question_title.setText(current_question.question);
            MainActivity.first_answer.setText(current_question.answers.get(0));
            MainActivity.second_answer.setText(current_question.answers.get(1));
            MainActivity.third_answer.setText(current_question.answers.get(2));

    }

    /**
     * Returns if the player's answer is correct or not
     * @param _answer
     * @return
     */
    public void CheckResponse(int _answer){

        if(_answer == current_question.correct_answer_index){

            current_player.AddStart(current_question.my_category);
        }

        turn = (turn == players.size() - 1) ? 0 : turn + 1;

        TurnActions();
    }

    /**
     * Method that ends the game
     */
    public void EndGame(){

        //Finish activity
        MainActivity.EndActivity("Ha ganado el jugador " +  Integer.toString(turn +1));

    }

    //······························································································
    //private

    /**
     * Method that print the stars drawable.
     * Depends on what stars current player has.
     */
    void PrintStarts(){

            CheckStars(Question.category.arcade,
                       MainActivity.arcade_star,
                       MainActivity.main_context.getDrawable(R.drawable.active_1),
                       MainActivity.main_context.getDrawable(R.drawable.inactive_1));

            CheckStars(Question.category.action,
                    MainActivity.action_star,
                    MainActivity.main_context.getDrawable(R.drawable.active_2),
                    MainActivity.main_context.getDrawable(R.drawable.inactive_2));

            CheckStars(Question.category.horror,
                    MainActivity.horror_star,
                    MainActivity.main_context.getDrawable(R.drawable.active_3),
                    MainActivity.main_context.getDrawable(R.drawable.inactive_3));

            CheckStars(Question.category.moba_and_battle_royale,
                    MainActivity.moba_and_battle_royale_star,
                    MainActivity.main_context.getDrawable(R.drawable.active_4),
                    MainActivity.main_context.getDrawable(R.drawable.inactive_4));

            CheckStars(Question.category.platforms,
                    MainActivity.platforms_star,
                    MainActivity.main_context.getDrawable(R.drawable.active_5),
                    MainActivity.main_context.getDrawable(R.drawable.inactive_5));

            CheckStars(Question.category.survival,
                    MainActivity.survival_star,
                    MainActivity.main_context.getDrawable(R.drawable.active_6),
                    MainActivity.main_context.getDrawable(R.drawable.inactive_6));
        }

    /**
     * Method that returns if the player has some star
     * @param _category
     * @return
     */
    void CheckStars(Question.category _category, ImageView _image_view, Drawable _active_drawable, Drawable _inactive_drawable){

        Drawable drawable_to_print = null;

        drawable_to_print = (current_player.stars.contains(_category))
                            ? _active_drawable
                            : _inactive_drawable;

        _image_view.setImageDrawable(drawable_to_print);


    }



    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

}
