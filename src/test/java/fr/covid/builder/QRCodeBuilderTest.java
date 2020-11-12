package fr.covid.builder;

import com.google.zxing.WriterException;
import fr.covid.Attestation;
import fr.covid.motif.MotifDeplacement;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QRCodeBuilderTest {

    @Test
    public void shouldThrowNPE_whenQRCodeBuilderConstructorParamIsNull(){
        assertThrows(NullPointerException.class,
                () -> new QRCodeBuilder(null));
    }
}
