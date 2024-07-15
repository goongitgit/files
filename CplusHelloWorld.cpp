#include <iostream>
using namespace std;
int main()
{
	int elec, water, cable, food, RM, total = 0;
	cout << "Welcome to the Grievous home budget calculator" << endl;
	cout << "How much do you pay for electricity? ";
	cin >> elec;
	cout << "How much do you pay for water? ";
	cin >> water;
	cout << "How much do you pay for cable? ";
	cin >> cable;
	cout << "How much do you pay for food? ";
	cin >> food;
	cout << "How much do you pay for rent/mortgage? ";
	cin >> RM;
	cout << endl;
	total = elec + water + cable + food + RM;
	cout << "Your bills" << endl;
	cout << " Electricity $" << elec << endl;
	cout << " Water $" << water << endl;
	cout << " Cable $" << cable << endl;
	cout << " Food $" << food << endl;
	cout << " Rent/Mortgage $" << RM << endl;
	cout << "-------------------------------------------" << endl;
	cout << " Total $" << total << endl;
}
