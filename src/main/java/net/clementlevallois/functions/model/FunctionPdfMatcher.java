/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.clementlevallois.functions.model;


/**
 *
 * @author clevallois
 */
public class FunctionPdfMatcher {

    public static final String NAME = Globals.Names.PDF_MATCHER.getDescription();
    public static final String ENDPOINT = "pdfmatcher";
    
    public enum QueryParams{
        START_OF_PAGE, END_OF_PAGE, TYPE_OF_CONTEXT, CASE_SENSITIVE, SEARCHED_TERM, FILE_NAME, NB_WORDS, NB_LINES
    }

    public enum BodyParams{
        LINES, PAGES
    }

}
