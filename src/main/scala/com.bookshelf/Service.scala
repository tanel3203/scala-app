package com.bookshelf

import org.springframework.stereotype.Service

@Service
class MainService {

  def getData() = {
    "tere"
  }
  def postData(newData: Model) = {
    FirebaseDb.addToUsersTable(newData.title, newData)
  }
}
