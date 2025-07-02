package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class WorkflowSimProps {

    public static final String NAME = Globals.Names.SIM.getDescription();
    public static final String ENDPOINT = "workflow-sim";

    public static final String KEY_NODES_NAME_EXTENSION = "key_nodes";
    public static final String KEY_NODES_FILE_EXTENSION = ".json";

    private final Path tempDirectoryAllProjects;

    public WorkflowSimProps(Path tempDirectoryAllProjects) {
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
        MIN_SHARED_TARGETS, SOURCE_COL_INDEX
    }

    public enum BodyJsonKeys {
        LINES
    }

}
