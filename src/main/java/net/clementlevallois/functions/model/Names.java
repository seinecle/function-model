/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package net.clementlevallois.functions.model;

/**
 *
 * @author clevallois
 */
public enum Names {
    
    COWO("cowo"),
    SIM("gaze-sim"),
    COOC("gaze-cooc"),
    UMIGON("umigon"),
    ORGANIC("organic"),
    TOPICS("topics"),
    CONTEXT_FROM_SAMPLE("context-from-sample"),
    SPATIALIZE_FORCE_ATLAS("spatialize-force-atlas"),
    PDF_REGION_EXTRACTOR("pdf-region-extractor"),
    PDF_MATCHER("pdf-matcher"),
    COMMUNITY_INSIGHTS("community-insights"),
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
    
}
