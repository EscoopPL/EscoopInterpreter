package org.escoopPL.Interpreter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Main {
    static String outputDest = "";
    private static EscoopLexer escoopLexer;
    private static EscoopParser escoopParser = new EscoopParser();

    public static void main(String[] args) {
        parseOptions(args);
        try {
            escoopLexer = new EscoopLexer(args[args.length - 1]);
        } catch (FileNotFoundException e) {
            System.out.println("Target File " + args[args.length - 1] + " not found.");
            exit(0);
        }
        List<Token> tokens = new ArrayList<Token>();
        while (escoopLexer.hasNextToken()) {
            try {
                Token token = escoopLexer.nextToken();
                if (token.type() >= 4) {
                    System.out.println("Token[type=\"" + EscoopLexer.regularExpressions[token.type()] + "\", value=" + token.value() + ", end=" + token.end() + "]");
                    tokens.add(token);
                }
            } catch (InvalidTokenException e) {
                System.out.println(e.getMessage());
                exit(0);
            }
        }
        escoopParser.parse(tokens);
    }

    public static void parseOptions(String[] args) {
        boolean nextCanBeDefault = false;
        if (args.length == 0) {
            System.out.println("Incorrect Usage: target not found");
            printHelp();
        }
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-h", "--help":
                    printHelp();
                    break;
                case "-o":
                    outputDest = args[i+1];
                    break;
                case "--output":
                    try {
                        outputDest = args[i+1];
                        nextCanBeDefault = true;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Incorrect Usage: OUTPUTDEST not found");
                        printHelp();
                    }
                    break;
                default:
                    if (!nextCanBeDefault && !(i == args.length - 1)) {
                        System.out.println("Incorrect Usage:");
                        printHelp();
                    } else {
                        nextCanBeDefault = false;
                    }
            }
        }
    }
    public static void printHelp() {
        System.out.println("Usage: escoop [options] <target>\nOptions:\n\t-h, --help\t\tDisplay this message\n\t-o, --output OUTPUTDEST\tSet destination to output compiled file to");
        exit(0);
    }
}
