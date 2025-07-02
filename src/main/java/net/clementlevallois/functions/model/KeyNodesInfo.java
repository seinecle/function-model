/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.clementlevallois.functions.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author clevallois
 */
public class KeyNodesInfo {

    public static final String NAME = Globals.Names.KEY_NODES.getDescription();
    public static final String KEY_NODES_SAMPLE_FILE_EXTENSION = ".json";

    private final Map<String, String> nodeIdsAndLabels = new HashMap();

    private final Map<String, TreeMap<String, String>> insights = new HashMap();

    public void addCommunity(String community) {
        insights.putIfAbsent(community, new TreeMap<>());
    }

    public void addInsightToCommunity(String community, String insight, String nodeId, String nodeLabel) {
        TreeMap<String, String> insightsForOneCommunity = insights.getOrDefault(community, new TreeMap());
        insightsForOneCommunity.put(insight, nodeId);
        insights.put(community, insightsForOneCommunity);
        nodeIdsAndLabels.putIfAbsent(nodeId, nodeLabel);
    }

    public void addInsightToCommunity(String community, String insight) {
        TreeMap<String, String> insightsForOneCommunity = insights.getOrDefault(community, new TreeMap());
        insightsForOneCommunity.put(insight, "");
        insights.put(community, insightsForOneCommunity);
    }

    public Map<String, TreeMap<String, String>> getInsights() {
        return insights;
    }

    public Map<String, String> getNodeIdsAndLabels() {
        return nodeIdsAndLabels;
    }

    public String getLabelForNodeId(String nodeId) {
        return nodeIdsAndLabels.getOrDefault(nodeId, "no label found for node id " + nodeId);
    }

    public JsonObject nodeToLabelsAsJson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        insights.forEach((community, communityInsights) -> {
            JsonObjectBuilder communityBuilder = Json.createObjectBuilder();
            communityInsights.forEach((insight, nodeId) -> {
                String label = nodeIdsAndLabels.getOrDefault(nodeId, "");
                communityBuilder.add(insight, Json.createObjectBuilder()
                        .add("nodeId", nodeId)
                        .add("label", label));
            });
            builder.add(community, communityBuilder);
        });
        return builder.build();
    }

    public JsonObject toJsonForInsights() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        insights.forEach((community, communityInsights) -> {
            JsonObjectBuilder communityBuilder = Json.createObjectBuilder();
            communityInsights.forEach((insight, nodeId) -> {
                communityBuilder.add(insight, nodeId);
            });
            builder.add(community, communityBuilder);
        });
        return builder.build();
    }
}
