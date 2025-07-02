package net.clementlevallois.functions.model;

/**
 *
 * @author clevallois
 */
public class FunctionOrganic {

    public static final String NAME = Globals.Names.ORGANIC.getDescription();
    public static final String ENDPOINT = "organic";

    public enum QueryParams {
        TEXT_LANG, SHORTER, ID, TEXT, EXPLANATION_LANG, EXPLANATION, OWNER, OUTPUT_FORMAT
    }
    
    public enum OutputFormat{
        HTML, PLAIN, JSON, BYTES
    }

}
