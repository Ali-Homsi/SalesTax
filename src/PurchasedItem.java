public class PurchasedItem {
    public String name;
    public float price,priceWithTax;
    public Boolean isTaxable, isImported;
    public int count = 1;


    /********** constructor **********/
    public PurchasedItem(String name, float price,int count, Boolean isTaxable, Boolean isImported) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.isTaxable = isTaxable;
        this.isImported = isImported;
    }
    /********** getters **********/

    public float getPrice() {
        return price;
    }

    public float getPriceWithTax() {
        return priceWithTax;
    }



    /********** setters **********/
    public void setPriceWithTax(float priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    // calculates and returns the applicable tax for the item
    // updates the PriceWithTax attribute
    public float calculateTax (){
        float tax = 0;
        if (this.isTaxable) tax += round(this.getPrice()*10/100);
        if (this.isImported)tax += round(this.getPrice()*5/100);
        this.setPriceWithTax((this.getPrice()+tax)*this.count);
        return tax;
    }

    //rounds a value to the nearest 0.05
    private double round(double x){
        return Math.ceil(x/0.05) * 0.05;
    }

}
