package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class WorkflowCoocProps {

    public static final String NAME = Globals.Names.COOC.getDescription();
    public static final String ENDPOINT = "workflow-cooc";

    public static final String KEY_NODES_NAME_EXTENSION = "key_nodes";
    public static final String KEY_NODES_FILE_EXTENSION = ".json";
    public static final String FORMATTED_COOCCURRENCES_FILE_EXTENSION = ".json";

    private final Path tempDirectoryAllProjects;

    public WorkflowCoocProps(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public Path getGexfFilePath(String jobId) {
        Path pathOfGexf = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + Globals.GEXF_FILE_EXTENSION);
        return pathOfGexf;
    }

    public Path getOriginalTextInputFilePath(String jobId) {
        Path pathOfGexf = tempDirectoryAllProjects.resolve(jobId).resolve(jobId);
        return pathOfGexf;
    }

    public Path getPathForCooccurrencesFormattedAsJson(String jobId) {
        Path pathOfGexf = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + FORMATTED_COOCCURRENCES_FILE_EXTENSION);
        return pathOfGexf;
    }

    public enum BodyJsonKeys {
        LINES
    }

}
