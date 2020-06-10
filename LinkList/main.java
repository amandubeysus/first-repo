class cat{
  void leg(){
    System.out.println("cat can bark");

}
}

class dog extends cat {
   void run(){
     System.out.println("dog can run");}

}
class cow extends dog{
  void disp(){
System.out.println("rat is small");
}


}

class Main{
   
public static void main(String[] args)
  {
    cow dg = new cow();
     dg.leg();
    dg.run();
     dg.disp();
}



}
