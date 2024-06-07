import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	private static String outputDest = "";
	private static String target = "";

	public static void main(String[] args) {
		parseOptions(args);
		List<String> tokens = tokenize(args);
		parse(tokens);
	}

	public static void parseOptions(String[] args) {
		boolean nextCanBeDefault = false;
		if (args.length == 0) {
			System.out.println("Incorrect Usage: target not found");
			printHelp();
		}
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "-h":
				printHelp();
				break;
			case "--help":
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
				if (!nextCanBeDefault != (i == args.length - 1)) {
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
	public static List<String> tokens(String str) {
		List<String> tokenList = new ArrayList<String>();
		Scanner tokenizer = new Scanner(str);
		while (tokenizer.hasNext()) {
			String token = tokenizer.next();
			tokenList.add(token);
		}
		tokenList.add("\n");
		tokenizer.close();
		return tokenList;
	}

	public static List<String> tokenize(String[] args) {
		List<String> file = new ArrayList<String>();
		target = args[args.length - 1];
		try {
			File fileToTokenize = new File(target);
			Scanner fileReader = new Scanner(fileToTokenize);
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				List<String> tokens = tokens(line);
				for (String str : tokens) {
					file.add(str);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Target file " + target + " does not exist.");
		}
		return file;
	}
	public static Map parse(List<String> tokens) {
		Map result = new HaseMap();
		for (int i = 0; i < tokens.size(); i++) {
			switch(tokens.get(i)) {
			case "identifier" {
				
			}
			}
		}
	}
}















