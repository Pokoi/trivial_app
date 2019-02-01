///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import com.pokoidev.trivial.Question.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionsDB {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public

    static public QuestionsDB instance;

    public List<Question> all_questions = new ArrayList<Question>();

    public List<Question> arcade_questions = new ArrayList<Question>();;

    public List<Question> action_questions = new ArrayList<Question>();;

    public List<Question> horror_questions = new ArrayList<Question>();;

    public List<Question> moba_and_battle_royale_questions = new ArrayList<Question>();;

    public List<Question> survival_questions = new ArrayList<Question>();;

    public List<Question> platforms_questions = new ArrayList<Question>();;

    //······························································································
    //private


    /**
     * The amount of arcade questions shown to the players
     */
    static intPointer arcade_shown_questions = new intPointer();

    /**
     * The amount of action questions shown to the players
     */
    static intPointer action_shown_questions = new intPointer();

    /**
     * The amount of horror questions shown to the players
     */
    static intPointer horror_shown_questions = new intPointer();

    /**
     * The amount of moba and battle royale questions shown to the players
     */
    static intPointer moba_and_battle_royale_shown_questions = new intPointer();

    /**
     * The amount of survival questions shown to the players
     */
    static intPointer survival_shown_questions = new intPointer();

    /**
     * The amount of platforms questions shown to the players
     */
    static intPointer platforms_shown_questions = new intPointer();

    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public

    /**
     * Builder method of QuestionsDB class
     */
    public QuestionsDB(){
            if(instance==null) instance = this;

    }

    /**
     * Returns a random category
     * @return
     */
    public category RandomCategory(){

        category _category = null;

        Random _random = new Random();

        switch(_random.nextInt(6)){
            case 0:

                _category = category.arcade;
                break;

            case 1:
                _category = category.action;
                break;

            case 2:
                _category = category.horror;
                break;

            case 3:
                _category = category.moba_and_battle_royale;
                break;

            case 4:
                _category = category.survival;
                break;

            case 5:
                _category = category.platforms;
                break;

        }

        return _category;
    }

    /**
     * Method that generate a random question of the given category
     * @return
     */
    public Question GenerateQuestion(){

        Question question_to_return = null;

        switch (RandomCategory()){

            case arcade:

                if(arcade_questions.size() <= arcade_shown_questions.value)
                {
                    Reset(arcade_questions, arcade_shown_questions);
                }
                question_to_return = RandomQuestion(arcade_questions);
                break;

            case action:

                if(action_questions.size() <= action_shown_questions.value)
                {
                    Reset(action_questions, action_shown_questions);
                }
                question_to_return = RandomQuestion(action_questions);
                break;

            case horror:

                if(horror_questions.size() <= horror_shown_questions.value)
                {
                    Reset(horror_questions, horror_shown_questions);
                }
                question_to_return = RandomQuestion(horror_questions);
                break;

            case moba_and_battle_royale:

                if(moba_and_battle_royale_questions.size() <= moba_and_battle_royale_shown_questions.value)
                {
                    Reset(moba_and_battle_royale_questions, moba_and_battle_royale_shown_questions);
                }
                question_to_return = RandomQuestion(moba_and_battle_royale_questions);
                break;

            case survival:

                if(survival_questions.size() <= survival_shown_questions.value)
                {
                    Reset(survival_questions, survival_shown_questions);
                }
                question_to_return = RandomQuestion(survival_questions);
                break;

            case platforms:

                if(platforms_questions.size() <= platforms_shown_questions.value)
                {
                    Reset(platforms_questions, platforms_shown_questions);
                }
                question_to_return = RandomQuestion(platforms_questions);
                break;
            }

            question_to_return.shown = true;
            return question_to_return;

        }

    //······························································································
    //private

        /**
     * Method that returns a random question of a given array list of questions
     * @param _questions
     * @return
     */
        private Question RandomQuestion(List<Question> _questions){

            Random r = new Random();
            int random_number;
          do
           {
            random_number = r.nextInt(_questions.size());
           } while(_questions.get(random_number).shown);

           return _questions.get(random_number);
        }


        /**
         * Reset a given array elements' shown value and updates to 0 a given int
         * @param _questions
         * @param int_reference
         */
        private void Reset (List<Question> _questions, intPointer int_reference){

                for (Question _question: _questions)
                { _question.shown = false; }
                int_reference.value = 0;
        }


    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////


}
