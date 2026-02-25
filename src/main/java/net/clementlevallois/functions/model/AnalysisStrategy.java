package net.clementlevallois.functions.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility for resolving entity types from actorFocus and providing
 * fallback category suggestions.
 *
 * <p>Relation categories are now selected directly by the user on the frontend.
 * The LLM profiling task suggests categories; this class provides a static fallback.
 */
public final class AnalysisStrategy {

    private AnalysisStrategy() {} // utility class

    /**
     * Resolves entity types from the actorFocus field.
     */
    public static List<String> resolveEntityTypes(String actorFocus) {
        List<String> entities = new ArrayList<>();
        entities.add("PERSON");
        boolean includeOrg = AnalysisProfile.ORGANIZATIONS.equals(actorFocus)
                || AnalysisProfile.BOTH.equals(actorFocus);
        if (includeOrg) {
            entities.add("ORGANIZATION");
        }
        return List.copyOf(entities);
    }

    /**
     * Returns safe default categories when auto-profiling is unavailable.
     */
    public static List<String> defaultCategories() {
        return List.of("PERSONAL", "PROFESSIONAL");
    }
}
