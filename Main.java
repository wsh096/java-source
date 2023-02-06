import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
  public static void main(String[] args) {
    //1.자바에서 집합 사용.->set(=의미 자체가 집합).
    System.out.println("==Set==");
    Set set1 = new HashSet();
    set1.add(1);
    set1.add(1);
    set1.add(1);
    //중복된 원소를 넣어도 자동으로 거름. 순서 보장하지 않음.
    System.out.println("set1 = "+ set1);
    set1.add(2);
    set1.add(3);
    System.out.println("set1 = "+ set1);
    
    set1.remove(3);//remove를 활용해 자신이 원하는 '값'의 삭제가 가능.
    System.out.println("set1 = "+ set1);
    
    System.out.println("set1 size = "+ set1.size());
    
    System.out.println("set1 contains(boolean) = "+ set1.contains(2));
    System.out.println();
    System.out.println("==Set Compute==");
    System.out.println();
    //2.집합의 연산.
    //1.교집합.retainAll();<- oh...retain's'All아님.
    System.out.println("==교집합의 연산 retainAll()==");
    Set<Integer> set2 = new HashSet(Arrays.asList(1,2,3,4,5));
    Set<Integer> set3 = new HashSet(Arrays.asList(2,4,6,8,10));
    set2.retainAll(set3);
    System.out.println("두 집합의 교집합 = "+ set2);
    System.out.println("retainAll(피대상)은 유지 = "+ set3);
    
    System.out.println();
    System.out.println("==합집합의 연산 addAll()==");
    set2 = new HashSet(Arrays.asList(1,2,3,4,5));
    set2.addAll(set3);
    System.out.println("두 집합의 합집합 addAll() " + set2);

    System.out.println();
    System.out.println("==차집합의 연산 removeAll()==");
    set2.removeAll(set3);
    System.out.println("두 집합의 차집합 removeAll() " + set2);
  }
}