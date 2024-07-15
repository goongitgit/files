
""" PartB-P3
    Scores and grade counts, with grade basis, or not
""" 
#total_score_count
score_count = 0
total_score = 0
individual_scores = []

def update_grade_counts():
    global score_count
    score_count += 1


def compute_average():
    global total_score, score_count
    return (total_score / score_count)


def submit():
    global score_count, total_score, individual_scores
    #input score
    score = int(input('Enter Scores '))
    while (validate(score) != True):
      print()
      print("Please enter a valid score (0 - 100)")
      score = int(input('Enter Scores '))

    individual_scores.append(score)


    #grade basis?
    print()
    grade_basis = str(input('Grade Basis y/n '))
    
    if grade_basis == 'y':
        print(f'{score} graded.')
        update_grade_counts()
        total_score += score
    else:
      print(f'{score} pass/fail.')


    
    

def summary():
  global total_score
  if (total_score > 0):
    print()
    print(f'summary : average (graded) {compute_average()} (also five counts)')
  else:
    print("There are no current scores:")



def reset():
    global total_score, score_count
    total_score = 0
    score_count = 0

#main

def validate(score):
  if (score >= 0 and score <= 100):
    return True
  else:
    return False


def display():
  global individual_scores
  
  if (len(individual_scores) > 0):
    print("Scores: ")
    for score in individual_scores:
      print(score)
    print()
  else:
    print("There are no current scores:")



quit = False
while quit == False:
    print('1. Submit 2.Summary 3.Reset 4.Display 5. Exit')
    choice = int(input('Enter Choice: '))
    if choice == 1:
        submit()
    elif choice == 2:
        summary()
    elif choice == 3:
        reset()
    elif (choice == 4):
      display()
    elif choice == 5:
        quit = True
else:
    print('Invalid Choice')

print("Bye")