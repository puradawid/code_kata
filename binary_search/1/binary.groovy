class BinarySearch {
  int search(int[] array, int lookedFor) {
    return find(array, 0, array.length - 1, lookedFor);
  }

  int find(int[] array, int leftBoundary, int rightBoundary, int lookedFor) {
    if (lookedFor < array[leftBoundary] || lookedFor > array[rightBoundary]) {
      return -1
    } else if (array[rightBoundary] == lookedFor) {
      return rightBoundary
    } else if (array[leftBoundary] == lookedFor) {
      return leftBoundary
    } else {
      int middle = ((rightBoundary - leftBoundary) / 2) + leftBoundary
      if (lookedFor > array[middle]) {
        return find(array, middle, rightBoundary, lookedFor);
      } else {
        return find(array, leftBoundary, middle, lookedFor);
      }
    }
  }
}

class Test {

  private void check(int[] array, searched, expected) {
    int result = new BinarySearch().search(array, searched);
    assert result == expected;
  }

  private void checkLeftGood() {
    check([1, 2, 3, 4, 5] as int[], 1, 0);
  }

  private void checkRightGood() {
    check([1, 2, 3, 4, 5] as int[], 5, 4);
  }

  private void checkMiddle() {
    check([1, 2, 3, 4, 5] as int[], 4, 3);
  }
  
  private void checkHuge() {
    int[] array = (-1000..1000) as int[]
    check(array, 1, 1001);
  }

  private void checkNegative() {
    int[] array = [-1, 0, 1] as int[]
    check(array, 0, 1);
  }

  void run() {
    checkLeftGood();
    checkRightGood();
    checkMiddle();
    checkNegative();
    checkHuge();
    println("Test passed, all correct");
  }
}

new Test().run();
