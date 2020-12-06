package spotifywrapped.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spotifywrapped.model.TestModel;
import spotifywrapped.service.SpotifyService;

@Component
public class SpotifyServiceImpl implements SpotifyService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public TestModel getData(Integer id) {
        return callApi(id);
    }

    private TestModel callApi(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/todos/" + id;
        try {
            TestModel testModel = restTemplate.getForObject(url, TestModel.class);
            return testModel;
        }
        catch (Exception ex) {
            throw(ex);
        }
    }
}
