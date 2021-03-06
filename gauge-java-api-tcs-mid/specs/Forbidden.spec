# Forbidden

tags: forbidden

This spec file details the interaction with the forbidden endpoint and the expected results
of those actions

## Forbidden is returned when doing a POST to the /forbidden endpoint

* Post to the "forbidden" endpoint
* Then the response will be "Forbidden"
* The response code should be "403"

## OK is returned when doing a GET to the /forbidden endpoint

* Get to the "forbidden" endpoint
* Then the response will be "OK"
* The response code should be "200"

## Details of the last response is returned when doing a GET to /forbidden/last endpoint
// Implement a step that checks the response contains the correct details
* Get to the "forbidden/last" endpoint
* The response code should be "999"
* Retrieve the details "forbidden" from the "forbidden/last" endpoint
* Then get a valid response
