package com.example.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.logging.Logger

@Controller
@RequestMapping("/guests")
class GuestController(val guestService: GuestService) {
    @Autowired
    private lateinit var logger: Logger

    @GetMapping("/all")
    fun showAll(model: Model): String {
        logger.info("request get all guests called")
        // The direct usage gives a warning, that the publisher is not used
        // model["guests"] = guestService.getAll()
        guestService.getAll().also { model["guests"] = it }
        return "guests"
    }
}