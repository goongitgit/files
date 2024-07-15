
/* A local zoo wants to keep track of how many pounds of food each of
its three monkeys eats each day during a typical week.Write a program
that stores this information in a two - dimensional 3x7 array, where
each row represents a different monkeyand each column represents a
different day of the week.The program should first have the user input
the data for each monkey.Then it should create a report that includes
the following information :
Average amount of food eaten per day by the whole family of monkeys
The least amount of food eaten during the week by any one monkey
The greatest amount of food eaten during the week by any one monkey
*/
#include <iostream>
using namespace std;
int main()
{
int food[3][7];
int enterPounds = 0;
int sum = 0;
int sum1 = 0;
int sum2 = 0;
int sum3 = 0;
int total_sum = 0;
int count = 0;
int ave = 0;
int least = 0;
int greatest = 0;
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 7; j++) {
if ((i == 0 and j == 0) or
(i == 1 and j == 0) or
(i == 2 and j == 0))
std::cout << "For monkey" << endl;
else
{
std::cout << "Enter pounds for each day " << endl;
cin >> enterPounds;
food[i][j] = enterPounds;
}
}
}
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 7; j++) {
if (i == 0 and j == 0) {
std::cout << "" << i << endl;
}
else if (i == 1 and j == 0)
{
std::cout << "" << i << endl;
}
else if (i == 2 and j == 0)
{
std::cout << "" << i << endl;
}
}
}
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 7; j++) {
if (i == 0 and j == 0) {
std::cout << "" << i << endl;
}
else if (i == 1 and j == 0)
{
std::cout << "" << endl;
}
else if (i == 2 and j == 0)
{
std::cout << "" << endl;
}
else
if (i == 0) {
sum1 = sum1 + food[i][j];
}
else if (i == 1) {
sum2 = sum2 + food[i][j];
}
else if (i == 2) {
sum3 = sum3 + food[i][j];
// least
// greatest
if (sum3 < food[i][j])
least = sum3;
else
least = food[i][j];
if (sum3 > food[i][j])
greatest = sum3;
else
greatest = food[i][j];
}
count = count + 1;
}
}
total_sum = sum1 + sum2 + sum3;
ave = total_sum / count;
std::cout << "Average amount of food eaten per day by the whole famlily
of monkeys : " << ave << endl;
std::cout << "The least amount of food eaten during the week by any one
monkey: " << least << endl;
std::cout << "The greatest amount of food eaten during the week by any
one monkey: " << greatest << endl;
}


