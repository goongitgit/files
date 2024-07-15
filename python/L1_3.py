L1_3.py
This program collects six inputs from the user. 
all of them be information about a student.
The first input is the student's name, homework scores, 
each score being out of 50 The last two are test scores, 
each score being out of 30, Scores may have fractional part.

input are: 
student_name string type
hw_score1, hw_score2, how_score3 float type
test_score1, test_score2


Scaled Total Score is calculated out of 100, by scaling the homework 
component to 60 points, and the test component to 40 points.
HW is worth 60% points, and test worths 40% of the total.
All homework scores are treated equally; so are all the test scores.

Displayed output should use one line for each seperate item of 
information. 
Displayed output as follows:
Homework 1:    /50
Homework 2:    /50
Homework 3:    /50
Test 1:    /30
Test 2:   /30

Scaled Total Score:      /100
"""



# initialization
student_name = ""
homework_score = 0
tests   = 0
hw_score1 = 0
hw_score2 = 0
hw_score3 = 0
test_score1 = 0
test_score2 = 0
scaled_score = 0

#inputs
student_name = input("Please enter student name\n")

hw_score1 = int(input("Please enter score for homework1\n"))
hw_score2 = int(input("Please enter score for homework2\n"))
hw_score3 = int(input("Please enter score for homework3\n"))

test_score1 = int(input("Please enter test score for score1\n"))
test_score2 = int(input("Please enter test score for score2\n"))

#computations
homework_scores = hw_score1 + hw_score2 + hw_score3
homework_scores /= 150
homework_scores *= 60 #.5 * 60

test_scores = test_score1 + test_score2
test_scores /= 60
test_scores *= 40

# compute something
scaled_score = test_scores+homework_scores

#output
print("\nName: ",student_name)
print("Homework 1:",hw_score1,"/50")
print("Homework 2:",hw_score2,"/50")
print("Homework 3:",hw_score3,"/50")
print("Test 1:",test_score1,"/30")
print("Test 2:",test_score1,"/30")
print()
print(f'Scaled Total Score: {scaled_score:.1f}/100')
print()
