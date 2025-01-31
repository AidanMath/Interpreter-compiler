
package CraftingInterpreters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Scanner(String source){
        this.source=source;
    }
    
    List<Tokens> scanTokens(String source){
        while (!isAtEnd()){
            start = current;
            scanToken();
        }

        tokens.add(new Token(EOF, " ", null, line));
        return tokens;
    }
    private boolean isAtEnd(){
        if (current >= source.length) return true;
    }

    private void scanToken(){
        char c = advance();
        switch (c) {
            case '(' : addToken(LEFT_PAREN);
                break;
            case ')' : addToken(RIGHT_PAREN);
                break;
            case '{' : addToken(LEFT_BRACE);
                break;
            case '}' : addToken(RIGHT_BRACE);
                break;
            case ',' : addToken(COMMA);
                break;
            case '.' : addToken(DOT);
                break;
            case '-' : addToken(MINUS);
                break;
            case '+' : addToken(PLUS);
                break;
            case ';' : addToken(SEMICOLON);
                break;
            case '*' : addToken(STAR);
                break;

        }
    }
    
    
}

