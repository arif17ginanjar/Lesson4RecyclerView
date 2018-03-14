package com.arif_ginanjar.lesson4recyclerview;

import java.util.ArrayList;

/**
 * Created by Arif_Ginanjar on 20/01/2018.
 */

public class CharacterData {

    public static String[][] data = new String[][]{
            {"Captain John Soap MacTavish","Task Force 141","https://vignette.wikia.nocookie.net/callofduty/images/b/b7/Soap_MW3_model.png/revision/latest/scale-to-width-down/300?cb=20120122010801"},
            {"John Price","Task Force 141","https://vignette.wikia.nocookie.net/callofduty/images/0/01/Price_MW3_model.png/revision/latest/scale-to-width-down/300?cb=20120120222323"},
            {"Yuri","Task Force 141","https://vignette.wikia.nocookie.net/callofduty/images/f/f1/Yuri_MW3_Model.jpg/revision/latest?cb=20120415040511"},
            {"Sandman","Delta Force","https://vignette.wikia.nocookie.net/callofduty/images/6/60/Sandman_infobox_image_MW3.png/revision/latest?cb=20120504040051"},
            {"Grinch","Delta Force","https://vignette.wikia.nocookie.net/callofduty/images/d/de/Grinch_down_the_rabbit_hole_MW3.png/revision/latest/scale-to-width-down/300?cb=20130131211527"},
            {"Truck","Delta Force","https://vignette.wikia.nocookie.net/callofduty/images/d/d6/MW3_Truck.png/revision/latest?cb=20120120013021"},
            {"Captain MacMillan","SAS","https://vignette.wikia.nocookie.net/callofduty/images/a/ae/MacMillan_CoD4.png/revision/latest/scale-to-width-down/300?cb=20140811045205"},
            {"Wallcroft","SAS","https://vignette.wikia.nocookie.net/callofduty/images/0/01/Wallcroft_Mind_the_Gap_MW3.jpg/revision/latest/scale-to-width-down/300?cb=20111119183615"},
            {"Griffen","SAS","https://vignette.wikia.nocookie.net/callofduty/images/2/21/Griffen_MW3.jpg/revision/latest?cb=20120403104224"}
    };

    public static ArrayList<Character> getListData(){
        Character character = null;
        ArrayList<Character> list = new ArrayList<>();

        for (String[] aData : data) {
            character = new Character();
            character.setName(aData[0]);
            character.setForces(aData[1]);
            character.setPhoto(aData[2]);

            list.add(character);
        }

        return list;
    }

}