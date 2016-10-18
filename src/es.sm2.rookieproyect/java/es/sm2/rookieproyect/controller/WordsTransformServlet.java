package es.sm2.rookieproyect.controller;

import es.sm2.rookieproyect.exception.RookieProjectException;
import es.sm2.rookieproyect.model.WordsTransformRequest;
import es.sm2.rookieproyect.service.WordsTransformService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Alejandro.jimenez on 11/07/2016.
 */
/*
Servlet
*/

@WebServlet(name = "WordsTransformServlet")
public class WordsTransformServlet extends HttpServlet {

    private WordsTransformRequest transformRequest;
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       PrintWriter out = response.getWriter();
       // primero selecciona el tipo de contenidos y otros campos de cabecera de la respuesta
       response.setContentType("text/html");
       // Luego escribe los datos de la respuesta
       WordsTransformRequest transformRequest= new WordsTransformRequest();

       WordsTransformService transformedWords = new WordsTransformService();

       String wordCaps= "";
       String word1 = request.getParameter("word1");
       String word2 = request.getParameter("word2");
       transformRequest.setWord1(word1);
       transformRequest.setWord2(word2);

       /*try {
           out.println("<h1>"+ "Respuesta: "+"</h1>");
           out.println("<h1>"+ transformedWords.wordsTransform(transformRequest)+ "</h1>");
       }catch (RookieProjectException e) {
            out.println("<h1>"+ "error try"+ "</h1>");  //e.printStackTrace();
       }*/

        out.println("<h1>"+ "Respuesta: "+"</h1>");
        wordCaps = transformService(transformedWords, transformRequest );
        out.println("<h1>"+ wordCaps+ "</h1>");
        out.close();
    }


    public  String transformService(WordsTransformService transformedWords,
                                                   WordsTransformRequest transformRequest ){
        String a= "";
        try {
            a= transformedWords.wordsTransform(transformRequest);
        } catch (RookieProjectException e) {
            e.printStackTrace();
        }

        return a;
    }



}

