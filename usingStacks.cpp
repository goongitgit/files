/* Use stack to print items backward */
#include <iostream>
#include <stack>
using namespace std;
// this function is called by main()
void callStack(stack<int> stk)
{
while (!stk.empty()) {
cout << stk.top() << " ";
stk.pop();
}
}
// main starts here
int main()
{
stack<int> s; // initiate stack
// using LIFO method for all the items
s.push(1);
s.push(2);
s.push(3);
s.push(5);
s.push(8);
callStack(s); // calling myStack function with stacked items
return 0;
}
