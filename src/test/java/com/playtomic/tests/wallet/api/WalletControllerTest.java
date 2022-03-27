package com.playtomic.tests.wallet.api;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.playtomic.tests.wallet.WalletConfiguration;
import com.playtomic.tests.wallet.exception.FunctionalException;
import com.playtomic.tests.wallet.service.IWalletService;

@SpringBootTest(classes = {WalletConfiguration.class})
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc
public class WalletControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	IWalletService service;
	
	
	@Test
	public void shouldReturnOk_getWalletById() throws Exception {
		
		//When
		Mockito.when(service.getBalanceByWalletId(Mockito.anyLong())).thenReturn(new BigDecimal(100));
		
		//Then
		mockMvc.perform(get("/wallet/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldThrow_FunctionalException_getWalletById() throws Exception {
		//When
		Mockito.when(service.getBalanceByWalletId(Mockito.anyLong())).thenThrow(FunctionalException.class);
		
		mockMvc.perform(get("/wallet/1").accept(MediaType.APPLICATION_JSON)).andExpect(e -> assertTrue(e.getResolvedException() instanceof FunctionalException));
	}
	
	
}
