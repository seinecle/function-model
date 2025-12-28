package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class FunctionRegionExtract {

    public static final String NAME = Globals.Names.REGION_EXTRACTOR.getDescription();
    public static final String ENDPOINT = "pdf/extract-region";

    private final Path tempDirectoryAllProjects;

    public FunctionRegionExtract(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public enum QueryParams {
        FILE_NAME_PREFIX, ALL_PAGES, SELECTED_PAGES, LEFT_CORNER_Y, LEFT_CORNER_X, WIDTH, HEIGHT
    }
}
