package net.clementlevallois.functions.model;

import java.nio.file.Path;
import java.util.Arrays;

/**
 *
 * @author clevallois
 */
public class Globals {

    public static final String API_ENDPOINT_ROOT = "/api/";
    public static final String TOP_NODES_FILE_EXTENSION = ".json";
    public static final String GLOBAL_RESULTS_JSON_FILE_EXTENSION = ".json";
    public static final String GLOBAL_RESULTS_BYTE_FILE_EXTENSION = ".bin";
    public static final String TOP_FILE_NAME_EXTENSION = "_topnodes";
    public static final String GEXF_FILE_EXTENSION = ".gexf";
    public static final String DATA_SHEET_FILE_EXTENSION = ".sheet";
    public static final String RESULTS_PAGE = "results.xhtml";
    public static final String PNG_EXTENSION = ".png";
    public static final String FACES_REDIRECT = "?faces-redirect=true";
    public static final String WORKFLOW_COMPLETE_FILE_NAME_EXTENSION = "workflow_is_complete";
    public static final String UPLOADED_FILE_PREFIX = "uploaded_file_";
    private final Path tempDirectoryAllProjects;

    public Globals(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public enum GlobalQueryParams {
        JOB_ID, CALLBACK_URL
    }

    public enum Names {

        COWO("workflow-cowo"),
        SIM("worfklow-sim"),
        COOC("workflow-cooc"),
        UMIGON("umigon"),
        NETWORKCONVERTER("networkconverter"),
        ORGANIC("organic"),
        TOPICS("workflow-topics"),
        CONTEXT_FROM_SAMPLE("context-from-sample"),
        SPATIALIZE_FORCE_ATLAS("spatialize"),
        PDF_REGION_EXTRACTOR("pdf-region-extractor"),
        PDF_MATCHER("pdf-matcher"),
        COMMUNITY_INSIGHTS("worfklow-community-insights"),
        KEY_NODES("key-nodes"),
        TEXT_PER_COMMUNITY("text-per-community"),
        TOP_NODES("top-nodes"),
        CSS_HIGHLIGHTER("css-highlighter");

        private final String description;

        Names(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static Names fromDescription(String desc) {
            return Arrays.stream(values())
                    .filter(n -> n.description.equals(desc))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown description: " + desc));
        }

    }

    public Path getTopNetworkVivaGraphFormattedFilePath(String jobId) {
        Path pathOfTopNodesData = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + Globals.TOP_NODES_FILE_EXTENSION);
        return pathOfTopNodesData;
    }

    public Path getResultInBinaryFormat(String jobId) {
        Path pathOfResultAsByteData = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + Globals.GLOBAL_RESULTS_BYTE_FILE_EXTENSION);
        return pathOfResultAsByteData;
    }

    public Path getInputDataPath(String jobId) {
        Path pathOfSimpleInputData = tempDirectoryAllProjects.resolve(jobId).resolve(jobId);
        return pathOfSimpleInputData;
    }

    public Path getJobDirectory(String jobId) {
        Path pathOfJobDirectory = tempDirectoryAllProjects.resolve(jobId);
        return pathOfJobDirectory;
    }

    public Path getPngPath(String jobId, String fileUniqueId) {
        Path pathOfPngFile = tempDirectoryAllProjects.resolve(jobId).resolve(fileUniqueId + PNG_EXTENSION);
        return pathOfPngFile;
    }

    public Path getDataSheetPath(String jobId, String fileUniqueId) {
        Path pathOfDataSheetFile = tempDirectoryAllProjects.resolve(jobId).resolve(fileUniqueId + DATA_SHEET_FILE_EXTENSION);
        return pathOfDataSheetFile;
    }

    public Path getWorkflowCompleteFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + WORKFLOW_COMPLETE_FILE_NAME_EXTENSION);
        return path;
    }

    public Path getGexfCompleteFilePath(String jobId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(jobId + GEXF_FILE_EXTENSION);
        return path;
    }

    public Path getInputFileCompletePath(String jobId, String fileUniqueId) {
        Path path = tempDirectoryAllProjects.resolve(jobId).resolve(fileUniqueId);
        return path;
    }

}
