Streams in Java Introduction:

&#x09;The concept of streams is introduced from java 8 onwards and they provide a declarative and functional style approach to process the data stored in collections, arrays and io channels without modifying the original data, that means the data source or input for streams is data stored in collections, arrays and io channel. A stream is not a data structure and does not store data instead it takes data from a data structure like collection, list, set, array sequentially and acts as a pipeline for the data and performs computational operations. It performs two different types of computational operations in the pipeline :

1. Intermediate operations
2. Terminal operations

&#x09;the results generated at terminal operations will be transferred as output.

The following intermediate operations a stream pipeline can perform

* filter
* map
* flatMap
* sorted
* distinct
* peek



The following are terminal operations

* collect
* forEach
* reduce
* count
* findFirst

&#x09;			     stream

&#x09;       --------------------------------------------------

Data Source -> | Intermediate operations -> Terminal operations | -> Output

&#x09;       --------------------------------------------------





&#x09;				simple practical example



Create ArrayList of n Strings probably representing names of different programming languages, different databases, different os, different ai tools, that are used for s/w development. now perform the following tasks

* find all the names of the programming languages, databases, os, ai tools that start with a specific letter(user input)
* find all the content that starts with j and ends with a
* find all the content that starts with specific letter but in upper case
* find all the content that starts with specific letter but distinct output
* find all the content that starts with specific letter but in upper case and only distinct content
* find all the content that starts with specific letter but in sorted order
* find all the distinct content that starts with specific letter in upper case and sorted order
* find the count of distinct elements starting with a specific letter
* find first element of the stream which filters data starting with s
* check whether any element starts with s
* find if all the names start with s





&#x09;			CASE STUDY



1.Create a list of employees with fields like employee name, age, department . now

* write a code snippet to group employees by using department name with the help of streams
* Write a code snippet to group employees based on age
* find eldest or oldest employee
* find youngest employee



2\. You are given two lists of integers now

* find sum, avg, max and min of each list separately
* find k most frequent elements from list1, list2 separately
* find second most frequent element separately
* merge two lists into single list using flatMap
* find common elements from two lists using streams



3\. Create a list of strings and map each string and string value(length) using stream



4\. Find all the prime numbers from the given list using stream



5\. Find all non primes from a list using stream



6\. If you are given a string find repeating characters in a string using stream



7\. Find the first repeating character in a string using stream



8\. Find longest word from given list of strings



9\. Find shortest word from given list of strings





&#x09;	Practical Problems on streams



1. construct a list of employees where each employee represents following attributes (id name job date salary dept) now find the top earning employees in each department dept wise.
2. You have a list of company objects and each company contains list of employee objects the attributes of company are (id name location type) and attributes of employee are (id name salary). Now find a flat list of all employee names across all the companies.
3. Consider collection of patient objects in healthcare data with the following attributes (patient id, name, department, doctor name diagnosis treatment given, patient type, heart rate, BP, sugar value, severity) now
* find all active icu patients
* find all active icu patients with elevated heart rate(>100) 
* sort the patients by severity



&#x09;	Questions



1. Create a list of strings and filter out strings with length at least 4 convert them into uppercase remove duplicates sort naturally and finally collect the output strings produce the output after every stage , Given a string find first non repeating character in the string
2. Given array of n integers the task is return values greater than 5 square them remove duplicates and sort in ascending order
given list of integer find only the elements which occur more than once.
3. Construct a list of employees
* find names of employees in engineering department who have more than 80000 salary sort alphabetically based on name
* extracted the duplicated list of all employee skills that start with java
* group all employees by department but only include employees earning more than 1 lakh salary
* filter stream of employees so that only first employee per department

