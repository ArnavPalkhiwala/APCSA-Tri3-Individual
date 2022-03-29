import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;


public class Calculator{

  String expression;

  ArrayList<String> reverse_polish;
  
  ArrayList<String> tokens;

  private Double finalAnswer;

  
  public Calculator(String expression) {
      
    this.expression = expression;
    
    this.termTokenizer();         // parse expression into terms

    this.tokensToReversePolishNotation();         // place terms into reverse polish notation

    this.rpnToResult();         // calculate reverse polish notation
  }

  private final HashMap<String, Integer> OPERATORS = new HashMap<>();
    {
      // Map<"token", precedence>
      OPERATORS.put("*", 3);
      OPERATORS.put("/", 3);
      OPERATORS.put("%", 3);
      OPERATORS.put("+", 4);
      OPERATORS.put("-", 4);
      OPERATORS.put("^", 2);
      OPERATORS.put("sqrt", 2);
      OPERATORS.put("$", 2);
      OPERATORS.put("pyth", 2);


    }

    private final HashMap<String, Integer> NUMOPERANDS = new HashMap<>();
    {
      // Map<"token", precedence>
      NUMOPERANDS.put("*", 2);
      NUMOPERANDS.put("/", 2);
      NUMOPERANDS.put("%", 2);
      NUMOPERANDS.put("+", 2);
      NUMOPERANDS.put("-", 2);
      NUMOPERANDS.put("^", 2);
      NUMOPERANDS.put("sqrt", 1);
      NUMOPERANDS.put("pyth", 1);


    }
    
    // Helper definition for supported operators
    private final HashMap<String, Integer> SEPARATORS = new HashMap<>();
    {
      SEPARATORS.put(" ", 0);
      SEPARATORS.put("(", 0);
      SEPARATORS.put(")", 0);
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

      LinkedList<String> tokenList = new LinkedList<>();
      ArnavStack tokenStack = new ArnavStack(tokenList);
      for (String token : tokens) {
        switch (token) {

          case "(":        
            tokenStack.push(token);
            break;
            
          case ")":
            while (tokenStack.peek() != null && !tokenStack.peek().equals("(")){
              reverse_polish.add((String)tokenStack.peek());
              tokenStack.pop();
            }
              tokenStack.pop();
              break;
            
          case "+":
            
          case "-":
                
          case "*":
                
          case "/":
                
          case "%":

          case "^":
                
          case "sqrt":

          case "pyth":
                   
          while (tokenStack.size() > 0 && tokenStack.peek() != null && isOperator((String) tokenStack.peek())){
            
            if (isPrecedent(token, (String) tokenStack.peek() )) {
              reverse_polish.add((String)tokenStack.peek());
              tokenStack.pop();
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

      while (tokenStack.size() > 0 && tokenStack.peek() != null) {
        this.reverse_polish.add((String)tokenStack.peek());
        tokenStack.pop();
      }
    }

    private void termTokenizer() {
      // contains final list of tokens
      this.tokens = new ArrayList<>();

      int start = 0;  // term split starting index
      StringBuilder multiCharTerm = new StringBuilder();  //termholder   
      for (int i = 0; i < this.expression.length(); i++) {
          Character c = this.expression.charAt(i);
          if (isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
            if (multiCharTerm.length() > 0) {                 // Add operator or parenthesis term to list
                  tokens.add(this.expression.substring(start, i));
              }

              if (c != ' ') {
                  tokens.add(c.toString());
              }

              start = i + 1;
              multiCharTerm = new StringBuilder();
          } else {                 // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term

            multiCharTerm.append(c);
          }

      }
      if (multiCharTerm.length() > 0) { //last term
          tokens.add(this.expression.substring(start));
      }
  }

  private void rpnToResult()
    {
    LinkedList<Double> ccccc= new LinkedList<>();
        ArnavStack calculation = new ArnavStack(ccccc);
        Double one = 0.0;
        Double two = 0.0;

        for (int i=0; i<reverse_polish.size(); i++)  {
          //double check its location is it 1 number
            if (!OPERATORS.containsKey(reverse_polish.get(i))) {
                calculation.push(Double.parseDouble(reverse_polish.get(i)));
            } 
            else {
                if (NUMOPERANDS.get(reverse_polish.get(i)) == 1) {
                    one = (Double)(calculation.peek());
                    calculation.pop();
                } else {
                    // there are multiple operands here to deal with
                    one = (Double)(calculation.peek());
                    calculation.pop();
                    two = (Double)(calculation.peek());
                    calculation.pop();
                }
                switch(reverse_polish.get(i)) { 
                    case "+":
                        calculation.push((one + two));
                        break;
                    case "-":
                        calculation.push((two - one));
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
                    

                    }//switch

                }   //is operand
        
            }

          this.finalAnswer = (Double)calculation.peek();
          calculation.pop();
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

  public String toString() {
    return ("Here is everything for the operation! \n" +
            "Original expression: " + this.expression + "\n" +
            "Tokenized expression: " + this.tokens.toString() + "\n" +
            "Reverse Polish Notation: " + this.reverse_polish.toString() + "\n" +
            "Final result: " + String.format("%.4f", this.finalAnswer)) + "\n" + "\n";
  }

}