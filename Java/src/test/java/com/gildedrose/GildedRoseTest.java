package com.gildedrose;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @ParameterizedTest
    @MethodSource("goesDownByOneItems")
    public void qualityGoesDownByOne(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(previousQuality - 1);
    }

    static Stream<Item> goesDownByOneItems() {
        return Stream.of(new Item("foo", 0, 1),
                         new Item("foo", -1, 1),
                         new Item("foo", 1, 1),
                         new Item("foo", 5, 1),
                         new Item("foo", 6, 1),
                         new Item("foo", 7, 1),
                         new Item("foo", 10, 1),
                         new Item("foo", 11, 1),
                         new Item("foo", 12, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 0, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", -1, 1),
                         new Item("foo", 1, 49),
                         new Item("foo", 5, 49),
                         new Item("foo", 6, 49),
                         new Item("foo", 7, 49),
                         new Item("foo", 10, 49),
                         new Item("foo", 11, 49),
                         new Item("foo", 12, 49),
                         new Item("foo", 1, 50),
                         new Item("foo", 5, 50),
                         new Item("foo", 6, 50),
                         new Item("foo", 7, 50),
                         new Item("foo", 10, 50),
                         new Item("foo", 11, 50),
                         new Item("foo", 12, 50),
                         new Item("foo", 1, 51),
                         new Item("foo", 5, 51),
                         new Item("foo", 6, 51),
                         new Item("foo", 7, 51),
                         new Item("foo", 10, 51),
                         new Item("foo", 11, 51),
                         new Item("foo", 12, 51));
    }


    @ParameterizedTest
    @MethodSource("goesDownByTwoItems")
    public void qualityGoesDownByTwo(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(previousQuality - 2);
    }

    static Stream<Item> goesDownByTwoItems() {
        return Stream.of(new Item("foo", 0, 49),
                         new Item("foo", -1, 49),
                         new Item("foo", 0, 50),
                         new Item("foo", -1, 50),
                         new Item("foo", 0, 51),
                         new Item("foo", -1, 51));
    }

    @ParameterizedTest
    @MethodSource("goesUpByOneItems")
    public void qulaityGoesUpByOne(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(previousQuality + 1);
    }

    static Stream<Item> goesUpByOneItems() {
        return Stream.of(new Item("Aged Brie", 1, 0),
                         new Item("Aged Brie", 5, 0),
                         new Item("Aged Brie", 6, 0),
                         new Item("Aged Brie", 7, 0),
                         new Item("Aged Brie", 10, 0),
                         new Item("Aged Brie", 11, 0),
                         new Item("Aged Brie", 12, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0),
                         new Item("Aged Brie", 1, -1),
                         new Item("Aged Brie", 5, -1),
                         new Item("Aged Brie", 6, -1),
                         new Item("Aged Brie", 7, -1),
                         new Item("Aged Brie", 10, -1),
                         new Item("Aged Brie", 11, -1),
                         new Item("Aged Brie", 12, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 0, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", -1, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 11, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 12, -1),
                         new Item("Aged Brie", 1, 1),
                         new Item("Aged Brie", 5, 1),
                         new Item("Aged Brie", 6, 1),
                         new Item("Aged Brie", 7, 1),
                         new Item("Aged Brie", 10, 1),
                         new Item("Aged Brie", 11, 1),
                         new Item("Aged Brie", 12, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 12, 1),
                         new Item("Aged Brie", 0, 49),
                         new Item("Aged Brie", -1, 49),
                         new Item("Aged Brie", 1, 49),
                         new Item("Aged Brie", 5, 49),
                         new Item("Aged Brie", 6, 49),
                         new Item("Aged Brie", 7, 49),
                         new Item("Aged Brie", 10, 49),
                         new Item("Aged Brie", 11, 49),
                         new Item("Aged Brie", 12, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 12, 49));
    }


    @ParameterizedTest
    @MethodSource("goesUpByTwoItems")
    public void qualityGoesUpByTwo(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(previousQuality + 2);
    }

    static Stream<Item> goesUpByTwoItems() {
        return Stream.of(new Item("Aged Brie", 0, 0),
                         new Item("Aged Brie", -1, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 7, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0),
                         new Item("Aged Brie", 0, -1),
                         new Item("Aged Brie", -1, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 6, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 7, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 10, -1),
                         new Item("Aged Brie", 0, 1),
                         new Item("Aged Brie", -1, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 7, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1));
    }


    @ParameterizedTest
    @MethodSource("goesUpByThreeItems")
    public void qualityGoesUpByThree(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(previousQuality + 3);
    }

    static Stream<Item> goesUpByThreeItems() {
        return Stream.of(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 1, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 5, -1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1));
    }


    @ParameterizedTest
    @MethodSource("stableItems")
    public void qualityIsStable(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(previousQuality);
    }

    static Stream<Item> stableItems() {
        return Stream.of(new Item("foo", 0, 0),
                         new Item("foo", -1, 0),
                         new Item("foo", 1, 0),
                         new Item("foo", 5, 0),
                         new Item("foo", 6, 0),
                         new Item("foo", 7, 0),
                         new Item("foo", 10, 0),
                         new Item("foo", 11, 0),
                         new Item("foo", 12, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
                         new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 0, 0),
                         new Item("Sulfuras, Hand of Ragnaros", -1, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 1, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 5, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 6, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 7, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 10, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 11, 0),
                         new Item("Sulfuras, Hand of Ragnaros", 12, 0),
                         new Item("foo", 0, -1),
                         new Item("foo", -1, -1),
                         new Item("foo", 1, -1),
                         new Item("foo", 5, -1),
                         new Item("foo", 6, -1),
                         new Item("foo", 7, -1),
                         new Item("foo", 10, -1),
                         new Item("foo", 11, -1),
                         new Item("foo", 12, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 0, -1),
                         new Item("Sulfuras, Hand of Ragnaros", -1, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 1, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 5, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 6, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 7, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 10, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 11, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 12, -1),
                         new Item("Sulfuras, Hand of Ragnaros", 0, 1),
                         new Item("Sulfuras, Hand of Ragnaros", -1, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 1, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 5, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 6, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 7, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 10, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 11, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 12, 1),
                         new Item("Sulfuras, Hand of Ragnaros", 0, 49),
                         new Item("Sulfuras, Hand of Ragnaros", -1, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 1, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 5, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 6, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 7, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 10, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 11, 49),
                         new Item("Sulfuras, Hand of Ragnaros", 12, 49),
                         new Item("Aged Brie", 0, 50),
                         new Item("Aged Brie", -1, 50),
                         new Item("Aged Brie", 1, 50),
                         new Item("Aged Brie", 5, 50),
                         new Item("Aged Brie", 6, 50),
                         new Item("Aged Brie", 7, 50),
                         new Item("Aged Brie", 10, 50),
                         new Item("Aged Brie", 11, 50),
                         new Item("Aged Brie", 12, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 7, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 12, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 0, 50),
                         new Item("Sulfuras, Hand of Ragnaros", -1, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 1, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 5, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 6, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 7, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 10, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 11, 50),
                         new Item("Sulfuras, Hand of Ragnaros", 12, 50),
                         new Item("Aged Brie", 0, 51),
                         new Item("Aged Brie", -1, 51),
                         new Item("Aged Brie", 1, 51),
                         new Item("Aged Brie", 5, 51),
                         new Item("Aged Brie", 6, 51),
                         new Item("Aged Brie", 7, 51),
                         new Item("Aged Brie", 10, 51),
                         new Item("Aged Brie", 11, 51),
                         new Item("Aged Brie", 12, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 1, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 5, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 6, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 7, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 10, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 11, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 12, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 0, 51),
                         new Item("Sulfuras, Hand of Ragnaros", -1, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 1, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 5, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 6, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 7, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 10, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 11, 51),
                         new Item("Sulfuras, Hand of Ragnaros", 12, 51));
    }

}
