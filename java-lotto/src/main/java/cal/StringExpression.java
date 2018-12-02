package cal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpression {
    private String expression;

    public StringExpression(String expression) {
        if (expression == null) {
            throw new NullPointerException("계산식이 없습니다.");
        }
        this.expression = expression;
    }

    public Matcher getMatcher() {
        return Pattern.compile("//(.)\n(.*)").matcher(expression);
    }

    public String[] getExpression(String delemeter) {
        return expression.split(delemeter);
    }
}
