package net.clementlevallois.functions.model;

import java.util.List;

/**
 * Document profile detected by auto-profiling or set by the user.
 *
 * @param actorFocus          "PEOPLE" | "ORGANIZATIONS" | "BOTH"
 * @param isAcademic          whether the content is academic/scientific (drives stripBibliography default)
 * @param suggestedCategories relation category names suggested by auto-profiling (e.g. "FAMILY", "PROFESSIONAL")
 */
public record AnalysisProfile(
        String actorFocus,
        boolean isAcademic,
        List<String> suggestedCategories
) {
    public static final String PEOPLE = "PEOPLE";
    public static final String ORGANIZATIONS = "ORGANIZATIONS";
    public static final String BOTH = "BOTH";
}
