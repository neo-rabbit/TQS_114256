package tqs.start;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TqsStackTests 
{
    @Test
    void testStackEmptyOnConstruction(){
        TqsStack stack = new TqsStack();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void testStackSizeOnConstruction(){
        TqsStack stack = new TqsStack();
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    void testStackSizeNotEmpty(){
        TqsStack stack = new TqsStack();
        stack.push(1);
        stack.push("a");
        stack.push("1");
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    void testStackPushPop(){
        TqsStack stack = new TqsStack();
        stack.push("z");
        Object value = stack.pop();
        Assertions.assertEquals("z", value);
    }

    @Test
    void testStackPushPeek(){
        TqsStack stack = new TqsStack();
        stack.push("z");
        Object value = stack.peek();
        Assertions.assertEquals("z", value);
        Assertions.assertEquals(1, stack.size());
    }

    @Test
    void testStackPushPopMultiple(){
        TqsStack stack = new TqsStack();
        stack.push(1);
        stack.push("a");
        stack.push("1");
        stack.pop();
        stack.pop();
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    void testStackPopEmptyException(){
        TqsStack stack = new TqsStack();
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void testStackPeekEmptyException(){
        TqsStack stack = new TqsStack();
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.peek());
    }
}
