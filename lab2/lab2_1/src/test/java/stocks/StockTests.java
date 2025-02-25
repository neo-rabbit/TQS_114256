package stocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockTests {

    @Mock
    IStockMarketService stockmarket;

    @InjectMocks
    StocksPortfolio stocksportfolio;

    @Test
    public void testTotalValue(){
        when(stockmarket.lookUpPrice("EBAY")).thenReturn(8.0);
        when(stockmarket.lookUpPrice("MSFT")).thenReturn(5.0);

        stocksportfolio.addStock(new Stock("EBAY", 9));
        stocksportfolio.addStock(new Stock("MSFT", 2));

        assertEquals(82, stocksportfolio.totalValue());
        verify(stockmarket, times(2)).lookUpPrice(anyString());
    }
}