/*
 * Copyright 2009 Pentaho Corporation.  All rights reserved.
 * This software was developed by Pentaho Corporation and is provided under the terms
 * of the Mozilla Public License, Version 1.1, or any later version. You may not use
 * this file except in compliance with the license. If you need a copy of the license,
 * please go to http://www.mozilla.org/MPL/MPL-1.1.txt. The Original Code is the Pentaho
 * BI Platform.  The Initial Developer is Pentaho Corporation.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to
 * the license for the specific language governing your rights and limitations.
*/
package org.pentaho.metadata.model;

import java.util.ArrayList;
import java.util.List;

import org.pentaho.metadata.model.concept.Concept;

/**
 * The logical model contains logical tables and categories, and the name and description
 * are presented to end users.
 * 
 * @author Will Gorman (wgorman@pentaho.com)
 * 
 */
public class LogicalModel extends Concept {

  private static final long serialVersionUID = 4063396040423259880L;
  
  private List<LogicalTable> logicalTables = new ArrayList<LogicalTable>();
  private List<Category> categories = new ArrayList<Category>();

  public LogicalModel() {
    super();
  }
  
  // TODO: add security
  
  public List<LogicalTable> getLogicalTables() {
    return logicalTables;
  }

  public List<Category> getCategories() {
    return categories;
  }
  
  public Category findCategory(String categoryId) {
    for (Category category : getCategories()) {
      if (categoryId.equals(category.getId())) {
        return category;
      }
    }
    return null;
  }
  
  /**
   * finds a logical column within the model.
   * 
   * @param columnId the column to find
   * @return a logical column object.
   */
  public LogicalColumn findLogicalColumn(String columnId) {
    for (LogicalTable table : getLogicalTables()) {
      for (LogicalColumn column : table.getLogicalColumns()) {
        if (columnId.equals(column.getId())) {
          return column;
        }
      }
    }
    return null;
  }
  
}
