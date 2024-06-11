package org.escoopPL.Interpreter;

import java.util.HashMap;
import java.util.Map;

public class ASTnode {
    ASTnode() {}

    private Map<String, ASTnode> nodes = new HashMap<>();

    public ASTnode getNode(String node) {
        return nodes.get(node);
    }
    public void addNode(String name, ASTnode node) {
        nodes.put(name, node);
    }
}
