package org.escoopPL.Interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EscoopLexer {
    private String fullFile;
    public static final String[] regularExpressions = {"$", "\\s", "//.*\n", "//.*\\n", "/*[^\\x00]*\\*/", "\\n", "identifier", "int", "runfile", "class", "extends", "\".*\"|'{3}[\\s\\S]*'{3}", "(?<![)])[.\\w\\-]+(?![(])", "."};



    public EscoopLexer(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        StringBuilder fileString = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            fileString.append(fileScanner.nextLine());
            if (fileScanner.hasNextLine()) {
                fileString.append("\n");
            }
        }
        fullFile = fileString.toString();
    }

    public Token nextToken() throws InvalidTokenException {
        Token returnVal = new Token(-1, "\u0000", -1);
        for (int i = 0; i < regularExpressions.length; i++) {
            Pattern regexPattern = Pattern.compile(regularExpressions[i]);
            Matcher regexMatcher = regexPattern.matcher(fullFile);
            if (regexMatcher.find() && regexMatcher.start() == 0) {
                returnVal = new Token(i, regexMatcher.group(), regexMatcher.end());
                break;
            }
        }
        if (!(returnVal.type() == -1)) {
            fullFile = fullFile.substring(returnVal.end());
        } else {
            System.out.println("error");
            throw new InvalidTokenException("Token Type is invalid.");
        }
        return returnVal;
    }
    public boolean hasNextToken() {
        return !(fullFile.isEmpty());
    }

}
