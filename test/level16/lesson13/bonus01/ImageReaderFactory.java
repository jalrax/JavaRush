package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by repin.s on 09.02.2016.
 */
public class ImageReaderFactory
{

    public static ImageReader getReader(ImageTypes type)
    {
        if (ImageTypes.JPG.equals(type))
            return new JpgReader();
        if (ImageTypes.BMP.equals(type))
            return new BmpReader();
        if (ImageTypes.PNG.equals(type))
            return new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
