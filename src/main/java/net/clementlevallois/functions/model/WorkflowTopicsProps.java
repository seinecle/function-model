package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class WorkflowTopicsProps {

    public static final String NAME = "workflow-topics";
    public static final String ENDPOINT = "workflow/topics";
    private final Path tempDirectoryAllProjects;

    public WorkflowTopicsProps(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public Path getGlobalResultsJsonFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + Globals.GLOBAL_RESULTS_JSON_FILE_EXTENSION);
        return path;
    }

    public Path getGexfFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + Globals.GEXF_FILE_EXTENSION);
        return path;
    }

    public Path getWorkflowCompleteFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + Globals.WORKFLOW_COMPLETE_FILE_NAME_EXTENSION);
        return path;
    }

    public Path getOriginalTextInputFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId);
        return path;
    }

    public enum QueryParams {
        LANG, REPLACE_STOPWORDS, IS_SCIENTIFIC_CORPUS, LEMMATIZE, REMOVE_ACCENTS, PRECISION, MIN_CHAR_NUMBER, MIN_TERM_FREQ
    }

    public enum BodyJsonKeys {
        USER_SUPPLIED_STOPWORDS
    }

}
