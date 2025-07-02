package net.clementlevallois.functions.model;

/**
 *
 * @author clevallois
 */
public class FunctionSpatialization {

    public static final String NAME = Globals.Names.SPATIALIZE_FORCE_ATLAS.getDescription();
    public static final String ENDPOINT = "graphops/spatialization";

    public enum QueryParams {
        DURATION_IN_SECONDS
    }

}
