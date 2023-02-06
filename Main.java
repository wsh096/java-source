import java.util.ArrayList;

class MySet{
  ArrayList<Integer> list;

  MySet(){
    this.list = new ArrayList<>();
  }
  MySet(int[] arr){
    this.list = new ArrayList<>();
    for(int item : arr){
      this.list.add(item);
    }
  }

  //Set의 add구현(point : 중복을 없애는 것.)
  public void add(int x){
    for(int item : this.list){
      if(item == x){//겹치는 경우.//다 확인하는 방식.
        return;
      }
    }
    this.list.add(x);
  }
//교집합 retainAll()의 구현.
  public MySet retainAll(MySet set){
    MySet result = new MySet();//결과값 바꿔 줄 녀석.

    for(int item1 : this.list){
      for(int item2 : set.list){
        if(item1 == item2){
          result.add(item1);
        }
      }
    }
    return result;//이 부분 조금 이상한 거 같은데 확인 필요.
  }
//합집합 addAll()의 구현.
  public MySet addAll(MySet set){
    MySet result = new MySet();

    for(int item1 : this.list){
      result.add(item1);
    }
    for(int item2 : set.list){
      result.add(item2);
    }
    return result;
  }
//차집합 removeAll()의 구현.
  public MySet removeAll(MySet set){
    MySet result = new MySet();
    for(int item1 : this.list){
      boolean containFlag = true;//<- 요 부분이 신박.

      for(int item2 : set.list){
        if(item1 == item2){
          containFlag = false;
          break;
        }
      }
      if(containFlag){
        result.add(item1);
      }
    }
    return result;
  }
  
}

class Main {
  public static void main(String[] args) {
    //      Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
  }
