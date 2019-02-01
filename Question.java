///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import java.util.ArrayList;

public class Question {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public

    /**
     The possible categories
     */
    public enum category {arcade, action, horror, moba_and_battle_royale, survival, platforms};

    /**
     The question text
     */
    public String question;

    /**
     The collection of answers
     */
    public ArrayList<String> answers = new ArrayList<>();

    /**
     The index of the correct answer
     */
    public int correct_answer_index;

    /**
     * The category of this question
     */
    public category my_category;


    //······························································································
    //private


    /**
     * If this question was shown to any player
     */
    boolean shown;
    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public




    //······························································································
    //private



    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

}
