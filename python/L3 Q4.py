"""Lab3 Problem 4
 An application that uses the number of hours worked in a week by an employee to compute and display the gross pay, the taxes and the net pay. Net pay is gross pay less taxes. 
There is a single input, hours, and three outputs: gross pay , tax and net pay.

Use the following rules:

Basic pay rate = 10$ per hour
Overtime rate (in excess of 40 hours) = time and a half  
(means 1.5 times the regular rate)
Tax rate  : 15% of the first 300$
          	20% of the next 150$
          	25% of the rest
             (this is a tiered rate system, with tax computed
			  as sum of components, the formula changing for 
			  each tier)

testing: Use 50 as the value of hours worked. Test the program 
also with the values 30, 40.
"""

#constant
PAY_RATE = 10

#functions
def compute_pay(hrs):
	if hrs <= 40:
		pay = hrs * PAY_RATE
	else:
		pay = (PAY_RATE * 40) + ((hrs - 40) * (PAY_RATE * 1.5))

	return pay

def compute_tax_rate(pay):
	if pay <= 300: #first three hundre
	   tax_rate = 0.15
	elif (pay > 300 and pay <= 450):  # 300 to 400
		tax_rate = 0.20
	else:
		tax_rate = 0.25

	return tax_rate

#main

#input
hours_worked = (float(input("Enter number of hours worked: ")))

#ccall function
pay = compute_pay(hours_worked)
tax = compute_tax_rate(pay)
total_pay = (pay * tax) + pay

#output
print(f'You worked {hours_worked:.2f}, Your pay is {total_pay:.2f} including tax')
