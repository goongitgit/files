


// Write a program that uses a loop to display the characters for each ASCII code
32
// through 127.
// Display 16 characters on each line with one space between characters.
#include <iostream>
using namespace std;
int main()
{
char asciiCode;
for (int i = 32; i <= 127; i++)
{
asciiCode = i;
cout << i << " " << (char)i << endl;
if (i % 16 == 0)
cout << endl;
}
cout << endl << endl;
}
