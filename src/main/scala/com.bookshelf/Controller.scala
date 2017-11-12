package com.bookshelf

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

@RestController
class Controller @Autowired()(service: MainService) {

  @RequestMapping(Array("/data"))
  def getData() = service.getData()

  @RequestMapping(method= Array(RequestMethod.POST),value = Array("/data"))
  def postData(@RequestBody newData: Model) = service.postData(newData)
}
