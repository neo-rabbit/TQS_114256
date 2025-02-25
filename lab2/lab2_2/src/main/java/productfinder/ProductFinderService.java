package productfinder;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductFinderService {
    private static String API_PRODUCTS = "link@url.com/";
    private ISimpleHttpClient httpClient;
    ProductFinderService(ISimpleHttpClient httpClient){
        this.httpClient = httpClient;
    }
    Optional<Product> findProductDetails(int id){
        String json = httpClient.doHttpGet(API_PRODUCTS + id);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Product product = objectMapper.readValue(json, Product.class);
            if(product.getId()>0){
                return Optional.of(product);
            }
            return Optional.empty();
        } catch(Exception e){
            return Optional.empty();
        }
    }
}
