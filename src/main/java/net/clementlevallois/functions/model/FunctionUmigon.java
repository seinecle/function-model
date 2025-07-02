/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class FunctionUmigon {

    public static final String NAME = Globals.Names.UMIGON.getDescription();
    public static final String ENDPOINT = "sentimentForAText";
    public static final String ENDPOINT_DATA_FROM_FILE = "sentimentForATextFromFile";

    private final Path tempDirectoryAllProjects;

    public FunctionUmigon(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }
    
    
    public enum QueryParams {
        TEXT_LANG, SHORTER, EXPLANATION_LANG, EXPLANATION, OWNER, OUTPUT_FORMAT
    }

}
