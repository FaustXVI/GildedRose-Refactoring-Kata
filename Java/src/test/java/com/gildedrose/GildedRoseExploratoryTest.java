package com.gildedrose;


import org.junit.jupiter.api.DynamicNode;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class GildedRoseExploratoryTest {

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


    //@TestFactory
    public Stream<DynamicNode> qualityVariation() {
        Map<String, Function<Integer, Predicate<Item>>> behaviours = new LinkedHashMap<>();
        behaviours.put("Sell in goes down by one", sellIn -> i -> i.sellIn == sellIn - 1);
        behaviours.put("Sell in goes constant", sellIn -> i -> i.sellIn == sellIn);
        behaviours.put("Undefined", noneApply(behaviours.values()));
        return behaviours.keySet()
                         .stream()
                         .map(behaviour -> dynamicContainer(behaviour, createTestsFor(behaviours.get(behaviour))));
    }

    private Stream<DynamicNode> createTestsFor(Function<Integer, Predicate<Item>> predicate) {
        List<DynamicNode> tests = new ArrayList<>();
        for (Integer quality : qualities) {
            for (String product : products) {
                for (Integer sellIn : sellIns) {
                    Item item = new Item(product, sellIn, quality);
                    Item copy = new Item(product, sellIn, quality) {
                        @Override
                        public String toString() {
                            return "$(new Item(\"" + name + "\", " + sellIn + ", " + quality + "))";
                        }
                    };
                    tests.add(dynamicTest("for " + item, () -> {
                        Item[] items = new Item[]{item};
                        GildedRose app = new GildedRose(items);
                        app.updateQuality();
                        if (predicate.apply(sellIn)
                                     .test(app.items[0])) {
                            System.out.println(copy + ",");
                        }
                    }));
                }
            }
        }
        return tests.stream();
    }

    private Function<Integer, Predicate<Item>> noneApply(Collection<Function<Integer, Predicate<Item>>> predicates) {
        List<Function<Integer, Predicate<Item>>> copy = new ArrayList<>(predicates);
        return quality -> i -> copy.stream()
                                   .map(f -> !f.apply(quality)
                                               .test(i))
                                   .reduce(true, Boolean::logicalAnd);
    }


}
