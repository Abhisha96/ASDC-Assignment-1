package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// stores the menuItem and price of each Items.
public class menuItem {
    // map - which binds the menuitemId with the corresponding menuitemId, menuitemName and menuitemPrice.
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

    /*
    Below methods are used for testing purpose. Because assertEquals compares the memory location
    of the objects. Therefore, it's override to ensure that it compares the values, instead of comparing
    the memory location.
    References
    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)
    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html#hashCode()
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        menuItem second = (menuItem) obj;
        return Objects.equals(menuitemId, second.menuitemId) &&
                Objects.equals(menuitemName, second.menuitemName) &&
                Objects.equals(menuitemPrice, second.menuitemPrice);
    }
    @Override
    public int hashCode() {
        return Objects.hash(menuitemId, menuitemName, menuitemPrice);
    }
}
