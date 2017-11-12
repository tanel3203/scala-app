package com.bookshelf


import org.codehaus.jackson.annotate.JsonIgnoreProperties

import scala.beans.BeanProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Model {

  @BeanProperty
  var title: String = _

  @BeanProperty
  var date: String = _

  @BeanProperty
  var name: String = _

  override def toString : String = "Model{title=" + title +", date=" + date +", name=" + name +"}"
}
