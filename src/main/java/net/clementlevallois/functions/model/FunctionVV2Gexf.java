package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class FunctionVV2Gexf {

    public static final String NAME = Globals.Names.GEXF_2_VV.getDescription();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static final String ENDPOINT = "convert2Gexf";
    private final Path tempDirectoryAllProjects;

    public FunctionVV2Gexf(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

}
