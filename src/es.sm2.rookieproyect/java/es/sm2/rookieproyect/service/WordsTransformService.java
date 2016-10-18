package es.sm2.rookieproyect.service;
import es.sm2.rookieproyect.exception.RookieProjectException;
import es.sm2.rookieproyect.model.WordsTransformRequest;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Alejandro.jimenez on 11/07/2016.
 */

public class WordsTransformService {
    public String wordsTransform(WordsTransformRequest wordsTransformRequest) throws RookieProjectException {
        String transformedWord = null;
        try{
            Properties propierties = new Properties();

        /**Cargamos el archivo desde la ruta especificada*/
            propierties.load(new FileInputStream(
                    "C:/Users/Alejandro.jimenez/IdeaProjects/Rookie/src/es.sm2.rookieproyect/resources/config.properties"));

        /**Obtenemos los parametros definidos en el archivo*/
            String configWord = propierties.getProperty("nombre");
            transformedWord = (wordsTransformRequest.getWord1().toUpperCase()) +
                    (wordsTransformRequest.getWord2().toUpperCase())+ configWord.toUpperCase();


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


       /* try {
            input.close();
        } catch (java.io.IOException e) {
            return "error service"; //e.printStackTrace();

        }*/

        return transformedWord;
    }


}








