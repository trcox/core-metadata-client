/*******************************************************************************
 * Copyright 2016-2017 Dell Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * @microservice: core-metadata-client
 * @author: Jim White, Dell
 * @version: 1.0.0
 *******************************************************************************/

package org.edgexfoundry.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.edgexfoundry.domain.meta.ScheduleEvent;

public interface ScheduleEventClient {
  @GET
  @Path("/{id}")
  ScheduleEvent scheduleEvent(@PathParam("id") String id);

  @GET
  List<ScheduleEvent> scheduleEvents();

  @GET
  @Path("/addressable/{addressableId}")
  List<ScheduleEvent> scheduleEventsForAddressable(
      @PathParam("addressableId") String addressableId);

  @GET
  @Path("/addressablename/{addressablename:.+}")
  List<ScheduleEvent> scheduleEventsForAddressableByName(
      @PathParam("addressablename") String addressablename);

  @GET
  @Path("/servicename/{servicename:.+}")
  List<ScheduleEvent> scheduleEventsForServiceByName(@PathParam("servicename") String servicename);

  @GET
  @Path("/name/{name:.+}")
  ScheduleEvent scheduleEventForName(@PathParam("name") String name);

  @POST
  @Consumes("application/json")
  String add(ScheduleEvent scheduleEvent);

  @PUT
  @Consumes("application/json")
  boolean update(ScheduleEvent scheduleEvent);

  @DELETE
  @Path("/id/{id}")
  boolean delete(@PathParam("id") String id);

  @DELETE
  @Path("/name/{name:.+}")
  boolean deleteByName(@PathParam("name") String name);

}
