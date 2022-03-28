import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;


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
  
    private final HashMap<String, Integer> OPERATORS = new HashMap<>();
    {
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }

    private final HashMap<String, Integer> SEPARATORS = new HashMap<>();
    {
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }

    private void termTokenizer() {
      this.tokens = new ArrayList<>();

      int start = 0;  
      StringBuilder multiCharTerm = new StringBuilder();    
      for (int i = 0; i < this.expression.length(); i++) {
          Character c = this.expression.charAt(i);
          if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {

            if (multiCharTerm.length() > 0) {
                  tokens.add(this.expression.substring(start, i));
              }

              if (c != ' ') {
                  tokens.add(c.toString());
              }

              start = i + 1;
              multiCharTerm = new StringBuilder();
          } else {

            multiCharTerm.append(c);
          }

      }
      if (multiCharTerm.length() > 0) {
          tokens.add(this.expression.substring(start));
      }
  }

  private void rpnToResult()
    {
        Stack calculation = new Stack();

        double one = 0;
        double two = 0;

        for(int i = 0; i < reverse_polish.size(); i++){

          if(OPERATORS.get(reverse_polish.get(i)) == 1){
            calculation.push(OPERATORS.get(reverse_polish.get(i)))
          }

          else{
            one = (Double) calculation.peek();
            calculation.pop();
            two = (Double) calculation.pop();

            switch(reverse_polish.get(i)) { 
              case "+":
                calculation.push((one + two));
                break;
              case "-":
                calculation.push((one - two));
                break;
              case "*":
                calculation.push((one * two));
                break;
              case "/":
                calculation.push((two / one));
                break;
              case "%":
                calculation.push((two % one));
                break;
              case "^":
                for(int j = 0; j < (int) two; j++ ){
                  one *= one;
                }
                calculation.push(one);
                break;
            }

          }
        }

    //     // for loop to process RPN
    //     {
    //         // If the token is a number
    //         {
    //             // Push number to stack
    //         }
    //         // else
    //         {
    //             // Pop the two top entries

    //             // Based off of Token operator calculate result

    //             // Push result back onto the stack
    //         }
    //     }
    //     // Pop final result and set as final result for expression
    // }
  
}