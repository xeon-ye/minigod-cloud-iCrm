package com.minigod.persist.po;
import com.minigod.persist.tables.TShopTest;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 */
@Entity(table=TShopTest.class)
public class ShopTest implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String name;
	private BigDecimal price;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }
}