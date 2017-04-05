package com.jihf.androidutils.tools.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-04-05 09:56
 * Mail：jihaifeng@raiyi.com
 */
public class CacheFileOutputStream extends FileOutputStream {
  File file;
  ACacheManager cacheManager;

  public CacheFileOutputStream(ACacheManager cacheManager, String key) throws FileNotFoundException {
    super(cacheManager.newFile(key));
    this.file = cacheManager.newFile(key);
    this.cacheManager = cacheManager;
  }

  public void close() throws IOException {
    super.close();
    cacheManager.put(file);
  }
}
