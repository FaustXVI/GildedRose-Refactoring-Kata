package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.quicktheories.core.Gen;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.quicktheories.generators.SourceDSL.strings;

@Disabled("testing")
public class PropertiesGildedRoseTest {

    private static final Set<String> SPECIAL_NAMES = Stream.of("Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert", "Aged Brie")
        .collect(Collectors.toSet());

    @Test
    public void nameNeverChanges() {
        qt()
            .forAll(items())
            .checkAssert(item -> {
                String previousName = item.name;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].name).isEqualTo(previousName);
            });
    }


    @Test
    public void qualityGoesDownByOneWhenSellInPositive() {
        qt()
            .forAll(items(integers().allPositive(), integers().allPositive()).assuming(
                i -> !SPECIAL_NAMES.contains(i.name)))
            .checkAssert(item -> {
                int previousQuality = item.quality;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].quality).isEqualTo(previousQuality - 1);
            });
    }

    @Test
    public void qualityNeverGoesLowerThanZero() {
        qt()
            .forAll(items(integers().allPositive()))
            .checkAssert(item -> {
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].quality).isGreaterThanOrEqualTo(0);
            });
    }

    @Test
    public void backstageQualityAlwaysGoesToZeroWhenSellinZeroOrNegative() {
        qt()
            .forAll(items("Backstage passes to a TAFKAL80ETC concert",
                          // FIXME : there is probably an overflow for integers thus the + 1
                          integers().between(Integer.MIN_VALUE + 1, 0)))
            .checkAssert(item -> {
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].quality).isEqualTo(0);
            });
    }

    @Test
    public void sulfurasQualityIsAlwaysStable() {
        qt()
            .forAll(items("Sulfuras, Hand of Ragnaros"))
            .checkAssert(item -> {
                Integer previousQuality = item.quality;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].quality).isEqualTo(previousQuality);
            });
    }

    @Test
    public void backstageQualityAlwaysGoesUpWhenSellinIsPositive() {
        qt()
            .forAll(items("Backstage passes to a TAFKAL80ETC concert", integers().allPositive()))
            .checkAssert(item -> {
                Integer previousQuality = item.quality;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].quality).isGreaterThanOrEqualTo(previousQuality);
            });
    }

    @Test
    public void agedBrieQualityAlwaysGoesUp() {
        qt()
            .forAll(items("Aged Brie"))
            .checkAssert(item -> {
                Integer previousQuality = item.quality;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].quality).isGreaterThanOrEqualTo(previousQuality);
            });
    }

    @Test
    public void sellInGoesDownByOneWhenNotSulfuras() {
        qt()
            .forAll(items()
                        .assuming(s -> !"Sulfuras, Hand of Ragnaros".equals(s.name)))
            .checkAssert(item -> {
                Integer previousSellIn = item.sellIn;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].sellIn).isEqualTo(previousSellIn - 1);
            });
    }

    @Test
    public void sulfurasSellInIsAlwaysStable() {
        qt()
            .forAll(items("Sulfuras, Hand of Ragnaros"))
            .checkAssert(item -> {
                Integer previousSellIn = item.sellIn;
                Item[] items = new Item[]{item};
                GildedRose app = new GildedRose(items);
                app.updateQuality();
                assertThat(app.items[0].sellIn).isEqualTo(previousSellIn);
            });
    }

    private Gen<Item> items() {
        return items(names(), sellIns(), qualities());
    }

    private Gen<Item> items(String name) {
        return items(constant(name), sellIns(), qualities());
    }

    private Gen<Item> items(Gen<Integer> qualities) {
        return items(names(), sellIns(), qualities);
    }

    private Gen<Item> items(String name, Gen<Integer> sellIns) {
        return items(constant(name), sellIns, qualities());
    }

    private Gen<Item> items(Gen<Integer> sellIns, Gen<Integer> qualities) {
        return items(names(), sellIns, qualities);
    }

    private Gen<Item> items(Gen<String> names, Gen<Integer> sellIns, Gen<Integer> qualities) {
        return names.zip(sellIns, qualities, Item::new);
    }

    private Gen<String> names() {
        return strings().allPossible()
                        .ofLengthBetween(0, 200);
    }

    private Gen<Integer> qualities() {
        return integers().all();
    }

    private Gen<Integer> sellIns() {
        return integers().all();
    }

    private static <T> Gen<T> constant(T value) {
        return randomnessSource -> value;
    }

}
