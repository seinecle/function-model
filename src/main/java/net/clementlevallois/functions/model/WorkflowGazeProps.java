package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class WorkflowGazeProps {

    public static final String NAME = "workflow-gaze";
    public static final String ENDPOINT_GAZE = "workflow/gaze";
    public static final String ENDPOINT_COOC = "workflow/gaze/cooc";
    public static final String ENDPOINT_SIM = "workflow/gaze/sim";

    public static final String KEY_NODES_NAME_EXTENSION = "key_nodes";
    public static final String KEY_NODES_FILE_EXTENSION = ".json";

    private final Path tempDirectoryAllProjects;

    public WorkflowGazeProps(Path tempDirectoryAllProjects) {
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

    public enum QueryParams {
        MIN_SHARED_TARGETS
    }

    public enum BodyJsonKeys {
        LINES
    }

}
