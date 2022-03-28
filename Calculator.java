import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Calculator{

  String expression;

  ArrayList<String> reverse_polish;
  
  ArrayList<String> tokens;

  
  public Calculator(String expression) {
 
      this.expression = expression;
    
      this.termTokenizer();

      this.tokensToReversePolishNotation();

      this.rpnToResult();
    }
  
    private boolean isOperator(String token) {
         return OPERATORS.containsKey(token);
    }

    private boolean isSeperator(String token) {
         return SEPARATORS.containsKey(token);
    }

    private Boolean isPrecedent(String token1, String token2) {
        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }
    private void tokensToReversePolishNotation () {

      this.reverse_polish = new ArrayList<>();

      Stack tokenStack = new Stack();
      for (String token : tokens) {
        switch (token) {

          case "(":        
            tokenStack.push(token);
            break;
            
          case ")":
            while (tokenStack.peek() != null && !tokenStack.peek().equals("(")){
                reverse_polish.add( (String)tokenStack.pop() );
              }
              tokenStack.pop();
              break;
            
          case "+":
            
          case "-":
                
          case "*":
                
          case "/":
                
          case "%":
                   
          while (tokenStack.peek() != null && isOperator((String) tokenStack.peek())){
            
            if (isPrecedent(token, (String) tokenStack.peek() )) {
              reverse_polish.add((String)tokenStack.pop());
              continue;
            }
            
            break;
          }

          tokenStack.push(token);
          break;
                
          default:    
            this.reverse_polish.add(token);
            
            }
        }

      while (tokenStack.peek() != null) {
        reverse_polish.add((String)tokenStack.pop());
      }

    }
  
  
}