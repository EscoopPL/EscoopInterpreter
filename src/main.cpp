#include <iostream>
#include <fstream>
#include <string>
#include "tokens.cpp"
using namespace std;

string outputDest = "";

void printHelp() {
  cout << "Usage: escoop [options] <target>\nOptions:\n\t-h, --help\t\tDisplay this message\n\t-o, --output OUTPUTDEST\tSet destination to output compiled file to\n";
  exit(0);
}

void parseOptions(char* argv[], int argc) {
  for (int i = 0; i < argc; ++i) {
    if (argv[i][0] == '-') {
      string option = argv[i];
      if (option == "-h" or option == "--help" or option == "-help") {
        printHelp();
      } else if (option == "-o" or option == "--output") {
        outputDest = argv[i + 1];
      } else {
        cout << "Incorrect Usage\n";
        printHelp();
      }
    }
  }
}

int main(int argc, char* argv[]) {
  if (argc == 1) {
    cout << "Incorrect Usage\n";
    printHelp();
  }
  parseOptions(argv, argc);
  string* tokensInFile = tokens(argv[argc - 1]);
  cout << sizeof(tokensInFile) << " Tokens In File.\n";
  for (int i = 0; i < sizeof(tokensInFile); ++i) {
    cout << tokensInFile[i] << "\n";
  }
  return 0;
}