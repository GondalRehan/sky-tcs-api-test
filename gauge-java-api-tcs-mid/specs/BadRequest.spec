# BadRequest

tags: bad_request

This spec file details the interaction with the bad_request endpoint and the expected results
of those actions

## Bad Request is returned when doing a POST to the /bad_request endpoint

* Post to the "bad_request" endpoint
* Then the response will be "Bad Request"
* The response code should be "400"

## OK is returned when doing a GET to the /bad_request endpoint

* Get to the "bad_request" endpoint
* Then the response will be "OK"
* The response code should be "200"

## Details of the last response is returned when doing a GET to /bad_request/last endpoint
// Implement a step that checks the response contains the correct details
* Get to the "bad_request/last" endpoint
* Then the response will be "OK"
* The response code should be "200"
* Retrieve the details "bad_request" from the "bad_request/last" endpoint
* Then get a valid response
