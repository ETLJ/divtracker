package com.elovell.divtrackerrest.stockdata;

import com.elovell.divtrackerrest.dividend.DividendService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StockDataController.class)
public class StockDataControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockDataService stockDataService;

    @MockBean
    private StockDataResourceAssembler stockDataResourceAssembler;

    @MockBean
    private DividendService dividendService;

    @Test
    void test() throws Exception {
        mockMvc
                .perform(get("/stock/T"))
                .andExpect(status().isOk());
    }
}
