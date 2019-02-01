///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public


    //······························································································
    //private

    /**
     * The list with the stars that this player has
     */
   List<Question.category> stars = new ArrayList<>();

    /**
     * The ID of this player
     */
   int ID;


    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public

    /**
     * Builder method of Player class
     * @param _id
     */
    public Player(int _id){
        this.ID = _id;
    }


    //······························································································
    //private

    /**
     * Method that gives a start to the player in the given category
     * @param _category
     */
    void AddStart(Question.category _category){

        Random _random = null;

        //If the player has not earn the given start, it's added to his list
        if(!stars.contains(_category)){
            stars.add(_category);

            if(stars.size() == 6){
                Turn.instance.EndGame();
            }
        }
    }


    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

}
