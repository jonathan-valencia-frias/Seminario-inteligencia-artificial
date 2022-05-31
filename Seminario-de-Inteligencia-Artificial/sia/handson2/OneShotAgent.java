package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgent extends Agent {
    
  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      double[] sales = new double[]{ 651.0,762.0,856.0,1063.0,1190.0,1298.0,1421.0,1440.0,1518.0};
      double[] add = new double[]{ 23.0,26.0,30.0,34.0,43.0,48.0,52.0,57.0,58.0};
      double n=9.0;
      double sumS=sum(sales);
      double sumA=sum(add);
      double promS=prom(sales);
      double promA=prom(add);
      double sumXY=XY(add, sales);
      double sumA2=cuadradosuma(add);
      double B1=(n*sumXY-sumS*sumA)/(n*sumA2-(sumA*sumA));
      double B0=promS-B1*promA;
      System.out.println(B1);
      System.out.println(B0);
    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
    public static double sum(double[] arr) 
    {
        double sum = 0;
         
        for (int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static double prom(double[] arr) 
    {
        double sum = 0;
         
        for (int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        sum=sum/arr.length;
        return sum;
    }
    public static double XY(double[] X,double[] Y) 
    {
        double sum = 0;
         
        for (int i = 0; i < X.length; i++){
            sum+=X[i]*Y[i];
        }
        return sum;
    }
    public static double cuadradosuma(double[] arr) 
    {
        double sum = 0;
         
        for (int i = 0; i < arr.length; i++){
            sum+=arr[i]*arr[i];
        }
        return sum;
    }
  }    // END of inner class ...Behaviour
}
