package com.bookshelf

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer


class ServletInitializer extends SpringBootServletInitializer {
  override protected def configure(application: SpringApplicationBuilder): SpringApplicationBuilder = application.sources(Application.getClass)
}