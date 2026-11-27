Assignment on java collections and oop concepts(use streams if you want)



1. construct arraylist of orders where each order contains order id, customer id, category and amount spent. Now develop a java application:
* to find out orders with amount<=0
* return top 3 highest spending customer ids



2\. create a tree set to store collection of employee records with attributes like id, name, salary now create diff tree sets to store collection of employee objects based on id ascending order, name asc order, salary asc order and salary desc order



3\. Create tree map to store records of employees with id as key and employee object as value, the emp details are id, name, salary. Now

* find total no.of employees at any stage
* details of first employee
* details of last employee



4\. Construct arraylist of strings representing colors, now find frequency of each color in arraylist and finally

* find color with highest frequency
* find color with lower frequency
* find colors with occurrence of k times



5\. In a hospital emergency rule patients arrive sequentially and the are treated based on priority rather than fcfs now construct a collection of patients with patient id name severity level(1-10 10-high risk) and arrival time(int 1-23 1-early arrival) now display the patients based on severity level , if two or more patients have same severity then sort by arrival time



Case study on oop collections in java



Students marks lookup system

1. You are tasked with building a student marks lookup system , system must store student ids  as unique keys and corresponding values as objects , each object should contain name, marks, grade. the system should allow fast O(1) insertions, updates, deletes, lookups

requirements

* store records : the system can store no.of records dynamically if a student id already exists update their marks with latest value
* process queries
* get<name> print details of specific student if exists else raise exception StudentNotFound
* get<id> print marks of student with given id if student not exists else raise exception StudentNotFound
* update<id> given the student with id update his/her marks if student not exists insert new record
* remove<id> remove the student from the collection if student not exists raise StudentNotFound
* exists<id> print true if the student exists in the collection else false





