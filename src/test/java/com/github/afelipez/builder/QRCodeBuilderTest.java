package com.github.afelipez.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class QRCodeBuilderTest {

    @Test
    public void shouldThrowNPE_whenQRCodeBuilderConstructorParamIsNull() {
        assertThrows(NullPointerException.class,
                () -> new QRCodeBuilder(null));
    }
}
