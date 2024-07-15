"""L2_1 IS 330 - IS330 - Lab2 Q1 - January 19th, 2021
This program about computing salesperson's commission.

Input: Artichokes, carrots and beets are being bought 
        by weight in pounds. Each has per pound price:  2.67$, 1.49$, and .67$ 
        respectively. 2, 3 and 4 pounds respectively for artichokes, carrots and beets

Compute:order that total to above 100$ get 5% discount before shipping charges.
        shipping cose is based on the total weight of all three items
        shipping is  3.50$ for 5 pounds or below, 10$ for  20 pounds or below, 
        
        [example: 10 pound weight: shipping is 10$. 4 pounds weight: 3.5$. These 
        are not rates,  it is a flat rate for each of these two tiers.]
        9.5$ plus 10c per pound,  for weights above 20 pounds. (so we have : 
        two flat rates and one variable rate) (if weight was 21 pounds, 11.6$ 
        would be the shipping cost.  10 c per pound applies to total weight,
        not just the excess weight above 20)

    Display: Display cost, shipping charge, total cost. (for the order, not 
    for each produce) Cost means price after applying any discount; Total 
    cost means price plus shipping cost.
"""
#constant
ARTICHOKES_PRICE = 2.67 # price per pound
CARROTS_PRICE = 1.49    # price per pound
BEETS_PRICE = .67       # price per pound  
DISCOUNT = .05          # 5% discount

#initialization
shippingCosts = 0.0

#input
artichokeWeight = float(input("Enter the weight of arichokes: "))
carrotsWeight = float(input("Enter the weight of carrots: "))
beetsWeight = float(input("Enter the weight of beets: "))
totalWeight = (artichokeWeight + carrotsWeight + beetsWeight)

#compute each price
artichokePrice = (artichokeWeight * ARTICHOKES_PRICE)
carrotsPrice = (carrotsWeight * CARROTS_PRICE)
beetsPrice = (beetsWeight * BEETS_PRICE)

#compute cost
costBeforeShipping = (artichokePrice + carrotsPrice + beetsPrice)

#compute cost
if (costBeforeShipping > 100.0) :
    costBeforeShipping = costBeforeShipping - (costBeforeShipping * DISCOUNT)

#compute shipping cost
if (totalWeight <= 5):
    shippingCosts = 3.50
elif (totalWeight > 5 and totalWeight <= 20):
    shippingCosts = 10.0
else:
    shippingCosts = 9.50 + (totalWeight * 0.10)

#compute final cost
finalPrice = costBeforeShipping + shippingCosts

#output
print(f'Cost (With discount): $ {costBeforeShipping:.2f}')
print(f'Shipping charge: $ {shippingCosts:.2f}')
print(f'Cost + Shipping: $ {finalPrice:.2f}\n')

