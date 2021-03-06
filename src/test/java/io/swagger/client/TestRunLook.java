package com.looker.lookr;
import io.swagger.client.api.ApiAuthApi;
import io.swagger.client.model.AccessToken;
import io.swagger.client.api.LookApi;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import org.junit.Test;


/**
 * Created by scott on 9/8/15.
 */

public class TestRunLook {
    @Test

    public void RunLook(){

        String client_id = "";
        String client_secret = "";
        String basePath = "";

        try {
            // instantiate ApiClient
            ApiClient apiClient = new ApiClient();

            // set api path
            apiClient.setBasePath(basePath);

            // instantiate AuthApi
            ApiAuthApi apiAuthApi = new ApiAuthApi(apiClient);

            // prepare token and secret for login
            AccessToken token = apiAuthApi.login(client_id, client_secret);

            Configuration config = new Configuration();

            // configure ApiClient
            config.setDefaultApiClient(apiClient);

            // add auth credentials to ApiClient
            config.getDefaultApiClient().addDefaultHeader("Authorization", "token " + token.getAccessToken());

            // prepare LookApi
            LookApi look = new LookApi();

            // run look
            System.out.println(look.runLook(((long) 2039), "json"));

        } catch(Exception e) {
            System.out.println("Exception thrown  :" + e);
        }
    }

}