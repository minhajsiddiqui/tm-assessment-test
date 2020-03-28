package com.filesloader.tm.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filesloader.tm.FileLoaderDaemonProp;
import com.filesloader.tm.contracts.Constants;
import com.filesloader.tm.dao.TeamTaskDAOImpl;

import org.apache.log4j.Logger;

import okhttp3.*;

public class TaskAssignmentService extends Thread {

    final static Logger logger = Logger.getLogger(FileMonitoringService.class);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teamDb");
    private EntityManager _entityManager;

    private ITeamTaskService _teamTaskService;

    public TaskAssignmentService() {
        _entityManager = entityManagerFactory.createEntityManager();

        _teamTaskService = new TeamTaskServiceImpl(new TeamTaskDAOImpl(_entityManager));
    }

    public void processTeamTasks() {

        // Get all related team tasks
        var teamTasksList = _teamTaskService.findAll();

        if (teamTasksList.size() > 0) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                String json = mapper.writeValueAsString(teamTasksList);

                postData(Constants.BASE_URL + Constants.API_ASSIGNMENT_RESULT, json);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // TODO: Extract it out to a http provider
    // which will be a common class for any one to call.
    private boolean postData(String url, String json) throws IOException {

        logger.info(
                "Getting ready to post data to rest - api at " + Constants.BASE_URL + Constants.API_ASSIGNMENT_RESULT);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder().url(url).post(body).build();

        Response response = client.newCall(request).execute();

        if (response.code() == 200) {
            logger.info("Successfully inserted assignement result in db");

            return true;
        } else {

            logger.error("Error while inserting assignement result in db");

            return false;
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                processTeamTasks();
                Thread.sleep(Integer.parseInt(FileLoaderDaemonProp.getInstance().getPropValues()
                        .get(Constants.TIME_TO_POST_ASSIGNMENT_RESULT_IN_SEC)));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }
}