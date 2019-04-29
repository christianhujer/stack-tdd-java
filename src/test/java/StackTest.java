import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setup() {
        stack = new Stack();
    }

    @Test
    void newStack_isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterOnePush_isNotEmpty() {
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test
    void poppingEmptyStack_throwsUnderflow() {
        assertThrows(Stack.Underflow.class, () -> stack.pop());
    }

    @Test
    void afterOnePushAndOnePop_isEmpty() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterTwoPushes_sizeIsTwo() {
        stack.push(0);
        stack.push(1);
        assertEquals(2, stack.getSize());
    }

    @Test
    void afterTwoPushesAndOnePop_sizeIsOne() {
        stack.push(0);
        stack.push(0);
        stack.pop();
        assertEquals(1, stack.getSize());
    }

    @Test
    void afterPushingX_stackPopsX() {
        stack.push(23);
        assertEquals(23, stack.pop());
        stack.push(42);
        assertEquals(42, stack.pop());
    }

    @Test
    void afterPushingXAndY_stackPopsYAndX() {
        stack.push(23);
        stack.push(42);
        assertEquals(42, stack.pop());
        assertEquals(23, stack.pop());
    }
}
