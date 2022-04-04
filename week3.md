# Week 3

[Review Ticket](https://github.com/ArnavPalkhiwala/APCSA-Tri3-Individual/issues/3)

[Link to running Repl](https://replit.com/@ArnavPalkhiwala/APCSA-Tri3-Individual-6#README.md)



# Sorting Implementations Overviews and Big O Analysis

Insertion:
* For the insertion, I used a for loop in conjunction with a while loop
* <img width="331" alt="Screen Shot 2022-04-04 at 8 23 17 AM" src="https://user-images.githubusercontent.com/25650329/161577337-e0284c15-62ed-4d9e-90fc-401f9b8b63b8.png">

*  It is essentially like a for loop with the while loop condition of a temp variable that is decreasing in value each time 
*  Also, there is a comparison value that is increasing and a swaps value also that keeps track of this data
*  Time is also made with the duration feature
*  Big O: Useful for small data sets in O(n^2) -> not a fast sorting algorithm because it uses nested for loops

Merge:
*  This is definitely the haredest sort method because of the implementation of recursion and its use in the program 

*  This had a second method for the other part of merging which was hard to create<img width="500" alt="Screen Shot 2022-04-04 at 8 20 09 AM" src="https://user-images.githubusercontent.com/25650329/161576653-1683915b-8587-4b44-98bd-535b9e78102e.png">

*  Also, there is a comparison value that is increasing and a swaps value also that keeps track of this data
*  Time is also made with the duration feature
*  Big O: MergeSort does log n merge steps (each step merge doubles list in size) -> does n work per step because it goes through and sees each item -> runs in O(n log n)

Bubble:
*  For this bubble sort, I used nested for loops and if the previous value was greater than the first, I switched them and that continued for the entirety
*  I used a temp variable to store values for when the swap occurs and these values were saved 
*  
*  <img width="430" alt="Screen Shot 2022-04-04 at 8 45 46 AM" src="https://user-images.githubusercontent.com/25650329/161581771-20fb281d-5926-4d82-a45c-d2a1d9699d96.png">

*  Also, there is a comparison value that is increasing and a swaps value also that keeps track of this data
*  Time is also made with the duration feature
*  Big O: Bubble Sort is not very efficient becuase it uses nested loops and is useful for small data sets -> runs in O(n^2)

Selection:
* Here I also used nested for loops and then am iterating through the data set
* I am finding both the minimum index and minimum value and saving this index and iterating from there
* Then the values are switched based on their magnitudes
* <img width="496" alt="Screen Shot 2022-04-04 at 8 49 12 AM" src="https://user-images.githubusercontent.com/25650329/161582493-3c21481d-18e2-4db8-b579-e855d4f82281.png">

*  Also, there is a comparison value that is increasing and a swaps value also that keeps track of this data
*  Time is also made with the duration feature
*  Big O: Selection Sort is not that fast because it has nested for loops and is useful for small data sets -> in O(n^2)

# Analysis:
*  From my research and Big O analysis, it is clear that although it is the most difficult, merge sort is the best algorithm 
*  It has the most efficient amount of comparisons and swaps
*  Does not uses nested for loops/while loops
*  It has the lowest time by far 
*  <img width="1190" alt="Screen Shot 2022-04-04 at 8 47 05 AM" src="https://user-images.githubusercontent.com/25650329/161582045-63b404ec-354d-41a3-a8dd-703da776a21b.png">


