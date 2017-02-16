package org.lpw.ranch.user;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.lpw.ranch.util.ServiceHelperTester;
import org.lpw.tephra.test.MockCarousel;
import org.lpw.tephra.test.MockHelper;
import org.lpw.tephra.test.TephraTestSupport;
import org.lpw.tephra.util.Thread;
import org.lpw.tephra.util.TimeUnit;

import javax.inject.Inject;
import java.util.Calendar;

/**
 * @author lpw
 */
public class UserHelperTest extends TephraTestSupport {
    @Inject
    private Thread thread;
    @Inject
    private MockHelper mockHelper;
    @Inject
    private MockCarousel mockCarousel;
    @Inject
    private ServiceHelperTester serviceHelperTester;
    @Inject
    private UserHelper userHelper;

    @Test
    public void get() {
        serviceHelperTester.get((UserHelperImpl) userHelper, "ranch.user");
    }

    @Test
    public void fill() {
        serviceHelperTester.fill((UserHelperImpl) userHelper, "ranch.user");
    }

    @Test
    public void sign() {
        while (Calendar.getInstance().get(Calendar.SECOND) > 55)
            thread.sleep(5, TimeUnit.Second);

        mockHelper.reset();
        mockHelper.mock("/carousel");
        mockCarousel.reset();
        mockCarousel.register("key", "{\"code\":0,\"data\":{\"id 1\":{\"id\":\"new id\",\"name\":\"carousel\"}}}");
        JSONObject object = userHelper.sign();
        Assert.assertTrue(object.isEmpty());

        mockCarousel.register("ranch.user.sign", "{\"code\":0,\"data\":{\"name\":\"sign\"}}");
        object = userHelper.sign();
        Assert.assertEquals(1, object.size());
        Assert.assertEquals("sign", object.getString("name"));
    }
}
