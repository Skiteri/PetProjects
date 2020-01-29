package com.skitel.gaishnik;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {

    @Test
    public void random() {
//        Assert.assertTrue(number.);
    }

    @Test
    public void next() {
        Number number = new Number("С399ВА 116 RUS");
        number.next();
        Assert.assertEquals(number.toString(), "С400ВА 116 RUS");

        number = new Number("С999ВА 116 RUS");
        number.next();
        Assert.assertEquals(number.toString(), "С000ВВ 116 RUS");

        number = new Number("А001ОС 116 RUS");
        number.next();
        Assert.assertEquals(number.toString(), "А002ОС 116 RUS");

        number = new Number("В999МХ 116 RUS");
        number.next();
        Assert.assertEquals(number.toString(), "В000НА 116 RUS");

        number = new Number("В999ХС 116 RUS");
        number.next();
        Assert.assertEquals(number.toString(), "В000ХТ 116 RUS");
    }


}