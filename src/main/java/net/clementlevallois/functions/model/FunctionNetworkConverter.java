/*
 * Licence Apache 2.0
 * https://www.apache.org/licenses/LICENSE-2.0
 */
package net.clementlevallois.functions.model;

/**
 *
 * @author clevallois
 */
public class FunctionNetworkConverter {

    public static final String NAME = Globals.Names.NETWORKCONVERTER.getDescription();
    public static final String ENDPOINT = "networkconverter";
    public static final String ENDPOINT_GEXF_TO_VV = "convert2vv";
    public static final String ENDPOINT_VV_TO_GEXF = "convert2gexf";
    
    public enum GexfToVVQueryParams{
        ITEM,ITEMS, LINK, LINKS, LINK_STRENGTH, TOTAL_LINK_STRENGTH, DESCRIPTION_DATA
    }
}
