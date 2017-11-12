package com.bookshelf

import org.apache.log4j.BasicConfigurator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class AppConfig


object Application extends App {
  BasicConfigurator.configure()
  SpringApplication.run(classOf[AppConfig])

}