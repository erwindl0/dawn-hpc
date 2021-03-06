/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.dawnsci.passerelle.cluster.service;

import java.io.File;
import java.util.Properties;


/**
 * This class should be part of a minimal common module for simple slice specification.
 * Then it could be shared between DataChunkSource and ClusterNodetransformer etc.
 * 
 * @author erwindl
 *
 */
public class SliceBean {
  private String dataSet;
  private String slice;
  private String shape;
  private File file;

  public SliceBean(String dataSet, String slice, String shape, File file) {
    this.dataSet = dataSet;
    this.slice = slice;
    this.shape = shape;
    this.file = file;
  }
  
  public static SliceBean fromProperties(Properties props) {
    String dataSet = props.getProperty(ScalarNames.DATASET);
    String slice = props.getProperty(ScalarNames.SLICE);
    String shape=props.getProperty(ScalarNames.SHAPE);
    String file=props.getProperty(ScalarNames.FILEPATH);
    return new SliceBean(dataSet, slice, shape, file!=null ? new File(file):null);
  }
  
  public Properties toProperties() {
    Properties props = new Properties();
    props.put(ScalarNames.DATASET, getDataSet());
    props.put(ScalarNames.SLICE, getSlice());
    props.put(ScalarNames.SHAPE, getShape());
    props.put(ScalarNames.FILEPATH, getFilePath());
    return props;
  }

  public String getDataSet() {
    return dataSet;
  }

  public File getFile() {
    return file;
  }
  
  public String getFilePath() {
    return file!=null?file.getAbsolutePath():"";
  }

  public String getSlice() {
    return slice;
  }

  public String getShape() {
    return shape;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((file == null) ? 0 : file.hashCode());
    result = prime * result + ((dataSet == null) ? 0 : dataSet.hashCode());
    result = prime * result + ((shape == null) ? 0 : shape.hashCode());
    result = prime * result + ((slice == null) ? 0 : slice.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "SliceBean [slice=" + slice + ", dataSet=" + dataSet + ", shape=" + shape + ", file=" + file + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SliceBean other = (SliceBean) obj;
    if (file == null) {
      if (other.file != null)
        return false;
    } else if (!file.equals(other.file))
      return false;
    if (shape == null) {
      if (other.shape != null)
        return false;
    } else if (!shape.equals(other.shape))
      return false;
    if (slice == null) {
      if (other.slice != null)
        return false;
    } else if (!slice.equals(other.slice))
      return false;
    return true;
  }
}
