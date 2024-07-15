L1_4
Prompt the user for: name, weight in pounds of coffee ordered, 
one by one. One pound of coffee costs 18.5$. Compute order price. 
Orders are taxed at 7%. Compute tax. Shipping cost is charged at 
75cents per pound. Compute shipping cost. 

Billed amount is the sum of order price, tax, and shipping cost. 
Display output: Hello <name>, you ordered <weight> pounds of coffee, 
and on the next line, and you owe <billed>$, including <ship>$ for shipping, 
and <tax>$ tax.
"""

#inputs
name = input("Name: ")
weight = float(input("Weight of Coffee (lbs): "))

#compute tax
tax = 0.07 * weight #weight is a float type

#compute shipping cost
shipping = 0.75 * weight #since weight is float type, shipping get set as a float

#compute total cost
totalCost = (18.5*weight) + tax + shipping #totalCost is set as float due to weight type

#output
print(f'Hello {name:s} , you ordered {weight:.2f} pounds of coffee,')
print(f'and you owe {totalCost:.2f}$, including {shipping:.2f}$ for shipping, and {tax:.2f} tax.')
