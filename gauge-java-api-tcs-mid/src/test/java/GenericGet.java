import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.junit.Assert;

public class GenericGet {

    @Step("Retrieve the last updated time from the <endpoint> endpoint")
    public void GetEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<JsonNode> httpResponse;
        String url = "https://reference-tryout-api.herokuapp.com/" + endpoint;
        try {
            httpResponse = Unirest.get(url).header("content-type", "application/json").header("Accept", "*/*").asJson();
            dataStore.put("httpResponse", httpResponse);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            Gauge.writeMessage(httpResponseStatusText);
            Gauge.writeMessage(httpResponse.getBody().toString());
            String updatedTime = httpResponse.getBody().getObject().getJSONArray("internal_server_error").getJSONObject(0).get("lastUpdated").toString();
            dataStore.put("updatedTime", updatedTime);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    // Get to the "unauthorized" endpoint
    @Step("Get to the <endpoint> endpoint")
    public void justGetEndPoint(String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<String> httpResponse;
        String url = "https://reference-tryout-api.herokuapp.com/" + endpoint;
        Gauge.writeMessage(url);
        try {
            httpResponse = Unirest.get(url).header("Content-Type", "application/json").header("Accept", "*/*").asString();
            dataStore.put("httpResponse", httpResponse);
            Integer httpResponseCode = httpResponse.getStatus();
            dataStore.put("httpResponseCode", httpResponseCode);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            Gauge.writeMessage(httpResponse.getBody());
            Gauge.writeMessage(httpResponseStatusText);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Step("Assert against last updated time")
    public void AssertLastUpdatedTime() {
        // TODO
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        String httpUpdatedTime = (String) dataStore.get("updatedTime");
        Assert.assertNotNull(httpUpdatedTime);
    }

    @Step("Retrieve the details <details> from the <endpoint> endpoint")
    public void GetTheDetailsOfEndPoint(String details, String endpoint) {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        HttpResponse<JsonNode> httpResponse;
        String url = "https://reference-tryout-api.herokuapp.com/" + endpoint;
        try {
            httpResponse = Unirest.get(url).header("content-type", "application/json").header("Accept", "*/*").asJson();
            dataStore.put("httpResponse", httpResponse);
            String httpResponseStatusText = httpResponse.getStatusText();
            dataStore.put("httpResponseStatusText", httpResponseStatusText);
            Gauge.writeMessage(httpResponseStatusText);
            Gauge.writeMessage(httpResponse.getBody().toString());
            dataStore.put("updatedTime", httpResponse.getBody().getObject().getJSONArray(details).getJSONObject(0).get("lastUpdated").toString());
            dataStore.put("mediaTypeUsed", httpResponse.getBody().getObject().getJSONArray(details).getJSONObject(1).get("mediaTypeUsed").toString());
            dataStore.put("bodyReceived", httpResponse.getBody().getObject().getJSONArray(details).getJSONObject(1).get("bodyReceived").toString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    @Step("Then get a valid response")
    public void theExpectedResponseDetails() {
        DataStore dataStore = DataStoreFactory.getScenarioDataStore();
        Assert.assertNotNull((String) dataStore.get("updatedTime"));
        Assert.assertNotNull((String) dataStore.get("mediaTypeUsed"));
        Assert.assertNotNull((String) dataStore.get("bodyReceived"));
    }
}