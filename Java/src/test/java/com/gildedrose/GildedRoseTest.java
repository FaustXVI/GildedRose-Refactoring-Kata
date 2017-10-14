package com.gildedrose;


import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @ParameterizedTest
    @MethodSource("goesDownByOneItems")
    void qulaityGoesDownByOne(Item item) {
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
    void qulaityGoesDownByTwo(Item item) {
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
    @MethodSource("goesToZeroItems")
    void qulaityGoesToZero(Item item) {
        Integer previousQuality = item.quality;
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    static Stream<Item> goesToZeroItems() {
        return Stream.of(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50),
                         new Item("Backstage passes to a TAFKAL80ETC concert", 0, 51),
                         new Item("Backstage passes to a TAFKAL80ETC concert", -1, 51));
    }


    @ParameterizedTest
    @MethodSource("goesUpByOneItems")
    void qulaityGoesUpByOne(Item item) {
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
    void qulaityGoesUpByTwo(Item item) {
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
    void qulaityGoesUpByThree(Item item) {
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
    void qulaityIsStable(Item item) {
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

    private static Iterable<String> products = asList("foo",
                                                      "Aged Brie",
                                                      "Backstage passes to a TAFKAL80ETC concert",
                                                      "Sulfuras, Hand of Ragnaros");

    private static Iterable<Integer> qualities = asList(0,
                                                        -1,
                                                        1,
                                                        49,
                                                        50,
                                                        51);

    private static Iterable<Integer> sellIns = asList(0,
                                                      -1,
                                                      1,
                                                      5,
                                                      6,
                                                      7,
                                                      10,
                                                      11,
                                                      12);

    private static <T> T named(String name, T e) {
        return (T) Proxy.newProxyInstance(GildedRoseTest.class.getClassLoader(), new Class[]{Function.class},
                                          (proxy, method, args) -> {
                                              if (method.getName()
                                                        .equals("toString")) return name;
                                              else return method.invoke(e, args);
                                          });
    }


    //@TestFactory
    public Stream<DynamicNode> qualityVariation() {
        List<DynamicNode> tests = new ArrayList<>();
        List<Function<Integer, Predicate<Item>>> predicates =
            asList(
                named("Quality goes down by one", quality -> i -> i.quality == quality - 1),
                named("Quality goes down by two", quality -> i -> i.quality == quality - 2),
                named("Quality goes to zero", quality -> i -> i.quality == 0 && quality > 2),
                named("Quality goes up by one", quality -> i -> i.quality == quality + 1),
                named("Quality goes up by two", quality -> i -> i.quality == quality + 2),
                named("Quality goes up by three", quality -> i -> i.quality == quality + 3),
                named("Quality is stable", quality -> i -> i.quality == quality)
            );
        for (Function<Integer, Predicate<Item>> predicate : predicates) {
            tests.add(dynamicContainer(predicate.toString(), forQualities(predicate)));
        }
        tests.add(dynamicContainer("Undefined", forQualities(noneApply(predicates))));
        return tests.stream();
    }

    private Function<Integer, Predicate<Item>> noneApply(List<Function<Integer, Predicate<Item>>> predicates) {
        return quality -> i -> {
            Boolean reduce = predicates.stream()
                                       .map(f -> f.apply(quality))
                                       .map(p -> !p.test(i))
                                       .reduce(true, Boolean::logicalAnd);
            return reduce;
        };
    }

    private List<DynamicNode> forQualities(Function<Integer, Predicate<Item>> assertion) {
        List<DynamicNode> tests = new ArrayList<>();
        for (Integer quality : qualities) {
            tests.add(dynamicContainer("With quality " + quality,
                                       forProducts(new ItemBuilder().withQuality(quality), assertion.apply(quality))));
        }
        return tests;
    }

    private List<DynamicNode> forProducts(ItemBuilder item, Predicate<Item> qualityAssertions) {
        List<DynamicNode> tests = new ArrayList<>();
        for (String product : products) {
            tests.add(
                dynamicContainer("for product " + product, forSellIns(qualityAssertions, item.withName(product))));
        }
        return tests;
    }

    private List<DynamicNode> forSellIns(Predicate<Item> qualityAssertions, ItemBuilder itemBuilder) {
        List<DynamicNode> tests = new ArrayList<>();
        for (Integer sellIn : sellIns) {
            Item item = itemBuilder.withSellIn(sellIn)
                                   .build();
            Item copy = itemBuilder.withSellIn(sellIn)
                                   .build();
            tests.add(
                DynamicTest.dynamicTest("for sell in " + sellIn, () -> {
                    Item[] items = new Item[]{item};
                    GildedRose app = new GildedRose(items);
                    app.updateQuality();
                    if (qualityAssertions.test(app.items[0])) {
                        System.out.println(copy + ",");
                    }
                }));
        }
        return tests;
    }

    private static class ItemBuilder {
        private String name;
        private Integer sellIn;
        private Integer quality;

        public Item build() {
            return new Item(name, sellIn, quality) {
                @Override
                public String toString() {
                    return "new Item(\"" + name + "\", " + sellIn + ", " + quality + ")";
                }
            };
        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withSellIn(Integer sellIn) {
            this.sellIn = sellIn;
            return this;
        }

        public ItemBuilder withQuality(Integer quality) {
            this.quality = quality;
            return this;
        }
    }
}
