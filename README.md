## 🌟 Java Sorting Algorithms Implementation

### Overview
This repository contains Java implementations of various sorting algorithms, covering a wide range of techniques from basic to advanced. Each algorithm is implemented in a separate class within the `sorting` package.

### Algorithms Included
The following sorting algorithms are implemented:

- **Bubble Sort**: Iteratively compares adjacent elements and swaps them if they are in the wrong order.
```java
public void sort() {
  int[] list = getList(); // Retrieve the array to be sorted

  // Bubble sort algorithm
  for (int i = 0; i < list.length - 1; i++) {
      for (int j = 0; j < (list.length - i) - 1; j++) {
          // Swap adjacent elements if they are in the wrong order
          if (list[j] > list[j + 1]) {
              swap(j, j + 1); // Call to a method to perform the swap
          }
      }
  }
}
```
------
- **Selection Sort**: Finds the minimum element from the unsorted part and puts it at the beginning.
```java
public void sort() {
    int size = getSize(); // Get the size of the array
    int[] list = getList(); // Get the array to be sorted
    int least; // Variable to store the index of the smallest element

    // Selection sort algorithm
    for (int i = 0; i < size - 1; i++) {
        least = i; // Assume the current index has the smallest element

        // Find the smallest element in the remaining unsorted array
        for (int j = i + 1; j < size; j++) {
            if (list[j] < list[least]) {
                least = j; // Update the index of the smallest element
            }
        }

        // Swap the smallest element with the current element if necessary
        if (least != i) {
            swap(i, least); // Call to a method to perform the swap
        }
    }
}
```
------
- **Double Selection Sort**: Improved version of Selection Sort that simultaneously finds the minimum and maximum elements.
```java
public void sort() {
    int size = getSize(); // Get the size of the array
    int[] list = getList(); // Get the array to be sorted
    int least; // Index of the smallest element
    int most; // Index of the largest element

    // Double Selection Sort algorithm
    for (int i = 0; i < size - i; i++) {
        least = i; // Assume the current index has the smallest element
        most = size - 1 - i; // Assume the current index has the largest element

        // Find the smallest and largest elements in the unsorted portion of the array
        for (int j = i; j < size - i; j++) {
            if (list[j] < list[least]) {
                least = j; // Update the index of the smallest element
            }
            if (list[j] > list[most]) {
                most = j; // Update the index of the largest element
            }
        }

        // Swap the smallest element with the first unsorted element if necessary
        if (least != i) {
            swap(i, least); // Call to a method to perform the swap
        }

        // Swap the largest element with the last unsorted element if necessary
        if (most != size - 1 - i) {
            // Handle the case where the largest element was moved to the position of the smallest element
            if (most == i) {
                most = least;
            }
            swap(size - 1 - i, most); // Call to a method to perform the swap
        }
    }
}
```
------
- **Insertion Sort**: Builds the final sorted array one item at a time by inserting elements into the right position.
```java
public void sort() {
    int[] list = getList(); // Get the array to be sorted

    // Insertion Sort algorithm
    for (int i = 1; i < list.length; i++) {
        int target = i; // Start with the current index as the target
        // Compare the element at 'target' with the elements before it and swap if necessary
        for (int j = i - 1; j >= 0; j--) {
            if (list[target] < list[j]) {
                swap(target--, j); // Swap 'target' with 'j' and decrement 'target'
            } else {
                break; // Stop comparing further as the list is already sorted up to this point
            }
        }
    }
}

```
------
- **Merge Sort**: Divides the array into halves, sorts each half recursively, and then merges them.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from superclass
    super.setList(divide(list)); // Sort the array using merge sort and update it
}

// Divide the array into smaller parts recursively
private int[] divide(int[] list) {
    if (list.length > 1) {
        // Split the array into two halves and recursively sort each half
        return merge(divide(Arrays.copyOfRange(list, 0, list.length / 2)),
                     divide(Arrays.copyOfRange(list, list.length / 2, list.length)));
    } else {
        return list; // Base case: return the array if its length is 1 (sorted by default)
    }
}

// Merge two sorted arrays into one sorted array
private int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length]; // Array to store the merged result
    int j = 0; // Index for the right array
    int cnt = 0; // Index for the result array

    // Iterate through both left and right arrays and merge them in sorted order
    for (int i = 0; i < left.length; i++) {
        while (j < right.length && left[i] > right[j]) {
            result[cnt++] = right[j++]; // Place the smaller element into the result array
        }
        result[cnt++] = left[i]; // Place the current element of left array into result
    }

    // If there are remaining elements in the right array, add them to the result
    while (j < right.length) {
        result[cnt++] = right[j++];
    }

    return result; // Return the merged and sorted array
}

```
------
- **Quick Sort**: Chooses a pivot element and partitions the array around the pivot, recursively sorting each partition.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from superclass
    int size = this.getSize(); // Get the size of the array
    divide(list, 0, size - 1); // Perform quick sort on the entire array
}

// Recursively divide and sort the array using quick sort
public void divide(int[] list, int min, int max) {
    if (min < max) {
        int pivot = getPivot(list, min, max); // Get the pivot index

        // Recursively sort elements before and after the pivot
        divide(list, min, pivot);
        divide(list, pivot + 1, max);
    }
}

// Choose a pivot and partition the array around it
private int getPivot(int[] list, int min, int max) {
    int pivot = list[(min + max) / 2]; // Choose the middle element as the pivot

    while (true) {
        // Find element on the left that should be on the right of pivot
        while (list[min] < pivot)
            min++;

        // Find element on the right that should be on the left of pivot
        while (list[max] > pivot && min <= max)
            max--;

        // If pointers crossed, partitioning is done
        if (min >= max)
            return max; // Return pivot index

        // Swap elements to correct their positions
        swap(min, max);
        min++;
        max--;
    }
}

```
------
- **Heap Sort**: Converts the array into a heap and repeatedly removes the largest element to form the sorted array.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from superclass

    // Perform heap sort
    for (int i = list.length - 1; i >= 0; i--) {
        heapify(list, i); // Heapify the current heap
        if (list[0] > list[i]) {
            swap(0, i); // Swap root (largest element) with the last unsorted element
        }
    }
}

// Heapify the heap with given root index
public void heapify(int[] list, int i) {
    int index = (i / 2) - 1; // Start from the parent of the last element in the heap
    while (index >= 0) {
        int left = index * 2 + 1; // Left child index
        int right = index * 2 + 2; // Right child index

        // Compare parent with its children and swap if necessary
        if (left < i && (list[left] >= list[right] && list[index] < list[left])) {
            swap(index, left); // Swap parent with left child if left child is larger
        } else if (right < i && (list[right] > list[left] && list[index] < list[right])) {
            swap(index, right); // Swap parent with right child if right child is larger
        }
        index--; // Move to the next parent node
    }
}

```
------
- **Tree Sort**: Uses a binary search tree to sort elements in O(n log n) time.
```java
class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeSort extends Sort {

    private Node root;
    private int index = 0;

    @Override
    public void sort() {
        int[] list = super.getList(); // Get the array to be sorted from superclass
        int size = this.getSize();

        // Insert all elements into the binary search tree
        for (int i = 0; i < size; i++) {
            insertNode(list[i]);
        }

        // Populate the sorted array by traversing the tree in-order
        popNode(list, root);
    }

    // In-order traversal to populate the sorted array
    private void popNode(int[] list, Node node) {
        if (node != null) {
            popNode(list, node.left); // Traverse left subtree
            list[index++] = node.value; // Add node value to sorted array
            popNode(list, node.right); // Traverse right subtree
        }
    }

    // Insert a new node with given value into the binary search tree
    private void insertNode(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode; // If tree is empty, set new node as root
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode; // Insert new node to the left
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode; // Insert new node to the right
                        return;
                    }
                }
            }
        }
    }
}
```
------
- **Tim Sort**: Hybrid sorting algorithm derived from merge sort and insertion sort, designed to perform well on real-world data.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from superclass
    int length = this.getSize(); // Get the length of the array

    // Perform insertion sort on small subarrays of size RUN
    for (int i = 0; i < length; i += RUN) {
        insertionSort(list, i, Math.min((i + RUN - 1), (length - 1)));
    }

    // Merge subarrays of size RUN using merge sort
    for (int size = RUN; size < length; size = 2 * size) {
        for (int left = 0; left < length; left += 2 * size) {
            int middle = left + size - 1;
            int right = Math.min((left + 2 * size - 1), (length - 1));
            merge(list, left, middle, right);
        }
    }
}

// Insertion sort for small subarrays
public void insertionSort(int[] list, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        int target = i;
        for (int j = i - 1; j >= left; j--) {
            if (list[target] < list[j]) {
                swap(target--, j);
            } else {
                break;
            }
        }
    }
}

// Merge function for merging two sorted subarrays
public static void merge(int[] arr, int min, int middle, int max) {
    int[] result = new int[max - min + 1]; // Temporary array to store merged result
    int j = middle + 1; // Starting index for the second subarray
    int cnt = 0; // Index for the temporary array

    // Merge elements from both subarrays into the result array
    for (int i = min; i < middle + 1; i++) {
        while (j < max + 1 && arr[i] > arr[j]) {
            result[cnt++] = arr[j++];
        }
        result[cnt++] = arr[i];
    }

    // Copy remaining elements from the second subarray to the result array
    while (j < max + 1) {
        result[cnt++] = arr[j++];
    }

    // Copy merged elements from result array back to the original array
    for (int i = 0; i < result.length; i++) {
        arr[min++] = result[i];
    }
}
```
------
- **Intro Sort**: Hybrid sorting algorithm that starts with Quick Sort and switches to Heap Sort for large data sets or deep recursion levels.
```java
public void sort() {
    int[] list = super.getList(); // Retrieve the array to be sorted from the superclass
    int depth = (int) (Math.log(list.length) * 2); // Calculate the maximum depth for introsort

    // Start introsort with initial parameters
    intro(list, depth, 0, list.length - 1);
}

// Introsort method to recursively partition and sort the array
private void intro(int[] list, int depth, int start, int end) {
    // Base case: If the array length is less than or equal to 1, it's already sorted
    if (list.length <= 1) {
        return;
    } else if (depth == 0) { // If maximum depth is reached, switch to heapsort or insertionsort
        if (end - start > 16) { // Heapsort is used for large subarrays
            heapsort(list, start, end);
        } else { // Insertionsort is used for small subarrays
            insertionsort(list, start, end);
        }
    } else { // Perform quicksort partitioning
        if (start >= end) {
            return;
        }
        int pivot = partition(list, start, end); // Select pivot element and partition the array
        // Recursively introsort the left and right subarrays
        intro(list, depth - 1, start, pivot);
        intro(list, depth - 1, pivot + 1, end);
    }
}
```
------
- **Radix Sort**: Sorts numbers by processing individual digits, from the least significant digit to the most significant.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from the superclass
    int topRadix = getTopRadix(list); // Determine the maximum number of digits in the array

    Queue<Integer>[] buckets = new LinkedList[10]; // Create 10 buckets for each digit (0-9)
    for (int i = 0; i < 10; i++) {
        buckets[i] = new LinkedList<>(); // Initialize each bucket as a LinkedList
    }

    int radix = 0;
    while (topRadix > radix) { // Iterate over each digit from least significant to most significant
        int listIdx = 0;

        for (int i : list) {
            int num = (int) (i / Math.pow(10, radix) % 10); // Extract the current digit
            buckets[num].add(i); // Add the number to the corresponding bucket based on the current radix
        }

        for (int j = 0; j < 10; j++) {
            while (!buckets[j].isEmpty()) {
                list[listIdx++] = buckets[j].poll(); // Remove numbers from buckets and update the original array
            }
        }
        radix++;
    }
}

public static int getTopRadix(int[] list) {
    int top = 0;
    for (int i : list) {
        if (i > top)
            top = i; // Find the maximum number in the list
    }
    int radix = 0;
    while (top > 0) {
        top /= 10;
        radix++; // Calculate the number of digits in the maximum number
    }
    return radix;
}
```
------
- **Shell Sort**: Variation of Insertion Sort that allows the exchange of items that are far apart.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from the superclass
    int gap = list.length / 2; // Initialize the initial gap size for shell sort

    // Iterate while gap is greater than 0
    while (gap > 0) {
        // Perform insertion sort for each gap
        for (int left = 0; left < gap; left++) {
            // Insertion sort within each gap sequence
            for (int i = left + gap; i < list.length; i += gap) {
                int target = i; // Start with the current index as target
                // Compare the element at 'target' with elements before it and swap if necessary
                for (int j = i - gap; j >= left; j -= gap) {
                    if (list[target] < list[j]) {
                        swap(target--, j); // Swap 'target' with 'j' and decrement 'target'
                    } else {
                        break; // Stop comparing further as the list is already sorted up to this point
                    }
                }
            }
        }
        gap /= 2; // Reduce the gap size for the next iteration
    }
}
```
------
- **Sleep Sort**: Uses thread sleep times to sort elements by their magnitude.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from the superclass
    ArrayList<Thread> threads = new ArrayList<>(); // Create a list to hold threads
    ArrayList<Integer> result = new ArrayList<Integer>(); // Create a list to collect sorted results
    int index = 0; // Index for populating the result list

    // Iterate through each number in the list
    for (int num : list) {
        Thread thread = new Thread(() -> { // Create a new thread for each number
            try {
                Thread.sleep(num); // Simulate processing time based on the number value
                result.add(num); // Add the number to the result list after processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threads.add(thread); // Add the thread to the list of threads
        thread.start(); // Start the thread to execute its task asynchronously
    }

    // Wait for all threads to complete before proceeding
    for (Thread thread : threads) {
        try {
            thread.join(); // Wait for each thread to finish its execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Copy sorted results back to the original list
    for (int i = 0; i < result.size(); i++) {
        list[i] = result.get(i); // Copy each element from the result list to the original array
    }
}
```
------
- **Gravity Sort**: Simulates a physics-based approach where heavier elements sink to the bottom.
```java
public void sort() {
    int[] list = super.getList(); // Get the array to be sorted from the superclass

    // Step 1: Determine the maximum value in the list
    int max = list[0];
    for (int i = 1; i < list.length; i++) {
        if (list[i] > max) {
            max = list[i];
        }
    }

    // Step 2: Create beads matrix and initialize beads
    int[][] beads = new int[list.length][max];
    for (int i = 0; i < list.length; i++) {
        for (int j = 0; j < list[i]; j++) {
            beads[i][j] = 1; // Place beads (1) up to the height of each list element
        }
    }

    // Step 3: Perform gravity sort using beads
    for (int j = 0; j < max; j++) {
        int sum = 0;

        // Count beads in each column and clear them
        for (int i = 0; i < list.length; i++) {
            sum += beads[i][j]; // Calculate total beads in column j
            beads[i][j] = 0; // Clear beads in column j after counting
        }

        // Place beads back to form sorted list
        for (int i = list.length - 1; i >= list.length - sum; i--) {
            list[i] = j + 1; // Set list element to j+1 (the value corresponding to beads)
        }
    }
}
```

### Project Structure
The project is organized into two packages:
- **main**: Contains `Main` and `Sort` classes.
  - **Main.java**: Allows selection of sorting algorithms and generates random arrays without duplicates.
  - **Sort.java**: Parent class for other sorting algorithms.
- **sorting**: Contains individual classes for each sorting algorithm.

### Implementation Details
Each sorting algorithm class extends the `Sort` class, providing a structured approach to implementing and testing different sorting methods.

### Usage
To use the project:
1. Clone the repository.
2. Run `Main.java` to select the sorting algorithm and generate test arrays.
3. Explore each sorting algorithm's class for detailed implementation and usage examples!
