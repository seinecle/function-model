package net.clementlevallois.functions.model;

/**
 * Document profile detected by auto-profiling or set by the user.
 * Describes the nature of the documents being analyzed along 4 dimensions.
 *
 * @param contentType   "FACTUAL" | "OPINIONS" | "MIXED"
 * @param hasControversy whether the content contains opposing sides or disputes
 * @param actorFocus    "PEOPLE" | "ORGANIZATIONS" | "BOTH"
 * @param isAcademic    whether the content is academic/scientific (triggers bibliography stripping)
 */
public record AnalysisProfile(
        String contentType,
        boolean hasControversy,
        String actorFocus,
        boolean isAcademic
) {
    public static final String FACTUAL = "FACTUAL";
    public static final String OPINIONS = "OPINIONS";
    public static final String MIXED = "MIXED";

    public static final String PEOPLE = "PEOPLE";
    public static final String ORGANIZATIONS = "ORGANIZATIONS";
    public static final String BOTH = "BOTH";
}
