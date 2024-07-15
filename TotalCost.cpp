
// display a menu for food, drink, and dessert
// And display the total amount of an order
#include <iostream>
using namespace std;
int main()
{
// variables are initialized
string drink, food, dessert;
int drinkCost = 0;
int foodCost = 0;
int dessertCost;
int total = 0;
cout << "Welcome to the Grievous Restaurant" << endl;
cout << "food menu" << endl;
cout << "\tChicken\t\t$15" << endl;
cout << "\t Beef\t\t$25" << endl;
cout << "\t Potato\t\t$18" << endl;
cout << "\t Salad\t\t$10" << endl;
cout << "Please, type your option: ";
cin >> food;
// select food from the following options
if (food == "Chicken") foodCost = 15;
else if (food == "Beef") foodCost = 25;
else if (food == "Potato") foodCost = 18;
else if (food == "Salad") foodCost = 10;
cout << "drink menu" << endl;
cout << "\t Wine\t\t$5" << endl;
cout << "\t Beer\t\t$8" << endl;
cout << "\tWater\t\t$3" << endl;
cout << "\t Tea\t\t$10" << endl;
cout << "Please, type your option: ";
cin >> drink;
// select drink for the following menu:
if (drink == "Wine") drinkCost = 5;
else if (drink == "Beer") drinkCost = 8;
else if (drink == "Water") drinkCost = 3;
else if (drink == "Tea") drinkCost = 10;
cout << "dessert menu" << endl;
cout << "\t Cake\t\t$5" << endl;
cout << "\tIce-cream\t\t$8" << endl;
cout << "\t nothing\t\t0$" << endl;
cout << "Please, type your option: ";
cin >> dessert;
cout << endl;
//select the dessert from the following options
if (dessert == "Cake") dessertCost = 5;
else if (dessert == "Ice-cream") dessertCost = 8;
else if (dessert == "nothing") dessertCost = 0;
// display the order
cout << "Your order" << endl;
cout << "\t Entree $" << foodCost << endl;
cout << "\t Drink $" << drinkCost << endl;
cout << "\t Dessert $" << dessertCost << endl;
// calculate the total
total = foodCost + drinkCost + dessertCost;
// display the total
cout << "------------------------------------------" << endl;
cout << "\t Total $" << total << endl;
}
