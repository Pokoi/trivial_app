///
/// Created by Jesus 'Pokoidev' Villar, jesusferminvillar@gmail.com (www.pokoidev.com)
/// On January 2019
/// Copyright © 2019 Pokoidev. Creative Commons License:
/// Attribution 4.0 International (CC BY 4.0)
///

package com.pokoidev.trivial;

public class intPointer {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region PARAMETERS

    //······························································································
    // public

    public int value;

    //······························································································
    //private

    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region METHODS

    //······························································································
    // public

    /**
     * Default builder method
     */
    public intPointer(){};

    /**
     * Custom builder methods that sets "value" with a given integer
     * @param _value
     */
    public intPointer(int _value){
        this.value = _value;
    }

    //······························································································
    //private

    //endregion
    ////////////////////////////////////////////////////////////////////////////////////////////////


}
