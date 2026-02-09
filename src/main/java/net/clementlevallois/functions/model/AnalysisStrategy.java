package net.clementlevallois.functions.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete pipeline parameters resolved from an {@link AnalysisProfile}.
 * Maps user-facing document dimensions to the technical entity types,
 * relation categories, and prompt modifiers used by the extraction pipeline.
 *
 * @param entityTypes        entity types to extract (e.g. "PERSON", "ORGANIZATION")
 * @param relationCategories relation categories to use (e.g. "POSITIVE_AFFINITY", "INSTITUTIONAL")
 * @param promptModifiers    additional prompt instructions injected after relation categories
 * @param stripBibliography  whether to strip bibliography/references sections before analysis
 */
public record AnalysisStrategy(
        List<String> entityTypes,
        List<String> relationCategories,
        List<String> promptModifiers,
        boolean stripBibliography
) {

    private static final String NUANCED_AFFINITY_RULE =
            "Create a link between actors who share affinities. "
            + "In case of indirect affinities, such as when 2 actors stand against a common actor or object, "
            + "do not link the 2 actors if they actually come from divergent or opposite directions for this opposition. "
            + "Do not merely link two actors because they would be neutrally co-occurring or co-mentioned "
            + "without a context that would bind them in some way.";

    /**
     * Resolves an {@link AnalysisProfile} into concrete pipeline parameters.
     */
    public static AnalysisStrategy fromProfile(AnalysisProfile profile) {
        List<String> entities = new ArrayList<>();
        List<String> relations = new ArrayList<>();
        List<String> modifiers = new ArrayList<>();

        entities.add("PERSON");

        boolean includeOrg = AnalysisProfile.ORGANIZATIONS.equals(profile.actorFocus())
                || AnalysisProfile.BOTH.equals(profile.actorFocus());
        if (includeOrg) {
            entities.add("ORGANIZATION");
        }

        String contentType = profile.contentType() != null ? profile.contentType() : AnalysisProfile.FACTUAL;
        boolean controversy = profile.hasControversy();

        switch (contentType) {
            case AnalysisProfile.FACTUAL -> {
                relations.add("POSITIVE_AFFINITY");
                relations.add("INSTITUTIONAL");
                if (controversy) {
                    relations.add("OPPOSITION");
                    relations.add("SHARED_STANCE");
                    modifiers.add("Allow antagonistic and hostile relationships between entities.");
                    if (includeOrg) {
                        modifiers.add("Include organization-level rivalries and institutional conflicts.");
                    }
                } else {
                    modifiers.add("Do NOT extract antagonistic or hostile relationships (rivalry, conflict, opposition).");
                }
            }
            case AnalysisProfile.OPINIONS -> {
                relations.add("POSITIVE_AFFINITY");
                if (controversy) {
                    relations.add("OPPOSITION");
                    relations.add("SHARED_STANCE");
                    if (includeOrg) {
                        relations.add("INSTITUTIONAL");
                    }
                    modifiers.add(NUANCED_AFFINITY_RULE);
                    modifiers.add("Allow antagonistic and hostile relationships between entities.");
                } else {
                    if (includeOrg) {
                        relations.add("INSTITUTIONAL");
                    }
                    modifiers.add("Do NOT extract antagonistic or hostile relationships (rivalry, conflict, opposition).");
                }
            }
            case AnalysisProfile.MIXED -> {
                // Union of FACTUAL + OPINIONS rules for same controversy/actor combo
                relations.add("POSITIVE_AFFINITY");
                relations.add("INSTITUTIONAL");
                if (controversy) {
                    relations.add("OPPOSITION");
                    relations.add("SHARED_STANCE");
                    modifiers.add(NUANCED_AFFINITY_RULE);
                    modifiers.add("Allow antagonistic and hostile relationships between entities.");
                    if (includeOrg) {
                        modifiers.add("Include organization-level rivalries and institutional conflicts.");
                    }
                } else {
                    modifiers.add("Do NOT extract antagonistic or hostile relationships (rivalry, conflict, opposition).");
                }
            }
            default -> {
                relations.add("POSITIVE_AFFINITY");
                modifiers.add("Do NOT extract antagonistic or hostile relationships (rivalry, conflict, opposition).");
            }
        }

        boolean stripBib = profile.isAcademic();
        if (stripBib) {
            modifiers.add("Prioritize co-authorship subtypes when extracting INSTITUTIONAL relationships.");
        }

        return new AnalysisStrategy(
                List.copyOf(entities),
                List.copyOf(relations),
                List.copyOf(modifiers),
                stripBib
        );
    }
}
