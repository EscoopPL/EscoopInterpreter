#include <iostream>
#include <fstream>
using namespace std;

string findEntireString(ifstream& in) {
    string line = "";
    string output = "";
    while (getline(in, line)) {
      output = output + line + '\n';
    }
    output[output.length() - 1] = ' ';
    return output;
}

int countChar(string s, char c) {
  int count = 0;

  for (int i = 0; i < s.size(); i++) {
    if (s[i] == c) count++;
  }

  return count;
}

string* strsplit(string split);

string* tokens(string filename) {
  ifstream in(filename);
  string file = findEntireString(in);
  return strsplit(file);
}

string* strsplit(string split) {
  string* output = new string[split.size()];
  int outputPointer = 0;
  string buffer = "";
  int bufferPointer = 0;
  for (int i = 0; i < split.size(); ++i) {
    if (split[i] != ' ') {
      buffer[bufferPointer] = split[i];
      cout << split[i];
      bufferPointer++;
    } else {
      output[outputPointer] = buffer;
      cout << "\n" << buffer << "\n";
      outputPointer++;
      buffer = "";
      bufferPointer = 0;
    }
  }
  return output;
}