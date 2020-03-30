package com.mobiquity.rentaldvdstore.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.rentaldvdstore.controller.CustomerController;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.DeleteCustomerService;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(com.mobiquity.rentaldvdstore.controller.CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    ListingService listingService;
    @MockBean
    LoginService loginService;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    DeleteCustomerService deleteCustomerService;

    private Customer getCustomerObject(Long id, String fname, String lname, String email, Boolean active, String password,
                                       String mobno, Address address) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setActive(active);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobileNo(mobno);
        customer.setAddress(address);
        return customer;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testGetAllCustomers() throws Exception{

        mvc.perform(MockMvcRequestBuilders
                .get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllCustomersWithIncorrectAPI() throws Exception{

        mvc.perform(MockMvcRequestBuilders
                .get("/customer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetAllActiveCustomers() throws Exception{

        mvc.perform(MockMvcRequestBuilders
                .get("/active")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllActiveCustomersWithIncorrectAPI() throws Exception{

        mvc.perform(MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testCustomerLogin() throws Exception{
        String email="email";
        String password="password";
        mvc.perform(MockMvcRequestBuilders
                .get("/login")
                .param("password",password)
                .param("email",email)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testCustomerLoginWithIncorectAPI() throws Exception{
        String email="email";
        String password="password";
        mvc.perform(MockMvcRequestBuilders
                .get("/")
                .param("password",password)
                .param("email",email)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testCustomerLoginWithIncorrectParameterNames() throws Exception{
        String email="email";
        String password="password";
        mvc.perform(MockMvcRequestBuilders
                .get("/login")
                .param("Password",password)
                .param("Email",email)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testRegisterCustomer() throws Exception{

        Customer customer = getCustomerObject(1213L, "nisarg", "turke", "nisarg@mail.com",
                true, "abcW$1", "+919999999999", null);

        mvc.perform( MockMvcRequestBuilders
                .post("/registration")
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void testRegisterCustomerWithIncorrectAPI() throws Exception{

        Customer customer = getCustomerObject(1213L, "nisarg", "turke", "nisarg@mail.com",
                true, "abcW$1", "+919999999999", null);

        mvc.perform( MockMvcRequestBuilders
                .post("/")
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void testRegisterCustomerWithNullObject() throws Exception{

        mvc.perform( MockMvcRequestBuilders
                .post("/")
                .content(asJsonString(null))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void testDeleteCustomer() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .delete("/delete/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCustomerWithIncorrectId() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .delete("/delete/1L")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDeleteCustomerWithIncorrectAPI() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .delete("")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }


}
