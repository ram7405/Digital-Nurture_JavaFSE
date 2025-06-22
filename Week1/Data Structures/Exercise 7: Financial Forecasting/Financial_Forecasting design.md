
## 1. Understanding Recursive Algorithms

**Recursion** is a problem-solving technique where a function calls itself to solve smaller instances of the same problem. It is particularly useful when a problem can be naturally divided into similar subproblems.

In financial forecasting, recursion can be used to calculate how an investment grows year by year by referencing the result of the previous year.

---

## 2. Problem Setup

We aim to predict the **future value (FV)** of an investment using:

* **Initial investment (Present Value)**
* **Annual growth rate (as a percentage)**
* **Number of years to forecast**

### Formula

$$
FV = PV \times (1 + r)^n
$$

Where:

* `FV` = future value
* `PV` = present value
* `r` = annual growth rate (as a decimal)
* `n` = number of years

Using recursion, this becomes:

* **Base case**: If `years == 0`, return the present value.
* **Recursive case**:

  $$
  FV(n) = FV(n - 1) \times (1 + r)
  $$

---

## 3. Implementation Approach

The recursive method should:

1. Accept inputs: present value, growth rate, and number of years.
2. Use the base case to return the original amount when years is zero.
3. Call itself with `years - 1`, applying the growth rate in each step.

This models compound growth over time.

---

## 4. Time Complexity and Optimization

* **Time Complexity**:
  The recursive method has a linear time complexity of **O(n)**, where `n` is the number of years.

* **Limitations**:
  Recursion may lead to **stack overflow** for very large `n`, due to deep recursive calls.

* **Optimization Techniques**:

  * **Memoization**: Store results of previous computations to avoid redundant calculations.
  * **Iterative approach**: Replace recursion with a loop for improved performance and scalability.
