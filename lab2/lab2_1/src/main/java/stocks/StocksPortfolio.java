package stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private IStockMarketService stockmarket;
    private List<Stock> stocks;
    StocksPortfolio(IStockMarketService market){
        this.stockmarket = market;
        this.stocks = new ArrayList<>();
    }
    public void addStock(Stock stock){
        stocks.add(stock);
    }
    public double totalValue() {
        double value = 0;
        for (Stock stock : stocks) {
            value += stock.getQuantity()*stockmarket.lookUpPrice(stock.getLabel());
        }
        return value;
    }
}
