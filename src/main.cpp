#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char* argv[]) {
  string line;
  ifstream file(argv[1]);
  while (getline(file, line)) {
    if (line == "hello") {
      cout << "Hello to you too!\n";
    }
  }
  return 0;
}