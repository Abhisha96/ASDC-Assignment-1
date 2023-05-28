package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// stores the menuItem and price of each dishes.
public class menuItem {
    //Map<String, > menuItemDetailsById;
    Map<String, menuItem> menuitemDetails;
    String menuitemName;
    Double menuitemPrice;
    String menuitemId;
    public menuItem(){
        menuitemDetails = new HashMap<>();
    }
    public menuItem(String menuitemId,String menuitemName, Double menuitemPrice){
        this.menuitemId = menuitemId;
        this.menuitemName = menuitemName;
        this.menuitemPrice = menuitemPrice;
    }
    void setMenuitemDetails( String menuitemId, String menuitemName,Double menuitemPrice){
        this.menuitemId = menuitemId;
        this.menuitemName = menuitemName;
        this.menuitemPrice = menuitemPrice;
        this.menuitemDetails.put(this.menuitemId,new menuItem(menuitemId,menuitemName,menuitemPrice));
    }
    Double getMenuitemPrice(String menuitemId){
        return menuitemDetails.get(menuitemId).menuitemPrice;
    }
    String getMenuitemName(String menuitemId){
        return menuitemDetails.get(menuitemId).menuitemName;
    }

    String getMenuitemId(String menuitemId)
    {
        return menuitemId;
    }
   /* Double getMenuitemDetails(String menuitemName){
        Double menuitemPrice = menuitemDetails.get(menuitemName);
        return menuitemPrice;
    }
    */
    Map getmenuItem(){
        return menuitemDetails;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        menuItem other = (menuItem) obj;
        return Objects.equals(menuitemId, other.menuitemId) &&
                Objects.equals(menuitemName, other.menuitemName) &&
                Objects.equals(menuitemPrice, other.menuitemPrice);
    }
    @Override
    public int hashCode() {
        return Objects.hash(menuitemId, menuitemName, menuitemPrice);
    }
}
