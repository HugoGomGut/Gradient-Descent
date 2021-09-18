package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.function.Function;
import java.text.DecimalFormat;

public class GradientDescendientAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      DecimalFormat df4 = new DecimalFormat("#.####");
      int n_iter = 30;
      double step_size = 0.1;
      double solution = 1;
      double gradient;
      double solution_eval;
      for(int i=0;i<n_iter;i+=1) {
        gradient = solution * 2;
        solution = solution - step_size * gradient;
        solution_eval = solution * solution;
        System.out.println(i + " - " + df4.format(solution) + " - " + df4.format(solution_eval));
      }
    } 
    
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  }    // END of inner class ...Behaviour
}
