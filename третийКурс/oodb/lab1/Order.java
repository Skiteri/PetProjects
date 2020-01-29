import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "order")
public class Order {
    private int id;
    private List<Item> goods;

    public int getId() {
        return id;
    }

    @XmlElementWrapper(name = "goods")
    @XmlElement(name = "item")
    public List<Item> getGoods() {
        return goods;
    }

    public void setGoods(List<Item> goods) {
        this.goods = goods;
    }

    void addItemToList(Item item) {
        goods.add(item);
    }

    void removeItemFromList(Item item) {
        goods.remove(item);
    }

    public int calculateSum(){
        int sum = 0;
        for (Item i:goods) {
            sum += i.getPrice();
        }
        return sum;
    }
}
