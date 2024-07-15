"""Lab3 Problem 2, 
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

def compute_shipping_cose_or_taxes(number_of_books, ordered):
    if book_order == 0:
        cost = taxes(books_price)
    else:
        cost = shipping_cost(number_of_books)

    return cost


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

#main


number_of_books = books()
book_order = ordered()
books_price = compute_books_price(number_of_books)

cost = compute_shipping_cose_or_taxes(number_of_books, ordered)


total_cost = books_price + cost

#output
print()
print(f'You ordered {number_of_books} books, and the total cost is ${total_cost}.')
