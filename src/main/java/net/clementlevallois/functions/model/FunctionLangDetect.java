package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class FunctionLangDetect {

    public static final String NAME = Globals.Names.LANG_DETECT.getDescription();
    public static final String ENDPOINT = "lang-detect";

    private final Path tempDirectoryAllProjects;

    public FunctionLangDetect(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

}
