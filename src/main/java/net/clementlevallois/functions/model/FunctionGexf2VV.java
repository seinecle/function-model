package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class FunctionGexf2VV {

    public static final String NAME = Globals.Names.GEXF_2_VV.getDescription();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static final String ENDPOINT = "convert2vv";
    private final Path tempDirectoryAllProjects;

    public FunctionGexf2VV(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }


    public enum GexfToVVQueryParams{
        ITEM,ITEMS, LINK, LINKS, LINK_STRENGTH, TOTAL_LINK_STRENGTH, DESCRIPTION_DATA
    }
}
