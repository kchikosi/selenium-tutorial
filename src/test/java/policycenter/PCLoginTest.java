package policycenter;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PCLoginTest {

    @Test
    public void login() throws IOException {
        PCLogin pcLogin = new PCLogin();
        String loginUrl = pcLogin.login();
        String homePage = "http://localhost:8180/pc/PolicyCenter.do";
        assertEquals("Unable to open URL " + homePage, loginUrl, homePage);
    }
}