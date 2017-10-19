package org.beigesoft.graphic.service;

/*
 * Copyright (c) 2017 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import java.io.File;
import java.net.URL;

import android.graphics.BitmapFactory;

import org.beigesoft.graphic.model.AndroidImage;

/**
 * <p>Android image loader.</p>
 *
 * @author Yury Demidenko
 */
public class AndroidImageLoader implements IFctImageRgb {

  /**
   * <p>It loads image from file (file system or resource).</p>
   * @param pPath path e.g. /img/image1.png or /home/jon/pictures/photo1.jpg
   * @return IImageRgb
   * @throws Exception an Exception
   **/
  @Override
  public final AndroidImage loadImage(final String pPath) throws Exception {
    URL url = AndroidImageLoader.class.getResource(pPath);
    if (url != null) {
      return new AndroidImage(BitmapFactory
        .decodeStream(AndroidImageLoader.class.getResourceAsStream(pPath)));
    } else {
      File file = new File(pPath);
      if (!file.exists()) {
        throw new Exception("Image file not found: " + pPath);
      }
      return new AndroidImage(BitmapFactory.decodeFile(pPath));
    }
  }
}
