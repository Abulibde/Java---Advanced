package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class ShopTest {

    private static final Goods GOOD_1 = new Goods("Poli", "1");
    private static final Goods GOOD_2 = new Goods("Iliyan", "2");
    private static final Goods GOOD_3 = new Goods("Pesho", "3");
    private static final Goods GOOD_4 = new Goods("Poli", "4");


    private Shop shop;

    @Before
    public void setup() {
        shop = new Shop();
    }

    @Test
    public void test_createShop() {
        shop = new Shop();
        Map<String, Goods> shelves = shop.getShelves();

        assertEquals(12, shelves.size());
    }

    //addGood
    //1. shelf doesn't exist IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_addGood_onNonExistingShelf_shouldThrow() throws OperationNotSupportedException {
        shop.addGoods("none", GOOD_1);

    }

    //2. shelf is already taken IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_addGood_takenShelf_shouldThrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", GOOD_1);
        shop.addGoods("Shelves1", GOOD_1);
    }

    //3. Goods is already in shelf OperationNotSupportedException
    @Test(expected = OperationNotSupportedException.class)
    public void test_addGood_GoodAlreadyInShelf_shouldTrow() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", GOOD_1);
        shop.addGoods("Shelves2", GOOD_1);
    }

    //4. happy path - String.format("Goods: %s is placed successfully!"
    @Test
    public void test_addGood_Success() throws OperationNotSupportedException {

        assertEquals("Goods: 1 is placed successfully!", shop.addGoods("Shelves1", GOOD_1));
        assertNotNull(shop.getShelves().get("Shelves1"));
    }

    //removeGoods
    //1.shelf does not exist - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_removeGoods_withoutExistingShelf_shouldThrow() {
        shop.removeGoods("none", GOOD_2);
    }

    //2.goods in that shelf does not exist - IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void test_removeGoods_wrongShelf_shouldThrow(){
        shop.removeGoods("Shelves1",GOOD_2);
    }

    //3. happy path - success
    @Test
    public void test_removeGoods_success() throws OperationNotSupportedException {
        shop.addGoods("Shelves1",GOOD_1);
        assertEquals("Goods: 1 is removed successfully!", shop.removeGoods("Shelves1", GOOD_1));
        Assert.assertNull(shop.getShelves().get("Shelves1"));

    }


}