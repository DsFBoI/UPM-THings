/**
 * Prueba de ColDeContactos<br>
 * @since 13/02/2016  
 * @version 1.2.1     JGF  03/04/2018
 * @version 1.3     JGF  13/03/2020 
 * @author JMB y JGF
 */
public class ColDeContactosTest{
 
  static ColDeContactos ldc0;
  static ColDeContactos ldc1;
  static ColDeContactos ldc2;
  static ColDeContactos ldc3;
  static ColDeContactos ldc5;
  
  
  public static void resetear (){
    ContactoTest.resetear();

    ldc0 = new ColDeContactos(10);

    ldc1 = new ColDeContactos(10);
    ldc1.add(ContactoTest.c1);

    ldc2 = new ColDeContactos(10);
    ldc2.add(ContactoTest.c1);
    ldc2.add(ContactoTest.c2);

    ldc3 = new ColDeContactos(10);
    ldc3.add(ContactoTest.c1);
    ldc3.add(ContactoTest.c2);
    ldc3.add(ContactoTest.c3);
    
    ldc5 = new ColDeContactos(10);
    ldc5.add(ContactoTest.c1);
    ldc5.add(ContactoTest.c2);
    ldc5.add(ContactoTest.c3);
    ldc5.add(ContactoTest.c4);
    ldc5.add(ContactoTest.c5);  
  }
  static void mostrar (){
    System.out.println("ldc0 = \n" + ldc0);
    System.out.println("ldc1 = \n" + ldc1);
    System.out.println("ldc2 = \n" + ldc2);
    System.out.println("ldc3 = \n" + ldc3);
    System.out.println("ldc5 = \n" + ldc5);
  }
    static boolean testSize (){
    return  
      ldc0.size() == 0 &&
      ldc1.size() == 1 &&
      ldc2.size() == 2 &&
      ldc5.size() == 5 ;
  }
  static boolean testGet (){
    return
      ldc1.get(0).equals(ContactoTest.c1) &&
      ldc2.get(0).equals(ContactoTest.c1) &&
      ldc2.get(1).equals(ContactoTest.c2) &&
      ldc5.get(2).equals(ContactoTest.c3) ;
  }
  static boolean test1set (){
    resetear();
    ldc1.set(0, ContactoTest.c3);
    return ldc1.get(0).equals(ContactoTest.c3);
  }
  static boolean test2set (){
    resetear();
    ldc2.set(1, ContactoTest.c4);
    return ldc2.get(1).equals(ContactoTest.c4);
  }
  static boolean test3set (){
    resetear();
    ldc5.set(2, ContactoTest.c5);
    return ldc5.get(2).equals(ContactoTest.c5);
  }
  static boolean testSet (){
    return 
      test1set() &&  
      test2set() &&  
      test3set() ;
  }
  static boolean test1add(){
    resetear();
    ldc0.add(ContactoTest.c1);
    return ldc0.get(0).equals(ContactoTest.c1);
  }
  static boolean test2add(){
    resetear();
    ldc1.add(ContactoTest.c2);
    return 
      ldc1.get(0).equals(ContactoTest.c1) &&
      ldc1.get(1).equals(ContactoTest.c2);
  }
  static boolean test3add(){
    resetear();
    ldc2.add(ContactoTest.c3);
    return 
      ldc2.get(0).equals(ContactoTest.c1) &&
      ldc2.get(1).equals(ContactoTest.c2) &&
      ldc2.get(2).equals(ContactoTest.c3);
  }
  static boolean testAdd(){
    return 
      test1add() &&  
      test2add() &&  
      test3add();  
  }
  static boolean test1addPos(){
    resetear();
    ldc0.add(0, ContactoTest.c1);
    return ldc0.get(0).equals(ContactoTest.c1);
  }
  static boolean test2addPos(){
    resetear();
    ldc1.add(0, ContactoTest.c2);
    return 
      ldc1.get(0).equals(ContactoTest.c2) &&
      ldc1.get(1).equals(ContactoTest.c1);
  }
  static boolean test3addPos(){
    resetear();
    ldc2.add(1, ContactoTest.c3);
    return 
      ldc2.get(0).equals(ContactoTest.c1) &&
      ldc2.get(1).equals(ContactoTest.c3) &&
      ldc2.get(2).equals(ContactoTest.c2);
  }
  static boolean testAddPos(){
    return 
      test1addPos() && 
      test2addPos() &&  
      test3addPos();  
  }
  static boolean testIndexOf(){
    return
      ldc0.indexOf(ContactoTest.c3) == -1 && ldc1.indexOf(ContactoTest.c1) == 0 && ldc5.indexOf(ContactoTest.c5) == 4;
  }
  static boolean test1removeElementAt(){
    resetear();
    ldc5.removeElementAt(4);
    ldc5.removeElementAt(3);
    ldc5.removeElementAt(2);
    ldc5.removeElementAt(1);
    ldc5.removeElementAt(0);
    return ldc5.size()==0;
  }
  static boolean test2removeElementAt(){
    resetear();
    ldc5.removeElementAt(0);
    ldc5.removeElementAt(0);
    ldc5.removeElementAt(0);
    ldc5.removeElementAt(0);
    ldc5.removeElementAt(0);
    return ldc5.size()==0;
  }
  static boolean test3removeElementAt(){
    resetear();
    ldc2.removeElementAt(0);
    return 
      ldc1.size()==1 && 
      ldc2.get(0).equals(ContactoTest.c2);
  }
  static boolean testRemoveElementAt (){
    return 
      test1removeElementAt() && test2removeElementAt() && test3removeElementAt();  
  }
  static boolean test1remove(){
    resetear();
    ldc0.remove(ContactoTest.c2);
    return 
      ldc0.size()==0;
  }
  static boolean test2remove(){
    resetear();
    ldc1.remove(ContactoTest.c2);
    return 
      ldc1.size()==1 &&
      ldc1.get(0).equals(ContactoTest.c1);      
  }
  static boolean test3remove(){
    resetear();
    ldc2.remove(ContactoTest.c2);
    return 
      ldc2.size()==1 &&
      ldc2.get(0).equals(ContactoTest.c1);      
  }
  static boolean testRemove(){
    return 
      test1remove() &&  
      test2remove() &&  
      test3remove();  
  }
  public static void main (String[] args)
  {
    
    resetear();
    mostrar();
    System.out.println("testSize() = " + testSize ());
    System.out.println("testGet() = " + testGet());
    System.out.println("testSet() = " + testSet());
    System.out.println("testAdd() = " + testAdd());
    System.out.println("testAddPos() = " + testAddPos());    
    System.out.println("testIndexOf() = " + testIndexOf());    
    System.out.println("testRemoveElementAt() = " + testRemoveElementAt());
    System.out.println("testRemove() = " + testRemove());
  }
}