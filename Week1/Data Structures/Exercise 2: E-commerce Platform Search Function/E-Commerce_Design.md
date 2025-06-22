# E-Commerce Platform: Product Search Optimization


## 1. Understanding Asymptotic Notation

- **Big O Notation** describes the performance or complexity of an algorithm in terms of time or space used as input size grows.
  - **O(n)** – linear time: the time increases with input size.
  - **O(log n)** – logarithmic time: efficient for large inputs.

- **Best Case**: Ideal condition (e.g., first element match).
- **Average Case**: Expected performance for typical input.
- **Worst Case**: Slowest scenario (e.g., last element or not found).

---

## 2. Setup

- Define a `Product` class with the following attributes:
  - `productId`: Unique identifier (String or int)
  - `productName`: Name of the product
  - `category`: Category it belongs to

---

## 3. Implementation

- **Linear Search**
  - Iterate through the list of products one by one.
  - No sorting required.
  - Useful for small lists or unsorted data.

- **Binary Search**
  - Requires the product list to be sorted by `productId`.
  - Repeatedly divide the list to find the target.
  - Much faster for large sorted lists.

---

## 4. Analysis

| Algorithm      | Time Complexity | When to Use                             |
|----------------|------------------|------------------------------------------|
| Linear Search  | O(n)             | For small datasets or unsorted data      |
| Binary Search  | O(log n)         | For large, sorted datasets               |

- **Linear Search** is simpler but slower as the list grows.
- **Binary Search** is efficient, but needs preprocessing (sorting).

---

## Conclusion

Choose the algorithm based on your dataset:
- Use **Linear Search** for small or dynamic lists.
- Use **Binary Search** when you need high-speed lookups on large, sorted datasets.
