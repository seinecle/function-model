package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class FunctionPdfRegionExtract {

    public static final String NAME = Globals.Names.PDF_REGION_EXTRACTOR.getDescription();
    public static final String ENDPOINT = "pdf_region_extractor";

    private final Path tempDirectoryAllProjects;

    public FunctionPdfRegionExtract(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public enum QueryParams {
        OWNER, ALL_PAGES, SELECTED_PAGES, LEFT_CORNER_Y, LEFT_CORNER_X, WIDTH, HEIGHT
    }

    public enum BodyParams {
        PDF_BYTES, FILE_NAME
    }

}
