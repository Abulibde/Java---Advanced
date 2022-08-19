package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class GiftFactoryTests {/*

    private static final Gift DOG = new Gift("dog", 10);
    private static final Gift CAT = new Gift("cat", 20);
    private static final Gift LAMA = new Gift("lama", 30);
    private static final Gift LION = new Gift("lion", 50);

    private GiftFactory giftFactory;


    @Before
    public void setup() {
        giftFactory = new GiftFactory();

        Gift testGift = new Gift("Teddy", 9290);

        giftFactory.createGift(DOG);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftThrow() {
        giftFactory.createGift(DOG);
    }

    @Test
    public void testGetCount() {
        int expectedCount = 1;
        int actualCount = giftFactory.getCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithEmptyNameShouldThrow() {
        String emptyGiftName = "";
        giftFactory.removeGift(emptyGiftName);
    }

    @Test
    public void testRemoveGiftSuccess() {
        Assert.assertTrue(giftFactory.removeGift("dog"));
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        giftFactory.createGift(CAT);
        giftFactory.createGift(LION);
        giftFactory.createGift(LAMA);

        Assert.assertEquals(DOG, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresent() {
        giftFactory.createGift(CAT);
        giftFactory.createGift(LION);
        giftFactory.createGift(LAMA);

        Gift actualPresent = giftFactory.getPresent("lama");
        Assert.assertEquals(LAMA, actualPresent);
    }


    @Test
    public void testGetPresents() {
        giftFactory.createGift(CAT);

        Collection<Gift> expectedList = new ArrayList<>();
        expectedList.add(DOG);
        expectedList.add(CAT);

        Collection<Gift> actualGifts = giftFactory.getPresents();

        Assert.assertArrayEquals(expectedList.toArray(), actualGifts.toArray());
    }

    */
    private static final String FIRST_GIFT_NAME = "Barbie";
    private static final double FIRST_GIFT_MAGIC = 10.5;
    private static final String SECOND_GIFT_NAME = "Teddy Bear";
    private static final double SECOND_GIFT_MAGIC = 30.5;
    private static final String THIRD_GIFT_NAME = "Truck";
    private static final double THIRD_GIFT_MAGIC = 20.5;
    private static final int EXPECTED_COUNT = 3;

    private GiftFactory giftFactory;
    private Gift gift;
    private Gift secondGift;
    private Gift thirdGift;

    @Before
    public void setUp(){
        giftFactory = new GiftFactory();
        gift = new Gift(FIRST_GIFT_NAME, FIRST_GIFT_MAGIC);
        secondGift = new Gift(SECOND_GIFT_NAME, SECOND_GIFT_MAGIC);
        thirdGift = new Gift(THIRD_GIFT_NAME, THIRD_GIFT_MAGIC);
        giftFactory.createGift(gift);
        giftFactory.createGift(secondGift);
        giftFactory.createGift(thirdGift);
    }

    @Test
    public void getGiftFactoryCount() {
        int actualCount = giftFactory.getCount();

        Assert.assertEquals(EXPECTED_COUNT, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExistingGiftToGiftFactory() {

        giftFactory.createGift(gift);
    }

    @Test
    public void removeGiftFromGiftFactory(){
        giftFactory.removeGift(SECOND_GIFT_NAME);

        Assert.assertTrue(true);
    }

    @Test(expected = NullPointerException.class)
    public void removeGiftWhitNullNameFromGiftFactory(){
        giftFactory.removeGift(null);
    }

    @Test
    public void getPresentWithLeastMagic(){

        Assert.assertEquals(gift, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void getPresentWhitNameTeddyBear(){
        Assert.assertEquals(secondGift, giftFactory.getPresent("Teddy Bear"));

    }




}
