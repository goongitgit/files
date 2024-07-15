/* Use pointer and arrays to find largest value */
#include <iostream>
using namespace std;
int main()
{
float saveTemp, temp = 0.0;
float someValues[] = { 10.1,20.2,30.3,40.4 };
float* ptr = someValues;
for (int i = 0; i < 5; i++) {
if (temp >= *ptr) {
saveTemp = *ptr;
}
else {
saveTemp = temp;
}
temp = *ptr++;
}
cout << "largest Number " << saveTemp << endl;
}
