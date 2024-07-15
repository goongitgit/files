
"""L4_3 IS 330 - IS330 - Lab4 Q3 - February 4th, 2021
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

def ave_total_pay(ave_total_pay, count_salesman):
        ave_total_pay = ave_total_pay / count_salesman
        return ave_total_pay#, count_salesman



def submit():
        commission = 0
        #inputs
        weekly_sales = float(input("Please enter the weekly sales: "))
        #compute commision
        if weekly_sales >= 1000:
                commission = weekly_sales * SALES_RATE

        #computer total pay with comission
        if commission > 0:
                total_pay = BASE_SALARY + commission
        else:
                total_pay = BASE_SALARY

        
        #output
        #print(f'weekly sales ${weekly_sales:.2f} \n' )
        #print(f'Your commision is ${commission:.2f}' )
        #print(f'Your total pay is ${total_pay:.2f} \n' )


        return commission, weekly_sales, total_pay

def summary():
# show average pay, salespersons, salesperson_with commision
        average_total_pay = 0
        count_salesman = 0
        with_commission_count = 0
        without_commission_count = 0
        choice = 'y'
        while choice == 'y':

                commission, weekly_sales, total_pay = submit()
                print(f'weekly_sales {weekly_sales}')
                print(f'commission {commission}')
                print(f'total_pay {total_pay} ')
                average_total_pay += total_pay
                if commission == 0:
                        without_commission_count += 1
                elif commission != 0:
                        with_commission_count += 1
                count_salesman += 1
                choice = str(input("Enter y to continue, n to exit >>"))
                #display number  of online orders, number of offline orders, average reveue
        average_total_pay = ave_total_pay(average_total_pay, count_salesman)
        print(f'Average pay {average_total_pay} ')
        print(f'Number of Salespersons {without_commission_count} ')
        print(f'Number of Salespersons earning commission {with_commission_count}')

        return
#main
summary()



