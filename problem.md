## Problem Statement: Grade Calculator##

**Grades need to be assigned to students based on their marks. The student details need to be accepted from the User.
 The details would include roll no, marks in the given order. The datatype for roll no and marks is integer. 
 These details need to be stored in a HashMap with roll no as key and marks as value.**

Grade Assignment Rules:

    1. If marks is greater than or equal to 80, grade is "A"
    2. If marks is less then 80 and greater than or equal to 60, grade is "B".
    3. If marks is less then 60 and greater than or equal to 45, grade is "C" else "D".
    4. If marks is greater than 100, student record should be ignored

**This exercise contains a class GradeCalculator with the following static method for finding and storing the grade of students:**

    public static Map<Integer, String> calculateGrade(Map<Integer, Integer> scores)
        
    - Method should take Map (HashMap object) as input and return a Map.
    - The map returned should have roll no as key and grade as value. **The entries in the map should be in 
      ascending order of roll number**
    
    *Note: If the input map is null or empty, method should return null* 

**Do the following in the main method **

1. Accept inputs from the console
2. The first input is integer(n) denoting the number of students, followed by roll number and marks of 'n' students
3. The student details should be stored in a HashMap and passed to the method
4. The output should be displayed as per the format given in example section 


## Example ##
    Sample Input:
    2
    1010 80
    100 40
        
    Expected Output:
    100 D
    1010 A

--------------------------------------------------------
    Sample Input:
    3
    1010 80
    231 90
    101 101
        
    Expected Output:
    231 A
    1010 A

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding