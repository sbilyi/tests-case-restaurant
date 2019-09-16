package com.sbilyi.interviews.test.restaurant.main.controller

import com.sbilyi.interviews.test.restaurant.main.service.MenuItemService
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@ExtendWith(SpringExtension::class)
@WebMvcTest(MenuItemCRUDController::class)
class MenuItemCRUDControllerTest {

    val ID: Long = 1
    val userId: String = "sergii"

    @Autowired
    private val mvc: MockMvc? = null

    @MockBean
    private val service: MenuItemService? = null


}
