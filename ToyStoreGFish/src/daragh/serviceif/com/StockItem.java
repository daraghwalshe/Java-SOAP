
package daragh.serviceif.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stockItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stockItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toy" type="{http://com.serviceif.daragh/}toy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stockItem", propOrder = {
    "quantity",
    "toy"
})
public class StockItem {

    protected int quantity;
    protected Toy toy;

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the toy property.
     * 
     * @return
     *     possible object is
     *     {@link Toy }
     *     
     */
    public Toy getToy() {
        return toy;
    }

    /**
     * Sets the value of the toy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Toy }
     *     
     */
    public void setToy(Toy value) {
        this.toy = value;
    }

}
