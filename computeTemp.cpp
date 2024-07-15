/* compute fahrenheit degrees to celcius degrees */
#include <iostream>
#include <iomanip>
#include <ios>

using namespace std;
// convert Fahrenheit to Celsius degree
float T(int f)
{
// compute celcius degree from fahrenheit
float c;
c = (5.0 / 9.0) * (f - 32.0);
return c;
}
int main()
{
const int Count = 100; // upper limit is 100
int count;
int fahren = 0; // starts with 0 Farhenheit
cout << " F C " << endl;
cout << " - -" << endl;
for (count = 0; count <= Count; count = count + 5)
{
// call T function to compute degrees
cout << setw(3) << count << " " << setprecision(3) << T(count);
cout << "\n";
}
return 0;
}
