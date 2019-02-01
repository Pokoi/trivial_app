///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

import android.content.Context;
import android.content.res.AssetManager;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Class that manages the XML parse
 */
public class XMLParser {


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public


    //······························································································
    //private



    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public

    /**
     * Method that parse a given xml file
     */
    public ArrayList<Question> parseXML(Context context){

        ArrayList<Question> _questions = new ArrayList<>();

        try {
            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();

            XmlPullParser parser = parserFactory.newPullParser();

            InputStream is =context.getAssets().open("questions_spa.xml");


            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);

            parser.setInput(is, null);

            _questions =  ProcessParsing(parser);

        } catch (XmlPullParserException e)
        { } catch (IOException e)
        { }

        return _questions;

    }

    //······························································································
    //private

    /**
     * Method that process the xml parse data
     */
    private ArrayList <Question> ProcessParsing(XmlPullParser parser) throws IOException, XmlPullParserException{
        ArrayList<Question> _questions = new ArrayList<>();

        //The event type
        int event_type = parser.getEventType();
        Question current_question = null;

        //Looping while the parser is not at the end of the document
        while(event_type != XmlPullParser.END_DOCUMENT){

            //Reset the parser_name
            String parser_name = null;

            switch (event_type){

                //When the parser is at a start tag
                case XmlPullParser.START_TAG :

                    //Gets the name of the tag
                   parser_name = parser.getName();

                   //If the tag is "question", the parser is a new question
                   if(parser_name.equals("question")) {

                       //Create a new question
                       current_question = new Question ();

                       //And add it to the question list
                       _questions.add(current_question);

                    //If the parser is not at "question" tag and the question is created,
                    //the parser is at some intern tag of "question"
                   } else if (current_question != null){

                       //If the tag is "title", the parser is at the question text
                       if(parser_name.equals("title")){

                           //Set the question title
                           current_question.question = parser.nextText();

                        //If the tag is "answer", the parser is at some answer of the question
                       }else if (parser_name.equals("answer")){

                           //Add the answer text to the question answers list
                           current_question.answers.add(parser.nextText());

                        //If the tag is "correct_answer", the parser is at the correct answer index
                       }else if (parser_name.equals("correct_answer")){

                            //Cast the text to int and set the "correct_answer_index" of the question
                           current_question.correct_answer_index = Integer.parseInt(parser.nextText());

                        //If the tag is "category", the parser is at the category label of the question
                       }else if (parser_name.equals("category")){

                           //Analize the text to assign a category
                           switch (parser.nextText()){
                               case "arcade":
                                   current_question.my_category = Question.category.arcade;
                                   MainActivity.my_questions_DB.arcade_questions.add(current_question);
                                   break;
                               case "action":
                                   current_question.my_category = Question.category.action;
                                   MainActivity.my_questions_DB.action_questions.add(current_question);
                                   break;
                               case "horror":
                                   current_question.my_category = Question.category.horror;
                                   MainActivity.my_questions_DB.horror_questions.add(current_question);
                                   break;
                               case "platforms":
                                   current_question.my_category = Question.category.platforms;
                                   MainActivity.my_questions_DB.platforms_questions.add(current_question);
                                   break;
                               case "survival":
                                   current_question.my_category = Question.category.survival;
                                   MainActivity.my_questions_DB.survival_questions.add(current_question);
                                   break;
                               case "moba_and_battle_royale":
                                   current_question.my_category = Question.category.moba_and_battle_royale;
                                   MainActivity.my_questions_DB.moba_and_battle_royale_questions.add(current_question);
                                   break;
                           }
                       }
                   }
                   break;
            }

            event_type = parser.next();
        }
         return _questions;
    }

    //······························································································
    //private



    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
