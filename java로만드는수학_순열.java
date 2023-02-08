import java.util.stream.IntStream;
import java.util.Arrays;

class Main {
  static int count1;
  static int count2;

  public static void main(String[] args) {
    // 1.팩토리얼
    System.out.println("==팩토리얼(n!)==");
    System.out.println(factorial(5));

    // 2.순열
    System.out.println("==순열nPr(n-r+1)!==");
    System.out.println(premutation(5, 3));

    // 3.중복순열
    System.out.println("==중복순열n파이r(n^r)==");
    System.out.println(samepermutation(5, 2));

    // 원순열. n!/n=(n-1)!
    System.out.println("==원순열(n-1)!==");
    System.out.println(circlepermutation(3));

    // 배열Swap메소드의 정의를 활용한 permutation출력
    System.out.println("==정렬된 배열의 값을 depth와 swap메소드를 활용해 순열로 출력==");
    int[] arr = { 1, 2, 3, 4 };
    System.out.println(count1);
    swapPermutation(arr, 0, arr.length, 3);
    System.out.println(count1);

    System.out.println("==정렬된 배열의 값을 boolean[]을 활용해 순열로 출력==");
    boolean[] visited = new boolean[arr.length];
    int[] out = new int[3];
    System.out.println(count2);
    booleanPermutation(arr, 0, visited, arr.length, 3,out);
    System.out.println(count2);
  }

  // 팩토리얼
  private static int factorial(int n) {
    // return IntStream.range(2,n+1).reduce(1, (x,y)->x*y);
    int result = 1;
    for (int i = 1; i <= n; i++)
      result *= i;
    return result;
  }

  // 순열
  private static int premutation(int n, int r) {

    // return IntStream.range(n-r+1,n+1).reduce(1, (x,y)->x*y);

    int result = 1;
    for (int i = n; i >= n - r + 1; i--)
      result *= i;
    return result;
  }

  // 중복순열
  private static int samepermutation(int n, int r) {

    // return (int)Math.pow(n,r);
    int result = 1;
    for (int i = 0; i < r; i++)
      result *= n;
    return result;
  }

  // 원순열
  private static int circlepermutation(int n) {
    // return IntStream.range(2,n).reduce(1, (x,y)->x*y);
    int result = 1;
    for (int i = 1; i < n; i++)
      result *= i;
    return result;
  }

  // 배열로 이루어진 순열을 Swap메소드를 활용한 출력
  private static void swapPermutation(int[] arr, int depth, int n, int r) {
    if (depth == r) {
      for (int i = 0; i < r; i++)
        System.out.print(arr[i]);
      count1++;
      System.out.println();
      return;
    }
    for (int i = depth; i < n; i++) {
      swap(arr, depth, i);
      swapPermutation(arr, depth + 1, n, r);
      swap(arr, depth, i);
    }
  }

  private static void swap(int[] arr, int depth, int idx) {
    int temp = arr[depth];
    arr[depth] = arr[idx];
    arr[idx] = temp;
  }

  private static void booleanPermutation(int[] arr, int depth, boolean[] visited, int n, int r, int[] out) {
    if (depth == r) {
       //out없이, for(int i = 0; i<n;i++)
      //{if(visited[i]==true)로 하면 순서가 안 지켜짐.
      System.out.print(Arrays.toString(out));
      count2++;
      System.out.println();
      return;
    }

    for (int i = 0; i < n; i++) {
      if (visited[i] != true) {
        visited[i] = true;
        out[depth] = arr[i];
        booleanPermutation(arr, depth + 1, visited, n, r,out);
        visited[i] = false;
      }
    }
  }
}
