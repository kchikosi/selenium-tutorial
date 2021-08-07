package policycenter;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PCHomeTest {

    @Test
    public void home() throws IOException {
        PCHome pcHome = new PCHome();
        String loginUrl = pcHome.getHome();
        String homePage = "http://localhost:8180/pc/PolicyCenter.do";
        assertEquals("Unable to open URL " + homePage, loginUrl, homePage);
    }
}