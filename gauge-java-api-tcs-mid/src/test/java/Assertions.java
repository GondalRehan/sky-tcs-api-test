import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;

public class Assertions {

    @Step("The response code should be <response_code>")
    public void responseCodeShouldEqual(Integer response_code) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        Integer httpResponseCode = (Integer) dataStore.get("httpResponseCode");

        Assert.assertEquals(response_code, httpResponseCode);
    }

}
