import java.util.Scanner;

public class assign8 {

    public static void main(String args[])
    {
         init();
         getoken(); //get initial token
         B();
         if (token == '=')
         {
             System.out.println("\nThe input text is syntactically correct");
             System.out.println();
             System.exit(0);
         }
         else
         {
             System.out.println("\nERROR: = expected");
             System.out.println();
             System.exit(1);
         }
    } //end main

    static Scanner keyboard;
    static char token; //lookahead token

    static void init()
    {
        keyboard=new Scanner(System.in);
        keyboard.useDelimiter("");
    }

    static void getoken()
    {
        token=keyboard.next().charAt(0);
        System.out.print(token); //echo input character
     
        while (token ==' ')
        {
            token=keyboard.next().charAt(0);
            System.out.print(token); //echo input character
        }
     
         if (
         token>='a' && token <= 'z' ||
         token=='|'||token=='&'     ||
         token=='('||token==')'     ||
         token=='!'||token=='=' ) ; //okay
        else //token is not a symbol in the alphabet
          { System.out.println("\nERROR: unrecognizable symbol in input");
            System.out.println();
            System.exit(1);
          } //end if
    } // end getpken
   
   //the methods for the parser appear below
   static void B()
   {
        C();
        while (token == '|')
        {
            getoken();
            C();
        }
        if(token == '=' || token == ')') ;
        else
        {
            System.out.println("\nERROR: = or ) expected");
            System.out.println();
            System.exit(1);
        }
   }

   static void C()
   {
        A();
        while(token == '&')
        {
            getoken();
            A();
        }
        if(token == '='|| token == ')' || token == '|') ;
        else
        {
            System.out.println("\nERROR: &, ), or | expected");
            System.out.println();
            System.exit(1);
        }
   }

   static void A()
   {
       if(token == '!')
        {
            getoken();
            A();
        }
       else if(token >='a' && token <= 'z')
       {
           getoken();
       }
        else if(token == '(')
        {
            getoken();
            B();
            if(token == ')')
            {
                getoken();
            }
            else
            {
                System.out.println("\nERROR: ) expected");
                System.out.println();
                System.exit(1);
            }
        }
        else
        {
            System.out.println("\nERROR: !, (, or an identifier expected");
            System.out.println();
            System.exit(1);
        }
   }

} //end class assign8

