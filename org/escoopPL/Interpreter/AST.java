package org.escoopPL.Interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AST {
    AST() {}
    private final Map<String, ASTnode> nodes = new HashMap<>();

    public void addNode(String name, ASTnode node, List<String> path) {
        ASTnode lastNode = getNode(path);
        if (lastNode != null) {
            lastNode.addNode(name, node);
        } else {
            nodes.put(name, node);
        }
    }

    public ASTnode getNode(List<String> path) {
        ASTnode lastNode = null;
        for (int i = 0; i < path.size(); i++) {
            if (i == 0) {
                lastNode = nodes.get(path.get(i));
            }
            lastNode = lastNode.getNode(path.get(i));
        }
        return lastNode;
    }
}
