#include <iostream>

using namespace std;

class Point {
    const int x;
    int y;
    Point():x{0},y{0}{}
}

int main() {
 Point a;
 cout<<a.x;
}