Level 1
Note: Change the class name "XYZ" to any relevant name
In level 1, all numbers are non-negative integers. Implement the following methods:
XYZ(String s): Constructor for XYZ class; takes a string s as parameter, that stores a number in decimal, and creates the XYZ object representing that number. The string can have arbitrary length. In Level 1, the string contains only the numerals 0-9, with no leading zeroes.
XYZ(Long num): Constructor for XYZ class.
String toString(): convert the XYZ class object into its equivalent string (in decimal). There should be no leading zeroes in the string.
XYZ add(XYZ a, XYZ b): sum of two numbers stored as XYZ.
XYZ subtract(XYZ a, XYZ b): given two XYZ a and b as parameters, representing the numbers n1 and n2 repectively, returns the XYZ corresponding to n1-n2. If you have implemented negative numbers, return the actual answer. If not, then if the result is negative, it returns the XYZ for number 0.
XYZ product(XYZ a, XYZ b): product of two numbers.
XYZ power(XYZ a, long n): given an XYZ a, representing the number x and n, returns the BigNum corresponding to x^n (x to the power n). Assume that n is a nonnegative number. Use divide-and-conquer to implement power using O(log n) calls to product and add.
printList(): Print the base + ":" + elements of the list, separated by spaces.
Write your own driver program to illustrate your implementation. Use your own input/output formats (for Level 1).

Level 2 (EC: 0.7)

Implement Level 1 and the following additional capabilities. Implement negative numbers, so that subtract returns the correct answer instead of 0 when the result is negative. Additional functions to be implemented for Level 2:
XYZ power(XYZ a, XYZ n): return a^n, where a and n are both XYZ. Here a may be negative, but assume that n is non-negative.