package productfinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductFinderTests 
{
    @Mock
    ISimpleHttpClient httpClient;

    @InjectMocks
    ProductFinderService finder;

    @Test
    public void testFind(){
        when(httpClient.doHttpGet("link@url.com/3")).thenReturn("{\"id\":3,\"image\":\"\",\"description\":\"\",\"price\":50,\"title\":\"Mens Cotton Jacket\",\"category\":\"clothing\"}");
        Optional<Product> product = finder.findProductDetails(3);
        assertTrue(product.isPresent());
        Product p = product.get();
        assertEquals(3, p.getId());
        assertEquals("Mens Cotton Jacket", p.getTitle());
    }

    @Test
    public void testFindEmpty(){
        when(httpClient.doHttpGet("link@url.com/300")).thenReturn("{}");
        Optional<Product> product = finder.findProductDetails(300);
        assertFalse(product.isPresent());
    }
}
