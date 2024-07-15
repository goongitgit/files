"""L2_2 IS 330
A salesperson earns a weekly base salary plus a commission, which is given 
when sales are at or above a specified quota.  

Input:  A user of your app will enter weekly sales for a salesperson, and the 
        app will figure out the commission, and  total pay for the salesperson.

Compute: The base salary is given as 250$.  Commission is earned when sales are 
        at or above a quota of 1000, at a rate of 15% of the sales.  
        (sales  is a dollar figure, and not the number of items sold)

        example:  sales at 2000.  Commission at 15%  of 2000 is 300$. 
  
Output: display commission and total pay for the salesperson. (total pay is salary 
        and commission combined) If there is no commission, do not display 
        commission amount. (see comment below)

Comments:
“If there is no commission, do not display commission amount.” => Display commission  only if there is a commission. => you need an if statement within the Outputs section of your code. The lines displaying commission are controlled by this if statement.

Implementation - the computations of commission and total pay.
Interface - the output section (and the input section). The statements implementing 
output should not overlap with the computation section. 

"""
#constant
BASE_SALARY = 250.00
SALES_RATE = 0.15  #15 percent

#inputs
weekly_sales = float(input("Please enter the weekly sales: "))


#compute commision
commision = weekly_sales * SALES_RATE

#computer total pay with comission
total_pay = BASE_SALARY + commision

#output
print(f'Your commision is ${commision:.2f}' )
print(f'Your total pay is ${total_pay:.2f} \n' )