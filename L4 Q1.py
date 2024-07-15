
""" Lab4 Q1 - February 4th, 2021
User specifies the number of books ordered,  and if the order is online, or not.  You can collect the second input by asking the user to enter 1 for online, and 0 for offline.  You can assume that the user will enter 1 or 0 as directed.
Unit price for a  book   is 15$. 
Online orders get shipping cost added:    per book 25 cents upto 10 books, after that,  flat rate of  5$. 
Offline orders get taxed,  at 8%. 
(that is: no ship cost for offline orders, no tax for online orders)

App displays:  Order price,  inclusive of shipping/tax.

Hint: 1. The input 1 or 0 typed by user will come in as ‘1’ or ‘0’, strings. 
 2. In Python, the 1 is equivalent to true, and 0 is equivalent to false. So if you have a variable holding the 1/0 value for online/offline , you can use that variable as if it were a boolean variable.   Note you can do this problem equally well without using this hint.
"""
#constant
UNIT_PRICE = 15

#function
def books(): #how many books are ordered
    number_of_books = int(input("Enter the number of books ordered: "))
   
    return number_of_books


def ordered(): #how many books are ordered
    ordered = int(input("Enter order (0 or 1): "))
   
    return ordered #books order online or offline

def compute_books_price(number_of_books):

    books_cost = number_of_books * UNIT_PRICE
 
    return books_cost




def shipping_cost(number_of_books):
    if number_of_books <= 10:
        shipping_cost = number_of_books * 0.25
    else:
        shipping_cost = (number_of_books * 0.25) + 5.00

    return shipping_cost

def taxes(book_cost):
    tax_rate = 0.08
    tax =  book_cost * tax_rate

    return tax

def compute_average_revenue(books_price, number_of_books):
    revenue = books_price * number_of_books
    return revenue


def submit():
    number_of_books = books()
    book_order = ordered()
    books_price = compute_books_price(number_of_books)
    if book_order == 0:
        cost = taxes(books_price)
    else:
        cost = shipping_cost(number_of_books)
    total_cost = books_price + cost

    ave_revenue = compute_average_revenue(books_price, number_of_books)
    return number_of_books, book_order,books_price, total_cost, ave_revenue

def summary():
    offline_count = 0
    online_count = 0
    total_revenue = 0
    k = 'y'


    while k == 'y':
        number_of_books, book_order, books_price, total_cost, revenue = submit()
        #number_of_books, book_order, books_price, total_cost, revenue = submit()
        print(f'You ordered {number_of_books} books, and the total cost is ${total_cost}.')
        if book_order == 0:
            offline_count += 1
        else:
            online_count += 1
        total_revenue += revenue
        k = str(input("Enter y to continue, n to exit >>"))
    #display number  of online orders, number of offline orders, average reveue
    print(f'online ordered were {online_count} ')
    print(f'offline ordered were {offline_count} ')
    print(f'Total Revenue {total_revenue} ')
    return

#main


#A summary function displays: number of online orders, number of offline orders, 
#average revenue across all orders (average does not include tax or shipping cost). 
#Use a function to compute average revenue.

summary()

#output
print()

