package net.clementlevallois.functions.model;

import java.nio.file.Path;

public class WorkflowNerGraphProps {

    public static final String NAME = Globals.Names.NER_GRAPH.getDescription();
    public static final String ENDPOINT = "workflow/nergraph";
    private final Path tempDirectoryAllProjects;

    public WorkflowNerGraphProps(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public Path getGexfFilePath(String dataPersistenceUniqueId) {
        return tempDirectoryAllProjects.resolve(dataPersistenceUniqueId)
                .resolve(dataPersistenceUniqueId + Globals.GEXF_FILE_EXTENSION);
    }

    public Path getOriginalTextInputFilePath(String dataPersistenceUniqueId) {
        return tempDirectoryAllProjects.resolve(dataPersistenceUniqueId)
                .resolve(dataPersistenceUniqueId);
    }

    public enum QueryParams {
        LANG,
        ENTITY_TYPES,
        RELATION_CATEGORIES,
        PROMPT_MODIFIERS,
        STRIP_BIBLIOGRAPHY
    }
}
