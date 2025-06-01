package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class Globals {

    public static final String API_ENDPOINT_ROOT = "/api/";
    public static final String TOP_NODES_FILE_EXTENSION = ".json";
    public static final String GLOBAL_RESULTS_JSON_FILE_EXTENSION = ".json";
    public static final String TOP_FILE_NAME_EXTENSION = "_topnodes";
    public static final String GEXF_FILE_EXTENSION = ".gexf";
    public static final String RESULTS_PAGE = "results.xhtml";
    public static final String FACES_REDIRECT = "?faces-redirect=true";
    public static final String WORKFLOW_COMPLETE_FILE_NAME_EXTENSION = "workflow_is_complete";
    private final Path tempDirectoryAllProjects;

    public Globals(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public enum GlobalQueryParams {
        SESSION_ID, JOB_ID, CALLBACK_URL
    }

    public Path getTopNetworkVivaGraphFormattedFilePath(String dataPersistenceUniqueId) {
        Path pathOfTopNodesData = tempDirectoryAllProjects.resolve(dataPersistenceUniqueId).resolve(dataPersistenceUniqueId + Globals.TOP_NODES_FILE_EXTENSION);
        return pathOfTopNodesData;
    }

    public Path getWorkflowCompleteFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + WORKFLOW_COMPLETE_FILE_NAME_EXTENSION);
        return path;
    }

}
