package org.escoopPL.Interpreter;

public class Main {
    static String outputDest = "";

    public static void main(String[] args) {
        parseOptions(args);
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
        System.exit(0);
    }
}
