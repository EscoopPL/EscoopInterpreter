#include <iostream>
#include <fstream>
using namespace std;

void parseOptions(char* argv[], int argc) {
  for (int i = 0; i < argc; ++i) {
    if (argv[i][0] == '-') {
      for (int j : argv[i]) {
        if (j == 0) {
          break
        }
        if (j == 1 and argv[i][j] == '-') {
          cout << "literal"
        }
      }
    }
  }
}

int main(int argc, char* argv[]) {
  parseOptions(argv, argc);
  string line;
  ifstream file(argv[1]);
  while (getline(file, line)) {
    if (line == "hello") {
      cout << "Hello to you too!\n";
    }
  }
  return 0;
}