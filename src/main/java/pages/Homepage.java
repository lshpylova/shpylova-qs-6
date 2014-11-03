package pages;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Lena on 29.10.2014.
 */
public class Homepage {
    public List<HashMap<String,Double>> product;

    public void buy(){}
    public void login(){}
    public void logout(){}
    public void openBasket(){}
    public void addToBasket(HashMap<String,Double>product){
        findProduct(product);
    }
    public void findProduct(HashMap<String,Double>product){

    }
}
