# Software engineer application task

## ATTENTION
__Please don’t fork this repository.__
If you fork the repository, you’re responsible if someone brings you in connection with the application process. It’s your own risk.

## Problem

We want you to solve the following problem within max. 4 hours of work.

In the ```prices-quantity.csv``` are combinations of **prices to quantity** and the **frequency** of how often a **price quantity** combination occurs. 


| Price | Quantity | Frequency |
| :---: | :---: | :---: |
| 999 | 1 | 300 |
| 999 | 24 | 10 |
| 999 | 2 | 5 |


Your challenge is to build an application where it is possible to enter a price and a quantity. The application should check if the entered quantity is plausible which means for the example above, that if you enter ```999, 1``` the answer should be 

```The provided quantity fits the expectation with a safety of N percent```

If a price-quantity pair is provided that does not have the highest frequency, the application should adjust the given quantity to match the one with the highest occurence, if the relative frequency of the highest occurence is above 80%. The response should be:

```The provided quantity has been changed from X to Y with a safety of N percent```

If the relative frequency is below 80% the response should be:

```The provided quantity hasn't been modified. The relative frequency is too low by N percent```

If a price is entered that has no entry in the csv, the quantity should not be modified and the response should be:

```Cannot find a representation for price X. The quantity hasn't been modified.```

## Requirements

Please __clone__ and create your own copy of this repository. Submit the code in your favorite programming language with a documentation of how to test the application.
If possible, it would be nice if you choose Java, Javascript, Typescript, Python or PHP.

**Please don't invest more time in this task. If you're not able to solve this task in the given time please prepare some slides which contain:**

* The way you planned this task
* The problems you faced during coding
* Your conclusion if the task was fair and do-able within a four hour timeslot

