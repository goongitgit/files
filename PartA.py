
""" PartA
    Compute tax rate with exemption for single or married person
"""
#global
number_of_jobs =0
income = 0
number_of_kids = 0
isMarried = 'n'
isStudent = 'n'

def count_regular_exemptions():
    #calculate number of reqular exemptions
    exemptions = 1


    #if not job then add one more exemptions
    #if one job then if married or single student, one more exemption
    #if more than one job and if income less than 1500 then one more exception
    return exemptions

def count_child_exemptions():
    child_exemptions = 0
    #1. if income < 70000 then number of children times total exemptions
    #in the above exemptions

    #2. if income > 70000, you get one more exception with every 2 kids
    # 0 exemption for 1 child
    # 1 exemption for 2 child
    # 1 exemption for 3 child
    # 2 exemption for 4 child
    # 2 exemption for 5 child
    # 3 exemption for 5 child
    # 3 exemption for 6 child

    return child_exemptions

#calculate_taxable_income
def compute_taxable_income():
    total_income  = 0
    each_child_excemption = 1000
    each_regular_exemption = 2000
    exemption_amount = each_child_exemption + each_regular_exemption
    #each computed using counts and unit examptions

    taxable_income = income - excemption_amount
    return total_income

def compute_tax_rate():
    #tax_rate based on taxable income
    tax_rate = 0

    #if rate is .1, single and x <= 38000,married and <= 78000 
    #if rate is .15, single > 38000, married > 78000

    #tax is determined using taxable income and tax rate
    return tax_rate

def reset():
    number_of_jobs =0
    income = 0
    number_of_kids = 0
    isMarried = 'n'
    isStudent = 'n'
    return (number_of_jobs, income, number_of_kids, isMarried, isStudent)

def submit():
    #global a, b, c = 0
    #input number_of_jobs, income, number_of_children
    #input isMarried, isStudent

    number_of_jobs = int(input('number of jobs'))
    income = int(input('income'))
    number_of_kids = int(input('number of kids'))
    isMarried = str(input('is Married? '))
    isStudent = str(input('is Student? '))

    print(f'{number_of_jobs}, {income}, {number_of_kids}, {isMarried:s}, {isStudent:s}')




def summary():
    
    print('Taxpayer count (the ${tax_amount:.2f} tax input is counted), average tax for students')
    print('4    ${how_much_taxes:d}')


#main


quit = False
while quit == False:
    print('1. Submit 2.Summary 3.Reset 4.Exit')
    choice = int(input('Enter Choice: '))
    if choice == 1:
        submit()
    elif choice == 2:
        summary()
    elif choice == 3:
        reset()
    elif choice == 4:
        quit = True
else:
    print('Invalid Choice')

print ("Bye")