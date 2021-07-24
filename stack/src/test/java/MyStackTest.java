import org.dslib.stack.MyStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyStackTest {

    private MyStack<Integer> integerStack;

    @BeforeEach
    public void init() {
        integerStack = new MyStack<>();
    }

    @Test
    public void newStack_isEmpty() {
        Assertions.assertTrue(integerStack.isEmpty());
    }

    @Test
    public void afterOnePush_stackIsNotEmpty() {
        integerStack.push(1);
        Assertions.assertFalse(integerStack.isEmpty());
    }

    @Test
    public void afterOnePushOnePop_stackBecomesEmpty() {
        integerStack.push(1);
        integerStack.pop();
        Assertions.assertTrue(integerStack.isEmpty());
    }
}
