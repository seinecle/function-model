package net.clementlevallois.functions.model;

import java.nio.file.Path;

/**
 *
 * @author clevallois
 */
public class WorkflowCowoProps {

    public static final String NAME = Globals.Names.COWO.getDescription();
    public static final String ENDPOINT = "workflow/cowo";
    public static boolean IS_PMI_ENABLED = false;
    private final Path tempDirectoryAllProjects;

    public WorkflowCowoProps(Path tempDirectoryAllProjects) {
        this.tempDirectoryAllProjects = tempDirectoryAllProjects;
    }

    public Path getGexfFilePath(String dataPersistenceUniqueId) {
        Path pathOfGexf = tempDirectoryAllProjects.resolve(dataPersistenceUniqueId).resolve(dataPersistenceUniqueId + Globals.GEXF_FILE_EXTENSION);
        return pathOfGexf;
    }

    public Path getOriginalTextInputFilePath(String dataPersistenceUniqueId) {
        Path pathOfGexf = tempDirectoryAllProjects.resolve(dataPersistenceUniqueId).resolve(dataPersistenceUniqueId);
        return pathOfGexf;
    }

    public enum QueryParams {
        LANG, MIN_CHAR_NUMBER, REPLACE_STOPWORDS, IS_SCIENTIFIC_CORPUS, LEMMATIZE, REMOVE_ACCENTS, MIN_TERM_FREQ, MIN_COOC_FREQ, REMOVE_FIRST_NAMES, MAX_NGRAMS, TYPE_CORRECTION
    }

}
